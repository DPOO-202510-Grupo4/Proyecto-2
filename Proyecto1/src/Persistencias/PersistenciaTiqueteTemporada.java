package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Tiquetes.TiqueteTemporada;

public class PersistenciaTiqueteTemporada {

    private static final String NOMBREARCHIVO = "persistencia/tiquetes_temporada.txt";

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

    public void persistencia(String nombre, TiqueteTemporada persistirTiqueteTemporada) {
        crearArchivo(nombre);
        guardarTiqueteTemporada(persistirTiqueteTemporada);
    }

    public void guardarTiqueteTemporada(TiqueteTemporada nombreTiqueteTemporada) {
        try {

            if (nombreTiqueteTemporada instanceof TiqueteTemporada) {
                TiqueteTemporada tiqueteTemporada = (TiqueteTemporada) nombreTiqueteTemporada;
    
                try (BufferedWriter tiqueteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
                    String tiqueteFormatoTexto = "Id del tiquete: " + tiqueteTemporada.getIdTiquete() + ", Categoría: "
                            + tiqueteTemporada.getCategoria() + ", Fue usado: "
                            + tiqueteTemporada.isUsado() + ", Temporada: "
                            + tiqueteTemporada.getTemporada();
    
                    tiqueteEscrito.write(tiqueteFormatoTexto);
                    tiqueteEscrito.newLine();
                } catch (IOException e) {
                    System.err.println("Error al escribir en el archivo: " + e.getMessage());
                }
            } else {
                System.err.println("El objeto no es un Tiquete Temporada, no se puede guardar.");
            }
        } catch (Exception e) { 
            System.err.println("Error general: " + e.getMessage());
        }
    }
    
}

