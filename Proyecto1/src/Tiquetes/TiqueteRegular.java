package Tiquetes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TiqueteRegular extends Tiquete{
	private Date fecha;
	private static final String NOMBREARCHIVO = "tiquetes_regulares.txt";

	public TiqueteRegular(String idTiquete, String categoria, boolean usado,Date fecha) {
		super(idTiquete, categoria, usado);
		this.fecha = fecha;
	}




	public void persistencia(String nombre, TiqueteRegular persistirTiquete){

		crearArchivo(nombre);
		guardarTiquete(persistirTiquete);
	}

	public void guardarTiquete(TiqueteRegular nombreTiqueteRegular){

		
		try (BufferedWriter tiqueteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String tiqueteFormatoTexto = idTiquete + "," + categoria + ", " + usado + ", " + fecha;
			tiqueteEscrito.write(tiqueteFormatoTexto);
			tiqueteEscrito.newLine();

		} catch(IOException e){
			System.err.println("No se pudo guardar el tiquete regular");
		}
	}	
}
