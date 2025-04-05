package Tiquetes;

import java.util.Date;

import restricciones.Temporada;

public class TiqueteTemporada extends Tiquete {
	private Temporada temporada;
	public TiqueteTemporada(String idTiquete, String categoria, boolean usado, Date fechaInicio, Date fechaFinal) {
		super(idTiquete, categoria, usado);
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	
}
