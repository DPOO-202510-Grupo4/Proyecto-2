package Persona;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import Tiquetes.Tiquete;
import Tiquetes.FastPass;
import Tiquetes.Factura;

public class Cliente extends Persona {

	public List<Factura> historialCompras;
	public ArrayList<Tiquete> tiquetes;
	public ArrayList<FastPass> fastPass;

	public Cliente(String nombre, String login, String password, Date fechaNacimiento) {
		this.tiquetes = new ArrayList<>();
		super(nombre, login, password, fechaNacimiento);	
	}

	public void agregarTiquete(Tiquete tiquete) {
		this.tiquetes.add(tiquete);
	}

	public void agregarFastPass(FastPass fastPass) {
		this.fastPass.add(fastPass);
	}

	public void agregarFactura(Factura factura) {
		this.historialCompras.add(factura);
	}

	public void consultarAtraccion() {

	}

	public void consultarEspectaculo() {
		
	}
}

