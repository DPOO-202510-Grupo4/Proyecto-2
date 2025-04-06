package Tiquetes;

public abstract class Tiquete {
	protected String idTiquete;
	protected CategoriaTiquete categoria;
	protected boolean usado;
	
	public Tiquete(String idTiquete, CategoriaTiquete categoria, boolean usado) {
		this.idTiquete = idTiquete;
		this.categoria = categoria;
		this.usado = usado;
	}
	

}
