package Persona;
import java.util.ArrayList;
import java.util.List;
import Tiquetes.Tiquete;
import Tiquetes.FastPass;
import Tiquetes.Factura;
import java.time.LocalDate;

public class Cliente extends Persona {
	public ArrayList<Factura> historialCompras;
	public ArrayList<Tiquete> tiquetes;
	public ArrayList<FastPass> fastPass;
	
	public Cliente(String nombre, String login, String password) {
	    super(nombre, login, password, null);
	    this.historialCompras = new ArrayList<>();
	    this.tiquetes = new ArrayList<>();
	    this.fastPass = new ArrayList<>();
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
	public ArrayList<Factura> getHistorialCompras() {
		return historialCompras;
	}
	public void setHistorialCompras(ArrayList<Factura> historialCompras) {
		this.historialCompras = historialCompras;
	}
	public ArrayList<Tiquete> getTiquetes() {
		return tiquetes;
	}
	public void setTiquetes(ArrayList<Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}
	public ArrayList<FastPass> getFastPass() {
		return fastPass;
	}
	public void setFastPass(ArrayList<FastPass> fastPass) {
		this.fastPass = fastPass;
	}
	
}


