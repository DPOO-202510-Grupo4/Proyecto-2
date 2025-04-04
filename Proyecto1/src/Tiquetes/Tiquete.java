package Tiquetes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Tiquete {
	protected String idTiquete;
	protected String categoria;
	protected boolean usado;
	private static final String TIQUETE_PERSISTENCIA = "persistencia/tiquetes.txt";
	
	public Tiquete(String idTiquete, String categoria, boolean usado) {
		super();
		this.idTiquete = idTiquete;
		this.categoria = categoria;
		this.usado = usado;
	}
	











	
    public void crearArchivo(String nombreArchivo){

        try {
            Files.createDirectories(Paths.get("persistencia"), null);
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()){
                archivo.createNewFile();
            }

        } catch(IOException e){
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }

        

    }





}
