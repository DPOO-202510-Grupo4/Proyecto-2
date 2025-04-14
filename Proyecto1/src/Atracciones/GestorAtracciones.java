package Atracciones;

import java.util.ArrayList;
import java.util.Date;

import Persistencias.PersistenciaEspectaculo;
import Persona.Empleado;
import Tiquetes.GestorTiquetes;
import restricciones.RestriccionesCultural;
import restricciones.RestriccionesMecanica;
import restricciones.Temporada;

public class GestorAtracciones {
    private ArrayList<AtraccionMecanica> atraccionesMecanicas;
    private ArrayList<AtraccionCultural> atraccionesCulturales;
    private ArrayList<Espectaculos> espectaculos;
    private static GestorAtracciones instancia;

    public GestorAtracciones() {
        this.atraccionesMecanicas = new ArrayList<>();
        this.atraccionesCulturales = new ArrayList<>();
        this.espectaculos = new ArrayList<>();
    }

    public static GestorAtracciones getInstancia() {
        if (instancia == null) {
            instancia = new GestorAtracciones();
        }
        return instancia;
    }

    // --- MÉTODOS ATRACCIONES MECÁNICAS ---

    public void registrarAtraccionMecanica(AtraccionMecanica atraccionMecanica) {
        this.atraccionesMecanicas.add(atraccionMecanica);
    }

    public ArrayList<AtraccionMecanica> atraccionesMecanicasPorUbicacion(String ubicacion) {
        ArrayList<AtraccionMecanica> resultado = new ArrayList<>();
        for (AtraccionMecanica a : atraccionesMecanicas) {
            if (a.getUbicacion().equalsIgnoreCase(ubicacion)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public void crearAtraccionMecanica(String ubicacion, String nombre, boolean deTemporada, boolean disponible,
            int cupoMax, int minEmpleados, String riesgo,
            RestriccionesMecanica restricciones, String temporadaIn) {
        GestorTiquetes gestor = GestorTiquetes.getInstancia();
        Temporada t = gestor.buscarTemporada(temporadaIn);
        ArrayList<Empleado> empleadosAsignados = new ArrayList<>();

        AtraccionMecanica atraccion = new AtraccionMecanica(
                nombre, ubicacion, cupoMax, minEmpleados, deTemporada,
                t, riesgo, restricciones, empleadosAsignados
        );

        registrarAtraccionMecanica(atraccion);
    }

    // --- MÉTODOS ATRACCIONES CULTURALES ---

    public void registrarAtraccionCultural(AtraccionCultural atraccionCultural) {
        this.atraccionesCulturales.add(atraccionCultural);
    }

    public ArrayList<AtraccionCultural> atraccionesCulturalesPorUbicacion(String ubicacion) {
        ArrayList<AtraccionCultural> resultado = new ArrayList<>();
        for (AtraccionCultural a : atraccionesCulturales) {
            if (a.getUbicacion().equalsIgnoreCase(ubicacion)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public void crearAtraccionCultural(String ubicacion, String nombre, boolean deTemporada, boolean disponible,
            int capacidad, int minEmpleados, RestriccionesCultural restricciones,
            String temporadaIn) {
        GestorTiquetes gestor = GestorTiquetes.getInstancia();
        Temporada t = gestor.buscarTemporada(temporadaIn);

        ArrayList<Temporada> disponibilidad = new ArrayList<>();
        ArrayList<Empleado> empleadosAsignados = new ArrayList<>();

        AtraccionCultural atraccion = new AtraccionCultural(
                nombre, ubicacion, capacidad, minEmpleados, deTemporada,
                t, disponibilidad, restricciones, empleadosAsignados
        );

        registrarAtraccionCultural(atraccion);
    }

    // --- MÉTODOS ESPECTÁCULOS ---
    public void crearEspectaculo(Date fecha, Date horaInicio, Date horaFin,String empresa,String nombre) {
    	Espectaculos nuevoEspectaculo = new Espectaculos(fecha, horaInicio, horaFin, empresa, nombre);
    	espectaculos.add(nuevoEspectaculo);;
    	PersistenciaEspectaculo.persistencia(nuevoEspectaculo);
    }
    public ArrayList<Espectaculos> obtenerEspectaculos() {
        return espectaculos;
    }

    // --- MÉTODOS COMUNES ---

    public ArrayList<Atraccion> atraccionesPorUbicacion(String ubicacion) {
        ArrayList<Atraccion> todas = new ArrayList<>();
        todas.addAll(atraccionesMecanicasPorUbicacion(ubicacion));
        todas.addAll(atraccionesCulturalesPorUbicacion(ubicacion));
        return todas;
    }

    public ArrayList<Atraccion> atraccionesDisponibles(String ubicacion) {
        ArrayList<Atraccion> disponibles = new ArrayList<>();
        for (AtraccionMecanica a : atraccionesMecanicas) {
            if (a.getUbicacion().equalsIgnoreCase(ubicacion) && a.estaDisponible()) {
                disponibles.add(a);
            }
        }
        for (AtraccionCultural a : atraccionesCulturales) {
            if (a.getUbicacion().equalsIgnoreCase(ubicacion) && a.estaDisponible()) {
                disponibles.add(a);
            }
        }
        return disponibles;
    }

    public Boolean puedeOperar(Atraccion atraccion, Date fecha) {
        return atraccion.estaDisponible() && atraccion.verificarMinimoEmpleados(fecha);
    }

    public ArrayList<Empleado> empleadosAsignados() {
        ArrayList<Empleado> empleados = new ArrayList<>();

        for (AtraccionMecanica a : atraccionesMecanicas) {
            empleados.addAll(a.getEmpleadosAsignados());
        }
        for (AtraccionCultural a : atraccionesCulturales) {
            empleados.addAll(a.getEmpleadosAsignados());
        }

        return empleados;
    }

    // --- GETTERS ---

    public ArrayList<AtraccionMecanica> getAtraccionesMecanicas() {
        return atraccionesMecanicas;
    }

    public ArrayList<AtraccionCultural> getAtraccionesCulturales() {
        return atraccionesCulturales;
    }

	public ArrayList<Espectaculos> getEspectaculos() {
		return espectaculos;
	}

    
}
