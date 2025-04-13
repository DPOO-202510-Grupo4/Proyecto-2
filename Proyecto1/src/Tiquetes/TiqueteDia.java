package Tiquetes;

import java.util.Date;

import Persona.Cliente;

public class TiqueteDia extends Tiquete {
	private Date Fecha;

	

	public TiqueteDia(String nombre, Double precioBase,  String idTiquete,
			CategoriaTiquete categoria, boolean usado, Cliente cliente, Date fecha) {
		super(nombre, precioBase, idTiquete, categoria, usado, cliente);
		Fecha = fecha;
	}

	public Date getFecha() {
		return Fecha;
	}

	@Override
	public double calcularPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}



	
	
}
