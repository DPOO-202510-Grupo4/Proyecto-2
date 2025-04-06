package Tiquetes;

import java.util.Date;

public class FastPass {
	private Date fecha;
	private boolean usado;
	private String idTiquete;

	public FastPass(Date fecha, boolean usado, String idTiquete) {
		this.fecha = fecha;
		this.usado = usado;
		this.idTiquete = idTiquete;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public String getIdTiquete() {
		return idTiquete;
	}

	public void setIdTiquete(String idTiquete) {
		this.idTiquete = idTiquete;
	}








	
}
