package Atracciones;


import java.time.LocalDate;
import java.util.*;

import Persona.Empleado;
import Persona.Persona;
import restricciones.RestriccionesCultural;
import restricciones.Temporada;

public class AtraccionCultural extends Atraccion{
	
	private ArrayList<Temporada> disponibilidad;
	private RestriccionesCultural restricciones;
	
	public AtraccionCultural(String ubicacion, String nombre, Boolean deTemporada, Boolean diponible, int cupoMax,
			int minEmpleados, int edadMin, ArrayList<Temporada> disponibilidad, RestriccionesCultural restricciones) {
		super(ubicacion, nombre, deTemporada, diponible, cupoMax, minEmpleados);
		this.disponibilidad = disponibilidad;
		this.restricciones = restricciones;
	}

	
	public ArrayList<Temporada> getDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(ArrayList<Temporada> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	public RestriccionesCultural getRestricciones() {
		return restricciones;
	}


	public void setRestricciones(RestriccionesCultural restricciones) {
		this.restricciones = restricciones;
	}


	//@Override
	public boolean validarRestricciones() {
		
		return true;
	}
	
	//@Override
	public boolean validarTiquete(String tipoTiquete) {
		
		switch (getExclusividad()) {
			case "Familiar":
				return !tipoTiquete.equals("Básico");
			case "Oro":
				return tipoTiquete.equals("Oro") || tipoTiquete.equals("Diamante");
			case "Diamante":
				return tipoTiquete.equals("Diamante");
			default:
				return false;
				
			}
		}
		
	public boolean validarEdad(Persona persona) {

		LocalDate fechaHoy = LocalDate.now();
		
		int restaEdades = fechaHoy.getYear() - persona.getFechaNacimiento().getYear();

		if (restaEdades >= edadMin) {
			return true;
		}
		
		return false;
		
	}
	
	
	

	@Override
	public String toString() {
		return "AtraccionCultural [" + super.toString() + ", fecha = " + fecha + ", horario = " +  horario + "]";
	}

	public boolean estaDisponible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean verificarMinimoEmpleados(Date fecha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected ArrayList<Empleado> getEmpleadosAsignados() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
