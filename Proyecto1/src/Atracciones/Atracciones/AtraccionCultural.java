package Atracciones.Atracciones;


import java.time.LocalDate;
import java.util.*;

import Persona.Persona;

public class AtraccionCultural extends Atraccion{
	
	public Date fecha;
	public Date horario;
	
	
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCupoMax() {
		return cupoMax;
	}

	public void setCupoMax(int cupoMax) {
		this.cupoMax = cupoMax;
	}

	public List<String> getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(List<String> restricciones) {
		this.restricciones = restricciones;
	}

	public String getExclusividad() {
		return exclusividad;
	}

	public void setExclusividad(String exclusividad) {
		this.exclusividad = exclusividad;
	}

	public int getMinEmpleados() {
		return minEmpleados;
	}

	public void setMinEmpleados(int minEmpleados) {
		this.minEmpleados = minEmpleados;
	}

	public int getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getRestriccionClima() {
		return restriccionClima;
	}

	public void setRestriccionClima(List<String> restriccionClima) {
		this.restriccionClima = restriccionClima;
	}
	
	public boolean getDeTemporada() {
		return deTemporada;
	}

	public void setDeTemporada(boolean deTemporada) {
		this.deTemporada = deTemporada;
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
	

	
}
