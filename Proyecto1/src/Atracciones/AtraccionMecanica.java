package Atracciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Persona.Empleado;
import restricciones.RestriccionesMecanica;

public class AtraccionMecanica extends Atraccion {

	private String riesgo;
	private RestriccionesMecanica restricciones;
	

	public AtraccionMecanica(String ubicacion, String nombre, Boolean deTemporada, Boolean diponible, int cupoMax,
			int minEmpleados, String riesgo, RestriccionesMecanica restricciones) {
		super(ubicacion, nombre, deTemporada, diponible, cupoMax, minEmpleados);
		this.riesgo = riesgo;
		this.restricciones = restricciones;
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

	public List<String> getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(List<String> restricciones){
		this.restricciones = restricciones;
	}

	public int getEdadMin(){
		return edadMin;
	}
	
	public void setEdadMin(int edadMin){
		this.edadMin = edadMin;
	}

	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public List<String> getRestriccionClima(){
		return restriccionClima;
	}

	public void setRestriccionClima(List<String> restriccionClima){
		this.restriccionClima = restriccionClima;
	}

	public boolean getDeTemporada(){
		return deTemporada;
	}

	public void setDeTemporada(boolean deTemporada){
		this.deTemporada = deTemporada;
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

	public boolean usarAtraccion(String tiquete, String clima, int altura, int peso, int numEmpleados){

		if (validarRestricciones() && validarTiquete(tiquete) && validarAlturaYPeso(altura, peso) && puedeOperarSegunClima(clima) && puedeOperarSegunNumEmpleados(numEmpleados)){
			return true;
		}

		return false;


	}
	
	public String toString() {
		return "AtraccionMecanica [" + super.toString() + ", riesgo=" + riesgo + 
	               ", peso máximo =" + pesoMax + ", peso mínimo =" + pesoMin + 
	               ", altura máxima =" + alturaMax + ", altura mínima =" + alturaMin + "]";
		
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



	