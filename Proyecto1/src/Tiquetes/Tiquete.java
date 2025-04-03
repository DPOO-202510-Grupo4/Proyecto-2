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
	

}
