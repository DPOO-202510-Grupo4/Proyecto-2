package Tiquetes;

import java.util.*;

import Atracciones.Atraccion;
import Persona.*;
import restricciones.Temporada;

public class GestorTiquetes {
    // ======================
    // Atributos
    // ======================
    private HashMap<Cliente, List<Tiquete>> tiquetesVendidos;
    private ArrayList<CategoriaTiquete> categoriasDisponibles;
    private List<Temporada> temporadas;
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

    public Tiquete crearTiqueteTemporada(Cliente cliente, String tipoCategoria, Temporada temporada) {
        CategoriaTiquete categoria = buscarCategoria(tipoCategoria);
        if (categoria == null) return null;

        TiqueteTemporada t = new TiqueteTemporada(
            UUID.randomUUID().toString(),
            categoria,
            false,
            temporada
        );

        agregarTiqueteACliente(cliente, t);
        return t;
    }

    public Tiquete crearTiqueteDia(Cliente cliente, String tipoCategoria, Date fecha) {
        CategoriaTiquete categoria = buscarCategoria(tipoCategoria);
        if (categoria == null) return null;

        TiqueteDia t = new TiqueteDia(
            UUID.randomUUID().toString(),
            null, null, tipoCategoria,
            categoria,
            false,
            cliente,
            fecha
        );

        agregarTiqueteACliente(cliente, t);
        return t;
    }

    public void usarTiquete(Tiquete tiquete) {
        tiquete.marcarComoUsado();
    }

    public ArrayList<Tiquete> getTiquetesDeCliente(Cliente cliente) {
        return new ArrayList<>(tiquetesVendidos.getOrDefault(cliente, new ArrayList<>()));
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

    // ======================
    // Métodos PRIVADOS auxiliares
    // ======================

    private CategoriaTiquete buscarCategoria(String tipoCategoria) {
        for (CategoriaTiquete cat : categoriasDisponibles) {
            if (cat.getNombre().equalsIgnoreCase(tipoCategoria)) {
                return cat;
            }
        }
        return null;
    }

    private void agregarTiqueteACliente(Cliente cliente, Tiquete tiquete) {
        tiquetesVendidos.computeIfAbsent(cliente, k -> new ArrayList<>()).add(tiquete);
    }
}
