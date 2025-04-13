package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import Tiquetes.TiqueteDia;



public class PersistenciaTiqueteDia {

        private static final String NOMBREARCHIVO = "persistencia/tiquetes/tiquetes_dia.txt";

    public void crearArchivo(String nombreArchivo) {
        try {
            Files.createDirectories(Paths.get("persistencia"));
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }
    }

    public void persistencia(String nombre, TiqueteDia persistirTiqueteDia) {
        crearArchivo(nombre);
        guardarTiqueteDia(persistirTiqueteDia);
    }

    public void guardarTiqueteDia(TiqueteDia nombreTiqueteDia){

		
		try (BufferedWriter tiqueteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String tiqueteFormatoTexto = "Id del tiquete: " + nombreTiqueteDia.getIdTiquete() + 
            ", Categoría: " + nombreTiqueteDia.getCategoria() + ", Fue usado: " + nombreTiqueteDia.isUsado()
            + ", Fecha: " + nombreTiqueteDia.getFecha();
			tiqueteEscrito.write(tiqueteFormatoTexto);
			tiqueteEscrito.newLine();
            tiqueteEscrito.close();

		} catch(IOException e){
			System.err.println("No se pudo guardar el tiquete del dia");
		}
	}

}
