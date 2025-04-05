package Atracciones;

import java.util.ArrayList;
import java.util.Date;

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
		
	}
	public void registrarAtraccionCutlural(AtraccionCultural atraccionCultural) {
		
	}
	public ArrayList<AtraccionMecanica> atraccionesMecanicasPorUbicacion(String ubicacion){
		return 0;
	}
	public ArrayList<AtraccionCultural> atraccionesCulturalesPorUbicacion(String ubicacion){
		return 0;
	}
	public ArrayList<Atraccion> atraccionesPorUbicacion(String ubicacion) {
	    ArrayList<Atraccion> todas = new ArrayList<>();

	    todas.addAll(atraccionesMecanicasPorUbicacion(ubicacion));
	    todas.addAll(atraccionesCulturalesPorUbicacion(ubicacion));

	    return todas;
	}
	public ArrayList<Atraccion> atraccionesDisponibles(String ubicacion){
		return 0;
	}
	public Boolean puedeOperar(Atraccion atraccion, Date fecha) {
		return false;
	}
	public List<Empleado> empleadosAsignados(){
		return 0;
	}
	
	
	
}
