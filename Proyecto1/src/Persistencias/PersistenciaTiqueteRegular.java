package Persistencias;

import Tiquetes.TiqueteRegular;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class PersistenciaTiqueteRegular {

    private static final String NOMBRE_ARCHIVO = "persistencia/tiquetes/tiquetes_regulares.csv";

    public static void crearArchivo(String nombreArchivo) {
        try {
            Files.createDirectories(Paths.get("persistencia/tiquetes"));
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + nombreArchivo + " " + e.getMessage());
        }
    }

    public static void persistencia(TiqueteRegular tiquete) {
        crearArchivo(NOMBRE_ARCHIVO);
        guardarTiquete(tiquete);
    }

    public static void guardarTiquete(TiqueteRegular t) {
        if (t == null) {
            System.err.println("El tiquete es nulo, no se puede guardar.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            String linea = t.getIdTiquete() + "," +
                           t.getCategoria().getNombre() + "," +
                           t.isUsado() + "," +
                           t.getFecha();
            writer.write(linea);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar el tiquete: " + e.getMessage());
        }
    }
}
