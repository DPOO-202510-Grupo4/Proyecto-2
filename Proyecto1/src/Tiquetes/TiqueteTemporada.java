package Tiquetes;


import restricciones.Temporada;

public class TiqueteTemporada extends Tiquete {
	private Temporada temporada;

	
	public TiqueteTemporada(String idTiquete, CategoriaTiquete categoria, boolean usado, Temporada temporada) {
		super(idTiquete, categoria, usado);
		this.temporada = temporada;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	@Override
	public double calcularPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}


	

	

	
	
}
