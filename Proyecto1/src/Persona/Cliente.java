package Persona;
import java.util.ArrayList;

import Tiquetes.*;

public class Cliente extends Persona {
	private ArrayList<Factura> historialCompras;
	private ArrayList<Tiquete> tiquetes;
	private ArrayList<FastPass> fastPass;
	
	public Cliente(String nombre, String login, String password, ArrayList<Factura> historialCompras,
			ArrayList<Tiquete> tiquetes, ArrayList<FastPass> fastPass) {
		super(nombre, login, password);
		this.historialCompras = historialCompras;
		this.tiquetes = tiquetes;
		this.fastPass = fastPass;
	}
	
	
}

