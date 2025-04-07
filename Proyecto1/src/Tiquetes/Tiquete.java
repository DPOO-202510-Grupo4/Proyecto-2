package Tiquetes;

import Persona.Cliente;

public abstract class Tiquete {
	protected String idTiquete;
	protected CategoriaTiquete categoria;
	protected boolean usado;

	private Cliente cliente;
	
	public Tiquete(String idTiquete, CategoriaTiquete categoria, boolean usado) {
		this.idTiquete = idTiquete;
		this.categoria = categoria;
		this.usado = usado;
	}
	
	public String getId() {
		return idTiquete;
	}

	public boolean isUsado() {
		return usado;
	}

	public void marcarComoUsado() {
		this.usado = true;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
}
