package Tiquetes;

import java.util.Date;

public class TiqueteDia extends Tiquete {
	private Date Fecha;

	public TiqueteDia(String idTiquete, CategoriaTiquete categoria, boolean usado, Date fecha) {
		super(idTiquete, categoria, usado);
		Fecha = fecha;
	}

	public Date getFecha() {
		return Fecha;
	}

	@Override
	public double calcularPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}



	
	
}
