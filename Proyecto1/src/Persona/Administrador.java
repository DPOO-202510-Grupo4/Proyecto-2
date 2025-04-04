package Persona;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Administrador extends Persona {

	private static final String NOMBREARCHIVO = "administradores.txt";

	public Administrador(String nombre, String login, String password) {
		super(nombre, login, password);
	}


	public void persistencia(String nombre, Persona persistirPersona){

		crearArchivo(nombre);
		guardarAdministrador(persistirPersona);

	}

		public void guardarAdministrador(Persona nombreAdministrador){

		
		try (BufferedWriter administradorEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String administradorFormatoTexto = "Nombre: " + nombre + ", Login: " + login + ", Password: " + password;
			administradorEscrito.write(administradorFormatoTexto);
			administradorEscrito.newLine();

		} catch(IOException e){
			System.err.println("No se puedo guardar el administrador");
		}
	}

}
