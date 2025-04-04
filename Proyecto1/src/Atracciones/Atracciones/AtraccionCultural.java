package Atracciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import Persona.Persona;

public class AtraccionCultural extends Atraccion{
	
	public Date fecha;
	public Date horario;
	private static final String NOMBREARCHIVO = "atracciones_culturales.txt";
	
	AtraccionCultural(String ubicacion, int cupoMax, List<String> restricciones, String exclusividad, int minEmpleados, int edadMin, 
			String nombre, List<String> restriccionClima, boolean deTemporada, Date fecha, Date horario){
		
		super(ubicacion, cupoMax, restricciones, exclusividad, minEmpleados, edadMin, nombre, restriccionClima, deTemporada);
		
		this.fecha = fecha;
		this.horario = horario;
		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	@Override
	public boolean validarRestricciones() {
		
		return true;
	}
	
	@Override
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
	
	public void persistencia(String nombre, AtraccionCultural persistirAtraccion){

		crearArchivo(nombre);
		guardarAtraccion(persistirAtraccion);
	}

	public void guardarAtraccion(AtraccionCultural nombreAtraccionCultural){

		
		try (BufferedWriter atraccionEscrita = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String atraccionFormatoTexto = ubicacion + "," + cupoMax + ", " + restricciones + ", " + exclusividad + ", " 
			+ minEmpleados + ", " + edadMin + ", " + nombre + ", " + restriccionClima + ", " + deTemporada + ", " + fecha + ", " +
			horario;
			atraccionEscrita.write(atraccionFormatoTexto);
			atraccionEscrita.newLine();

		} catch(IOException e){
			System.err.println("No se puedo guardar la atracción");
		}
	}
	
	
}
