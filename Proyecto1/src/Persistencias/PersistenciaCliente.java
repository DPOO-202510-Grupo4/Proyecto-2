package Persistencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Persona.Persona;

public class PersistenciaCliente {

    private static final String NOMBREARCHIVO = "persistencia/personas/clientes.txt";

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

    public static void persistencia(String nombre, Persona persistirPersona){

		crearArchivo(nombre);
		guardarCliente(persistirPersona);

	}

	public static void guardarCliente(Persona nombreCliente){

		
		try (BufferedWriter clienteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String clienteFormatoTexto = "Nombre: " + nombreCliente.getNombre() + ", Login: " + nombreCliente.getLogin()
            + ", Password: " + nombreCliente.getPassword();
			clienteEscrito.write(clienteFormatoTexto);
			clienteEscrito.newLine();
            clienteEscrito.close();

		} catch(IOException e){
			System.err.println("No se pudo guardar el cliente");
		}
	}










}
