package Persistencias;

import Tiquetes.CategoriaTiquete;
import Atracciones.Atraccion;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PersistenciaCategoriaTiquete {

    private static final String NOMBREARCHIVO = "persistencia/tiquetes/categorias.csv";

    public static void crearArchivo() {
        try {
            Files.createDirectories(Paths.get("persistencia/tiquetes"));
            File archivo = new File(NOMBREARCHIVO);
            if (!archivo.exists()) {
                archivo.createNewFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                    writer.write("nombre,precioBase,atracciones");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + NOMBREARCHIVO + " " + e.getMessage());
        }
    }

    public static void persistencia(CategoriaTiquete categoria) {
        crearArchivo();
        guardarCategoria(categoria);
    }

    public static void guardarCategoria(CategoriaTiquete categoria) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
            String atracciones = categoria.getAtraccionesDisponibles()
                                          .stream()
                                          .map(Atraccion::getNombre)
                                          .collect(Collectors.joining(";"));
            String lineaCSV = categoria.getNombre() + "," +
                              categoria.getPrecioBase() + "," +
                              atracciones;
            writer.write(lineaCSV);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("No se pudo guardar la categoría de tiquete: " + e.getMessage());
        }
    }
}
