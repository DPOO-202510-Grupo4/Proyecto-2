package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Atracciones.AtraccionCultural;

public class PersistenciaAtraccionCultural {

    private static final String NOMBREARCHIVO = "atracciones_culturales.txt";


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

    public void persistencia(String nombre, AtraccionCultural persistirAtraccion){

		crearArchivo(nombre);
		guardarAtraccion(persistirAtraccion);
	}

	public void guardarAtraccion(AtraccionCultural nombreAtraccionCultural){

		
		try (BufferedWriter atraccionEscrita = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String atraccionFormatoTexto = nombreAtraccionCultural.getUbicacion() + "," + nombreAtraccionCultural.getCupoMax()
            + ", " + nombreAtraccionCultural.getRestricciones() + ", " + nombreAtraccionCultural.getExclusividad() + ", " 
			+ nombreAtraccionCultural.getMinEmpleados() + ", " + nombreAtraccionCultural.getEdadMin() + ", " + 
            nombreAtraccionCultural.getNombre() + ", " + nombreAtraccionCultural.getRestriccionClima() + ", " + 
            nombreAtraccionCultural.getDeTemporada() + ", " + nombreAtraccionCultural.getFecha() + ", " +
			nombreAtraccionCultural.getHorario();
			atraccionEscrita.write(atraccionFormatoTexto);
			atraccionEscrita.newLine();

		} catch(IOException e){
			System.err.println("No se pudo guardar la atracción");
		}

	}
	



}
