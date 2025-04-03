package Atracciones;

import java.util.*;

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
		
	public boolean validarEdad() {
		
		if (edadMin > 0 && edadMin <= usuario.getEdad()) {
			return true;
		}
		
		return false;
		
	}
	
	
	}

	@Override
	public String toString() {
		return "AtraccionCultural [" + super.toString() + ", fecha = " + fecha + ", horario = " +  horario + "]";
	}
	
	
	
	
}
