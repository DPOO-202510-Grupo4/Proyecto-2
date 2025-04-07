package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import Persona.Factura;


public class PersistenciaFactura {

    private static final String NOMBREARCHIVO = "persistencia/factura.txt";

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

    public void persistencia(String nombre, Factura persistirFactura) {
        crearArchivo(nombre);
        guardarFactura(persistirFactura);
    }

    public void guardarFactura(Factura nombreFactura){

		
		try (BufferedWriter tiqueteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String tiqueteFormatoTexto = "Tiquete: " + nombreFactura.getTiquete() + 
            ", Cliente: " + nombreFactura.getCliente();
			tiqueteEscrito.newLine();
            tiqueteEscrito.close();

		} catch(IOException e){
			System.err.println("No se pudo guardar el tiquete del dia");
		}
	}


}
