package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import Atracciones.AtraccionMecanica;
import Atracciones.Espectaculos;
import Persona.Empleado;

public class PersistenciaEspectaculo {

    private static final String NOMBREARCHIVO = "persistencia/atracciones/espectaculos.txt";

    public static void crearArchivo(String nombreArchivo){

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

    public static void persistencia(Espectaculos persistirEspectaculo){

		crearArchivo(NOMBREARCHIVO);
		guardarEspectaculo(persistirEspectaculo);
	}

    public static void guardarEspectaculo(Espectaculos atraccion) {
        try (BufferedWriter espectaculoEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
      
            String espectaculoFormatoTexto =
                atraccion.getNombre() + "," +
                atraccion.getEmpresaEncargada() + "," +
                atraccion.getFecha() + "," +
                atraccion.getHoraInicio() + "," +
                atraccion.getHoraFinalizacion();

            espectaculoEscrito.write(espectaculoFormatoTexto);
            espectaculoEscrito.newLine();

        } catch (IOException e) {
            System.err.println("No se pudo guardar la atraccion: " + e.getMessage());
        }
    }


}
