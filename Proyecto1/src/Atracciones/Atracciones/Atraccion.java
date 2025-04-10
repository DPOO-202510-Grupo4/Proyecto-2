package Atracciones.Atracciones;

import java.util.*;

public abstract class Atraccion {
	
	protected String ubicacion;
	protected int cupoMax;
	protected List<String> restricciones;
	protected String exclusividad;
	protected int minEmpleados = 3;
	protected int edadMin;
	protected String nombre;
	protected List<String> restriccionClima;
	protected boolean deTemporada;
	
	
	public Atraccion(String ubicacion, int cupoMax, List<String> restricciones, String exclusividad, int minEmpleados, int edadMin, 
			String nombre, List<String> restriccionClima, boolean deTemporada) {
		
		this.ubicacion = ubicacion;
		this.cupoMax = cupoMax;
		this.restricciones = restricciones;
		this.minEmpleados = minEmpleados;
		this.edadMin = edadMin;
		this.nombre = nombre;
		this.restriccionClima = restriccionClima;
		this.deTemporada = deTemporada;
		
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


	   





}

