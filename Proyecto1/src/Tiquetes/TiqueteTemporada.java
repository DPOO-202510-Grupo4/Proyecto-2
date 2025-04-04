package Tiquetes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TiqueteTemporada extends Tiquete {
	private Date fechaInicio;
	private Date fechaFinal;
	private static final String NOMBREARCHIVO = "tiquetes_de_temporada.txt";
	public TiqueteTemporada(String idTiquete, String categoria, boolean usado, Date fechaInicio, Date fechaFinal) {
		super(idTiquete, categoria, usado);
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	












	public void persistencia(String nombre, TiqueteTemporada persistirTiquete){

		crearArchivo(nombre);
		guardarTiquete(persistirTiquete);
	}

	public void guardarTiquete(TiqueteTemporada nombreTiqueteTemporada){

		
		try (BufferedWriter tiqueteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String tiqueteFormatoTexto = idTiquete + "," + categoria + ", " + usado + ", " + fechaInicio + ", " + fechaFinal;
			tiqueteEscrito.write(tiqueteFormatoTexto);
			tiqueteEscrito.newLine();

		} catch(IOException e){
			System.err.println("No se pudo guardar el tiquete de temporada");
		}
	}	
}











