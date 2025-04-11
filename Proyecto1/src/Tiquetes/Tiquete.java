package Tiquetes;

import Persona.Cliente;

public abstract class Tiquete extends ItemVenta{
	protected String idTiquete;
	protected CategoriaTiquete categoria;
	protected boolean usado;

	private Cliente cliente;
	
	public Tiquete(String idTiquete, CategoriaTiquete categoria2, boolean usado) {
		this.idTiquete = idTiquete;
		this.categoria = categoria2;
		this.usado = usado;
	}

	public String getIdTiquete() {
		return idTiquete;
	}

	public void setIdTiquete(String idTiquete) {
		this.idTiquete = idTiquete;
	}

	public CategoriaTiquete getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaTiquete categoria) {
		this.categoria = categoria;
	}

	public boolean isUsado1() {
		return usado;
	}

	public void setUsado(boolean usado) {
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
