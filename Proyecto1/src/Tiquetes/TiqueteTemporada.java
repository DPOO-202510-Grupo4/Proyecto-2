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
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	}
	













