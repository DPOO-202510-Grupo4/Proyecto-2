package Persistencias;

import restricciones.Temporada;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class PersistenciaTemporada {

    private static final String NOMBREARCHIVO = "persistencia/tiquetes/temporadas.csv";
    private static final SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    public static void crearArchivo() {
        try {
            Files.createDirectories(Paths.get("persistencia/tiquetes"));
            File archivo = new File(NOMBREARCHIVO);
            if (!archivo.exists()) {
                archivo.createNewFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                    writer.write("nombre,fechaInicio,fechaFinal");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + NOMBREARCHIVO + " " + e.getMessage());
        }
    }

    public static void persistencia(Temporada temporada) {
        crearArchivo();
        guardarTemporada(temporada);
    }

    public static void guardarTemporada(Temporada temporada) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
            String lineaCSV = temporada.getName() + "," +
                              formatoFecha.format(temporada.getFechaInicio()) + "," +
                              formatoFecha.format(temporada.getFechaFinal());
            writer.write(lineaCSV);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("No se pudo guardar la temporada: " + e.getMessage());
        }
    }
}
