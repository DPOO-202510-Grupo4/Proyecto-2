package Tiquetes;

import java.util.Date;

public class TiqueteTemporada extends Tiquete {
	private Date fechaInicio;
	private Date fechaFinal;
	public TiqueteTemporada(String idTiquete, String categoria, boolean usado, Date fechaInicio, Date fechaFinal) {
		super(idTiquete, categoria, usado);
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	
}
