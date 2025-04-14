package Atracciones;

import java.util.ArrayList;
import Persona.Empleado;
import Persona.GestorPersonas;
import Tiquetes.GestorTiquetes;
import restricciones.RestriccionesCultural;
import restricciones.RestriccionesMecanica;
import restricciones.Temporada;

import java.util.Date;

import Atracciones.Atraccion;

public class GestorAtracciones {
	private ArrayList<AtraccionMecanica> atraccionesMecanicas;
	private ArrayList<AtraccionCultural> atraccionesCulturales;
	private static GestorAtracciones instancia;
	
	public GestorAtracciones() {
		this.atraccionesMecanicas = new ArrayList<>();
		this.atraccionesCulturales = new ArrayList<>();
	}
	public static GestorAtracciones getInstancia() {
        if (instancia == null) {
            instancia = new GestorAtracciones();
        }
        return instancia;
    }
	
	public void registrarAtraccionMecanica(AtraccionMecanica atraccionMecanica) {
	    this.atraccionesMecanicas.add(atraccionMecanica);
	}

	public void registrarAtraccionCutlural(AtraccionCultural atraccionCultural) {
	    this.atraccionesCulturales.add(atraccionCultural);
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

	public ArrayList<AtraccionCultural> atraccionesCulturalesPorUbicacion(String ubicacion) {
	    ArrayList<AtraccionCultural> resultado = new ArrayList<>();
	    for (AtraccionCultural a : atraccionesCulturales) {
	        if (a.getUbicacion().equalsIgnoreCase(ubicacion)) {
	            resultado.add(a);
	        }
	    }
	    return resultado;
	}
	
	public ArrayList<Atraccion> atraccionesPorUbicacion(String ubicacion) {
	    ArrayList<Atraccion> todas = new ArrayList<>();

	    todas.addAll(atraccionesMecanicasPorUbicacion(ubicacion));
	    todas.addAll(atraccionesCulturalesPorUbicacion(ubicacion));

	    return todas;
	}
	public ArrayList<Atraccion> atraccionesDisponibles(String ubicacion){
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
			
			registrarAtraccionCutlural(atraccion);
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
	public ArrayList<Espectaculos> obtenerEspectaculos() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<AtraccionMecanica> getAtraccionesMecanicas() {
		return atraccionesMecanicas;
	}
	public ArrayList<AtraccionCultural> getAtraccionesCulturales() {
		return atraccionesCulturales;
	}
	
}
