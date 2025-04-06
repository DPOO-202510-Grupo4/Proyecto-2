package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Persona.Persona;

public class PersistenciaAdministrador {

    private static final String NOMBREARCHIVO = "administradores.txt";

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

    public void persistencia(String nombre, Persona persistirPersona){

		crearArchivo(nombre);
		guardarAdministrador(persistirPersona);

	}

	public void guardarAdministrador(Persona nombreAdministrador){

		
		try (BufferedWriter administradorEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String administradorFormatoTexto = "Nombre: " + nombreAdministrador.getNombre() + ", Login: " + 
            nombreAdministrador.getLogin() + ", Password: " + nombreAdministrador.getPassword();
			administradorEscrito.write(administradorFormatoTexto);
			administradorEscrito.newLine();
            administradorEscrito.close();

		} catch(IOException e){
			System.err.println("No se pudo guardar el administrador");
		}
	}


}
