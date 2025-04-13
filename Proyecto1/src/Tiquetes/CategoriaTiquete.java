package Tiquetes;
import java.util.ArrayList;

import Atracciones.*;
public class CategoriaTiquete {
	private String nombre;
	private ArrayList<Atraccion> atraccionesDisponibles;
	private Double precioBase;
	public CategoriaTiquete(String nombre, ArrayList<Atraccion> atraccionesDisponibles, Double precioBase) {
	    this.nombre = nombre;
	    this.atraccionesDisponibles = atraccionesDisponibles;
	    this.precioBase = precioBase;
	}

	public Double getPrecioBase() {
	    return precioBase;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Atraccion> getAtraccionesDisponibles() {
		return atraccionesDisponibles;
	}


	
	

}
