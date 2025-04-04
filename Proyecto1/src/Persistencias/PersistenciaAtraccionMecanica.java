package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import Atracciones.Atraccion;
import Atracciones.AtraccionMecanica;

public class PersistenciaAtraccionMecanica {

    private static final String ATRACCIONES_PERSISTENCIA = "persistencia/atracciones.txt";
	private static final String NOMBREARCHIVO = "atracciones_mecanicas.txt";

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


    	public void persistencia(String nombre, AtraccionMecanica persistirAtraccion){

		crearArchivo(nombre);
		guardarAtraccion(persistirAtraccion);
	}

	public void guardarAtraccion(AtraccionMecanica nombreAtraccionMecanica){

		
		try (BufferedWriter atraccionEscrita = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String atraccionFormatoTexto = nombreAtraccionMecanica.getUbicacion() + "," + nombreAtraccionMecanica.getCupoMax() + ", " + 
			nombreAtraccionMecanica.getCupoMax() + ", " + nombreAtraccionMecanica.getRestricciones() + ", " + nombreAtraccionMecanica.getExclusividad() + ", " 
			+ nombreAtraccionMecanica.getMinEmpleados() + ", " + nombreAtraccionMecanica.getEdadMin() + ", " + nombreAtraccionMecanica.getNombre() + ", " 
			+ nombreAtraccionMecanica.getRestriccionClima() + ", " + deTemporada + ", " 
			+ riesgo + ", " + pesoMin + ", " + pesoMax + ", " + alturaMin + ", " + String.valueOf(alturaMax);
			atraccionEscrita.write(atraccionFormatoTexto);
			atraccionEscrita.newLine();

		} catch(IOException e){
			System.err.println("No se pudo guardar la atracción");
		}
	}
}
