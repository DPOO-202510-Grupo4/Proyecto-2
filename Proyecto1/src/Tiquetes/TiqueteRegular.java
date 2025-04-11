package Tiquetes;

import java.util.Date;

public class TiqueteRegular extends Tiquete{
	private Date fecha;
	

	public TiqueteRegular(String idTiquete, CategoriaTiquete categoria2, boolean usado, Date fecha) {
		super(idTiquete, categoria2, usado);
		this.fecha = fecha;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Override
	public double calcularPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}





}
