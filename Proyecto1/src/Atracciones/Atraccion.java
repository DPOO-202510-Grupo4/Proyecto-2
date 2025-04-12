package Atracciones;

import java.util.*;

import Persona.Empleado;
import restricciones.RestriccionesCultural;

public abstract class Atraccion {
	
	protected String ubicacion;
	protected String nombre;
	protected Boolean deTemporada;
	protected Boolean diponible;
	protected int cupoMax;
	protected int minEmpleados;

	
	public Atraccion(String ubicacion, String nombre, Boolean deTemporada, Boolean diponible, int cupoMax,
			int minEmpleados) {
		super();
		this.ubicacion = ubicacion;
		this.nombre = nombre;
		this.deTemporada = deTemporada;
		this.diponible = diponible;
		this.cupoMax = cupoMax;
		this.minEmpleados = minEmpleados;
		
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


	protected abstract boolean verificarMinimoEmpleados(Date fecha);


	protected abstract boolean estaDisponible();
	
	protected abstract ArrayList<Empleado> getEmpleadosAsignados();


	   





}

