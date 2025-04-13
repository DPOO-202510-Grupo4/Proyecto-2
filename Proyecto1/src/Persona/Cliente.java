package Persona;
import java.util.ArrayList;
import java.util.List;
import Tiquetes.Tiquete;
import Tiquetes.FastPass;
import Tiquetes.Factura;
import java.time.LocalDate;

public class Cliente extends Persona {

	public List<Factura> historialCompras;
	public ArrayList<Tiquete> tiquetes;
	public ArrayList<FastPass> fastPass;

	public Cliente(String nombre, String login, String password, LocalDate fechaNacimiento,
			List<Factura> historialCompras, ArrayList<Tiquete> tiquetes, ArrayList<FastPass> fastPass) {
		super(nombre, login, password, fechaNacimiento);
		this.historialCompras = historialCompras;
		this.tiquetes = tiquetes;
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

}

