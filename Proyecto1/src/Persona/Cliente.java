package Persona;
import java.util.ArrayList;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import Tiquetes.Tiquete;
import Tiquetes.FastPass;
import Tiquetes.Factura;
import java.time.LocalDate;

public class Cliente extends Persona {

	public Cliente(String nombre, String login, String password, LocalDate fechaNacimiento) {
		super(nombre, login, password, fechaNacimiento);
		
	}



}
	public List<Factura> historialCompras;
	public ArrayList<Tiquete> tiquetes;
	public ArrayList<FastPass> fastPass;

	public Cliente(String nombre, String login, String password, Date fechaNacimiento) {
		this.tiquetes = new ArrayList<>();
		super(nombre, login, password, fechaNacimiento);	
		this.fastPass = fastPass;
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

