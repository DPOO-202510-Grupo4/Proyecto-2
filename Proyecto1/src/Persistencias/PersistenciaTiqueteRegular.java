package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import Tiquetes.TiqueteRegular;

public class PersistenciaTiqueteRegular {

    private static final String NOMBREARCHIVO = "persistencia/tiquetes/tiquetes_regulares.txt";

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

    public void persistencia(String nombre, TiqueteRegular persistirTiquete) {
        crearArchivo(nombre);
        guardarTiquete(persistirTiquete);
    }

    public void guardarTiquete(TiqueteRegular nombreTiqueteRegular) {

        if (nombreTiqueteRegular instanceof TiqueteRegular) {
            try (BufferedWriter tiqueteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))) {
                String tiqueteFormatoTexto = "Id del tiquete: " + nombreTiqueteRegular.getIdTiquete() + ", Categoria del tiquete: " 
                    + nombreTiqueteRegular.getCategoria() + ", Fue Usado: " 
                    + nombreTiqueteRegular.isUsado() + ", Fecha: " 
                    + nombreTiqueteRegular.getFecha();
                
                tiqueteEscrito.write(tiqueteFormatoTexto);
                tiqueteEscrito.newLine();
                tiqueteEscrito.close();
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        } else {
            System.err.println("El objeto no es un Tiquete Regular, no se puede guardar.");
        }
    }
}
    

