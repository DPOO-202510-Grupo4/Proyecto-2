package Atracciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AtraccionMecanica extends Atraccion {

	public String riesgo;
	public String exclusividad;
	public int pesoMin = 40;
	public int pesoMax = 400;
	public int alturaMin = 150;
	public int alturaMax = 200;
	private static final String NOMBREARCHIVO = "atracciones_mecanicas.txt";
	
	public AtraccionMecanica(String ubicacion, int cupoMax, List<String> restricciones, String exclusividad,
			int minEmpleados, int edadMin, String nombre, List<String> restriccionClima, boolean deTemporada,
			String riesgo, String exclusividad2, int pesoMin, int pesoMax, int alturaMin, int alturaMax) {
		super(ubicacion, cupoMax, restricciones, exclusividad, minEmpleados, edadMin, nombre, restriccionClima,
				deTemporada);
		
		this.riesgo = riesgo;
		exclusividad = exclusividad2;
		this.pesoMin = pesoMin;
		this.pesoMax = pesoMax;
		this.alturaMin = alturaMin;
		this.alturaMax = alturaMax;
	}

	public String getRiesgo() {
		return riesgo;
	}

	public void setRiesgo(String riesgo) {
		this.riesgo = riesgo;
	}

	public String getExclusividad() {
		return exclusividad;
	}

	public void setExclusividad(String exclusividad) {
		this.exclusividad = exclusividad;
	}

	public int getPesoMin() {
		return pesoMin;
	}

	public void setPesoMin(int pesoMin) {
		this.pesoMin = pesoMin;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(int pesoMax) {
		this.pesoMax = pesoMax;
	}

	public int getAlturaMin() {
		return alturaMin;
	}

	public void setAlturaMin(int alturaMin) {
		this.alturaMin = alturaMin;
	}

	public int getAlturaMax() {
		return alturaMax;
	}

	public void setAlturaMax(int alturaMax) {
		this.alturaMax = alturaMax;
	}


	
	public boolean validarRestricciones() {
		
		return false;
		
	}
	
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
		
	public boolean validarAlturaYPeso(int altura, int peso) {
		
		boolean alturaValida = (altura >= alturaMin && altura <= alturaMax);
		boolean pesoValido = (peso >= pesoMin && peso <= pesoMax);
		
		return alturaValida && pesoValido;
	}
		
	
	public boolean puedeOperarSegunClima(String clima) {
		
		if (clima.equalsIgnoreCase("tormenta") || clima.equalsIgnoreCase("tormenta eléctrica")) {
			return false;
		}
		
		return true;
		
	}
	
	public boolean puedeOperarSegunNumEmpleados(int cantidadEmpleadosActuales) {
		
		if (cantidadEmpleadosActuales >= getMinEmpleados()){
			return true;
		}
		
		return false;
	}

	public boolean usarAtraccion(String tiquete, String clima, int altura, int peso){

		if (validarRestricciones() && validarTiquete(tiquete) && validarAlturaYPeso(altura, peso) && puedeOperarSegunClima(clima) && puedeOperarSegunNumEmpleados())



	}
	
	public String toString() {
		return "AtraccionMecanica [" + super.toString() + ", riesgo=" + riesgo + 
	               ", peso máximo =" + pesoMax + ", peso mínimo =" + pesoMin + 
	               ", altura máxima =" + alturaMax + ", altura mínima =" + alturaMin + "]";
		
		}


	


	public void persistencia(String nombre, AtraccionMecanica persistirAtraccion){

		crearArchivo(nombre);
		guardarAtraccion(persistirAtraccion);
	}

	public void guardarAtraccion(AtraccionMecanica nombreAtraccionMecanica){

		
		try (BufferedWriter atraccionEscrita = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String atraccionFormatoTexto = ubicacion + "," + cupoMax + ", " + restricciones + ", " + exclusividad + ", " + minEmpleados + ", " + edadMin + ", " + nombre + ", " + restriccionClima + ", " + deTemporada + ", " 
			+ riesgo + ", " + pesoMin + ", " + pesoMax + ", " + alturaMin + ", " + String.valueOf(alturaMax);
			atraccionEscrita.write(atraccionFormatoTexto);
			atraccionEscrita.newLine();

		} catch(IOException e){
			System.err.println("No se puedo guardar la atracción");
		}
	}


	}
	