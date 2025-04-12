package Tiquetes;
import java.util.ArrayList;

import Atracciones.*;
public class CategoriaTiquete {
	private String nombre;
	private ArrayList<Atraccion> atraccionesDisponibles;
	private Double precioBase;
	public CategoriaTiquete(String nombre, ArrayList<Atraccion> atraccionesDisponibles) {
		super();
		this.nombre = nombre;
		this.atraccionesDisponibles = atraccionesDisponibles;
	}
	public String getNombre() {
		
		return this.nombre;
	}
	

}
