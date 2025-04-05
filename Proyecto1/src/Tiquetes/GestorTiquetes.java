package Tiquetes;
import java.util.ArrayList;
import java.util.HashMap;

import Persona.*;

public class GestorTiquetes {
	private HashMap<Tiquete, Cliente> tiquetesVendidos;
	private ArrayList<CategoriaTiquete> categoriasDisponibles;
	public GestorTiquetes(Hashmap<Tiquete, Cliente> tiquetesVendidos,
			ArrayList<CategoriaTiquete> categoriasDisponibles) {
		super();
		this.tiquetesVendidos = tiquetesVendidos;
		this.categoriasDisponibles = categoriasDisponibles;
	}
	public Tiquete crearTiqueteTemporada() {
		return null;
		
	}
	public Tiquete crearTiqueteDia() {
		return null;}
	public void UsarTiquete() {}
	public ArrayList<Tiquete> getTiquetesCliente(Cliente cliente){
		return 0;}

}
