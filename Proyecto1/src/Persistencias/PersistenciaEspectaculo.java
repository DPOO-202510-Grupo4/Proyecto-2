package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Atracciones.Espectaculos;

public class PersistenciaEspectaculo {

    private static final String NOMBREARCHIVO = "persistencia/espectaculos.txt";

    public void crearArchivo(String nombreArchivo){

    try {
        Files.createDirectories(Paths.get("persistencia"));
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()){
            archivo.createNewFile();
        }
        

    } catch(IOException e){
        System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
    }

}

    public void persistencia(String nombre, Espectaculos persistirEspectaculo){

		crearArchivo(nombre);
		guardarEspectaculo(persistirEspectaculo);
	}

	public void guardarEspectaculo(Espectaculos nombreEspectaculo){

		
		try (BufferedWriter atraccionEscrita = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String atraccionFormatoTexto = nombreEspectaculo.getHorario() + "," + nombreEspectaculo.getEmpresaEncargada();
			atraccionEscrita.write(atraccionFormatoTexto);
			atraccionEscrita.newLine();
            atraccionEscrita.close();

		} catch(IOException e){
			System.err.println("No se pudo guardar el espectáculo");
		}

	}
	






}
