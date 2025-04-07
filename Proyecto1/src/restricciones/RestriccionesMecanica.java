package restricciones;

import java.util.ArrayList;

public class RestriccionesMecanica extends Restricciones {
	private int alturaMin;
	private int alturaMax;
	private int pesoMin;
	private int pesoMax;
	private ArrayList<String> salud;
	
	public RestriccionesMecanica(ArrayList<String> clima, String exclusividad, int alturaMin, int alturaMax,
			int pesoMin, int pesoMax, ArrayList<String> salud) {
		super(clima, exclusividad);
		this.alturaMin = alturaMin;
		this.alturaMax = alturaMax;
		this.pesoMin = pesoMin;
		this.pesoMax = pesoMax;
		this.salud = salud;
		
	}
	
	
	
	
	

}
