package Tiquetes;

import java.util.Date;

public class TiqueteRegular extends Tiquete{
	private Date fecha;
	

	public TiqueteRegular(String idTiquete, String categoria, boolean usado, Date fecha) {
		super(idTiquete, categoria, usado);
		this.fecha = fecha;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}





}
