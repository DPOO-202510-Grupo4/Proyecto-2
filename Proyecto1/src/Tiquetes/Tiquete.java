package Tiquetes;

public abstract class Tiquete {
	protected String idTiquete;
	protected String categoria;
	protected boolean usado;
	
	public Tiquete(String idTiquete, String categoria, boolean usado) {
		super();
		this.idTiquete = idTiquete;
		this.categoria = categoria;
		this.usado = usado;
	}

	public String getIdTiquete() {
		return idTiquete;
	}

	public void setIdTiquete(String idTiquete) {
		this.idTiquete = idTiquete;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}
	

















}
