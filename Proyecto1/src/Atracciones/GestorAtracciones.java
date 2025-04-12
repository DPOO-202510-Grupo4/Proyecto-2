package Atracciones;

import java.util.ArrayList;
import Persona.Empleado;
import java.util.Date;

import Atracciones.Atraccion;

public class GestorAtracciones {
	private ArrayList<AtraccionMecanica> atraccionesMecanicas;
	private ArrayList<AtraccionCultural> atraccionesCulturales;
	
	public GestorAtracciones(ArrayList<AtraccionMecanica> atraccionesMecanicas,
			ArrayList<AtraccionCultural> atraccionesCulturales) {
		super();
		this.atraccionesMecanicas = atraccionesMecanicas;
		this.atraccionesCulturales = atraccionesCulturales;
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
	}}
	
	
	
}
