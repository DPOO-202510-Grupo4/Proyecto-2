package Tiquetes;

import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import Atracciones.Atraccion;
import Persistencias.PersistenciaTemporada;
import Persistencias.PersistenciaTiqueteRegular;
import Persistencias.PersistenciaTiqueteTemporada;
import Persona.Cliente;
import restricciones.Temporada;

public class GestorTiquetes {
    // ======================
    // Atributos
    // ======================
    private HashMap<String, ArrayList<Tiquete>> tiquetesVendidos;
    private ArrayList<CategoriaTiquete> categoriasDisponibles;
    private ArrayList<Temporada> temporadas;
    private static GestorTiquetes instancia;

    // ======================
    // Singleton e inicialización
    // ======================
    private GestorTiquetes() {
        this.tiquetesVendidos = new HashMap<>();
        this.categoriasDisponibles = new ArrayList<>();
        this.temporadas = new ArrayList<>();
    }

    public static GestorTiquetes getInstancia() {
        if (instancia == null) {
            instancia = new GestorTiquetes();
        }
        return instancia;
    }

    // ======================
    // Gestión de TIQUETES
    // ======================


    public Tiquete crearTiqueteTemporada(Cliente cliente, String nombreCategoria, Temporada temporada ) {
    	ArrayList<CategoriaTiquete> categorias = getCategoriasDisponibles();
        CategoriaTiquete categoria = null;
        for (CategoriaTiquete c : categorias) {
            if (c.getNombre().equalsIgnoreCase(nombreCategoria)) {
                categoria = c;
                break;
            }
        }

        if (categoria == null) {
            System.out.println("Categoría no encontrada: " + nombreCategoria);
            return null;
        }
    	
        TiqueteTemporada t = new TiqueteTemporada("Tiquete " + categoria.getNombre(), categoria.getPrecioBase() , UUID.randomUUID().toString(), categoria, false,cliente, temporada);
        
        PersistenciaTiqueteTemporada.persistencia(t);
        agregarTiqueteACliente(cliente, t);
        return t;
    }


    public Tiquete crearTiqueteRegular(Cliente cliente, String nombreCategoria, Date fecha) {
 
        ArrayList<CategoriaTiquete> categorias = getCategoriasDisponibles();
        CategoriaTiquete categoria = null;
        for (CategoriaTiquete c : categorias) {
            if (c.getNombre().equalsIgnoreCase(nombreCategoria)) {
                categoria = c;
                break;
            }
        }

        if (categoria == null) {
            System.out.println("Categoría no encontrada: " + nombreCategoria);
            return null;
        }

        TiqueteRegular t = new TiqueteRegular(
            "Tiquete " + categoria.getNombre(),
            categoria.getPrecioBase(),
            UUID.randomUUID().toString(),
            categoria,
            false,
            cliente,
            fecha
        );
        PersistenciaTiqueteRegular.persistencia(t);
        agregarTiqueteACliente(cliente, t);
        return t;
    }
    

    public void usarTiquete(Tiquete tiquete) {
        tiquete.marcarComoUsado();
    }

    public ArrayList<Tiquete> getTiquetesDeCliente(Cliente cliente) {
        return new ArrayList<>(tiquetesVendidos.getOrDefault(cliente, new ArrayList<>()));
    }
    public Tiquete buscarTiquetePorId(String id) {
        for (ArrayList<Tiquete> listaTiquetes : tiquetesVendidos.values()) {
            for (Tiquete t : listaTiquetes) {
                if (t.getId().equals(id)) {
                    return t;
                }
            }
        }
        return null;
    }

    // ======================
    // Gestión de CATEGORÍAS de TIQUETE
    // ======================

    public boolean crearCategoriaTiquete(String nombre, ArrayList<Atraccion> atraccionesDisponibles, Double precioBase) {
        if (buscarCategoria(nombre) != null) {
            return false; 
        }

        CategoriaTiquete nueva = new CategoriaTiquete(nombre, atraccionesDisponibles, precioBase);
        categoriasDisponibles.add(nueva);
        return true;
    }

    public ArrayList<CategoriaTiquete> getCategoriasDisponibles() {
        return categoriasDisponibles;
    }


    // ======================
    // Gestión de TEMPORADAS
    // ======================
    public void crearTemporada(Date fechaInicio, Date fechaFinal, String nombre) {
        if (fechaInicio == null || fechaFinal == null || nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Los parámetros de la temporada son inválidos.");
        }

        if (fechaInicio.after(fechaFinal)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha final.");
        }

        Temporada temporada = new Temporada(fechaInicio, fechaFinal, nombre);
        temporadas.add(temporada);
        PersistenciaTemporada.guardarTemporada(temporada);

        System.out.println("Temporada creada exitosamente: " + temporada.getName());
    }

    public List<Temporada> obtenerTemporadas() {
        return temporadas;
    }

    public void consultarTemporadas() {
        if (temporadas.isEmpty()) {
            System.out.println("No hay temporadas registradas.");
        } else {
            for (Temporada temporada : temporadas) {
                System.out.println(temporada.getName() + " - Inicio: " + temporada.getFechaInicio() + " - Fin: " + temporada.getFechaFinal());
            }
        }
    }

    public void cargarTemporada(Date fechaInicio, Date fechaFinal, String nombre) {
    	if (fechaInicio == null || fechaFinal == null || nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Los parámetros de la temporada son inválidos.");
        }

        if (fechaInicio.after(fechaFinal)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha final.");
        }

        Temporada temporada = new Temporada(fechaInicio, fechaFinal, nombre);
        temporadas.add(temporada);

        System.out.println("Temporada creada exitosamente: " + temporada.getName());
    }

    // ======================
    // Métodos PRIVADOS auxiliares
    // ======================

    public CategoriaTiquete buscarCategoria(String tipoCategoria) {
        for (CategoriaTiquete cat : categoriasDisponibles) {
            if (cat.getNombre().equalsIgnoreCase(tipoCategoria)) {
                return cat;
            }
        }
        return null;
    }

    private void agregarTiqueteACliente(Cliente cliente, Tiquete tiquete) {
    	ArrayList<Tiquete> tiquetesUsuario = tiquetesVendidos.get(cliente.getLogin());
    	tiquetesUsuario.add(tiquete);
        cliente.agregarTiquete(tiquete);
    }

	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}


	public HashMap<String, ArrayList<Tiquete>> getTiquetesVendidos() {
		return tiquetesVendidos;
	}
	
	public Temporada buscarTemporada(String temporadaIn) {
	    
	    ArrayList<Temporada> temporadas = getTemporadas();

	    for (Temporada t : temporadas) {
	        if (t.getName().equalsIgnoreCase(temporadaIn)) {
	            return t;
	        }
	    }

	    return null; // No se encontró la temporada
	}
    
    public static GestorTiquetes getInstance() {
        if (instancia == null) {
            instancia = new GestorTiquetes();
        }
        return instancia;
    }
}
