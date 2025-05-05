package Tiquetes;

import java.time.LocalDate;

import Persona.Cliente;

public class TiqueteRegular extends Tiquete{
	private LocalDate fecha;

	public TiqueteRegular(String nombre, Double precioBase, String idTiquete,
			CategoriaTiquete categoria, boolean usado, Cliente cliente, LocalDate fecha) {
		super(nombre, precioBase, idTiquete, categoria, usado, cliente);
		this.fecha = fecha;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	@Override
	public double calcularPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}





}
