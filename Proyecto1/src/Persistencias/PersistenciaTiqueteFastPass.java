package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Persona.Persona;
import Tiquetes.FastPass;
import Tiquetes.TiqueteTemporada;

public class PersistenciaTiqueteFastPass {

    private static final String NOMBREARCHIVO = "tiquetes_fastpass.txt";

        public void crearArchivo(String nombreArchivo) {
        try {
            Files.createDirectories(Paths.get("persistencia"), null);
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }
    }

    public void persistencia(String nombre, FastPass persistirTiqueteFastPass) {
        crearArchivo(nombre);
        guardarTiqueteFastPass(persistirTiqueteFastPass);
    }

    	public void guardarTiqueteFastPass(FastPass nombreTiqueteFastPass){

		
		try (BufferedWriter tiqueteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String tiqueteFormatoTexto = "Id del tiquete: " + nombreTiqueteFastPass.getIdTiquete() + 
            ", Fue usado: " + nombreTiqueteFastPass.isUsado()
            + ", Fecha: " + nombreTiqueteFastPass.getFecha();
			tiqueteEscrito.write(tiqueteFormatoTexto);
			tiqueteEscrito.newLine();
            tiqueteEscrito.close();

		} catch(IOException e){
			System.err.println("No se pudo guardar el tiquete FastPass");
		}
	}
}
