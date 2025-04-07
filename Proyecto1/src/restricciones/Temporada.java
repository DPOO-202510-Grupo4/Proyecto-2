package restricciones;

import java.util.Date;

public class Temporada {
	private Date fechaInicio;
	private Date fechaFinal;
	private String name;
	public Temporada(Date fechaInicio, Date fechaFinal, String name) {
		
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.name = name;
	}
 
}
