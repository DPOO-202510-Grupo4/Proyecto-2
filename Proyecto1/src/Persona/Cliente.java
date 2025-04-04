package Persona;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Cliente extends Persona {

	private static final String NOMBREARCHIVO = "clientes.txt";

	public Cliente(String nombre, String login, String password) {
		super(nombre, login, password);
		
	}

		public void persistencia(String nombre, Persona persistirPersona){

		crearArchivo(nombre);
		guardarCliente(persistirPersona);

	}

		public void guardarCliente(Persona nombreAdministrador){

		
		try (BufferedWriter clienteEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String clienteFormatoTexto = "Nombre: " + nombre + ", Login: " + login + ", Password: " + password;
			clienteEscrito.write(clienteFormatoTexto);
			clienteEscrito.newLine();

		} catch(IOException e){
			System.err.println("No se puedo guardar el cliente");
		}
	}



}
