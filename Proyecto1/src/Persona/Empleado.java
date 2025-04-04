package Persona;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Empleado extends Persona {
	protected String turno;
	private static final String NOMBREARCHIVO = "empleados.txt";

	public Empleado(String nombre, String login, String password) {
		super(nombre, login, password);
	}


	public void persistencia(String nombre, Persona persistirPersona){

		crearArchivo(nombre);
		guardarEmpleado(persistirPersona);

	}

	public void guardarEmpleado(Persona nombreEmpleado){

		
		try (BufferedWriter empleadoEscrito = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true))){
			String empleadoFormatoTexto = "Nombre: " + nombre + ", Login: " + login + ", Password: " + password;
			empleadoEscrito.write(empleadoFormatoTexto);
			empleadoEscrito.newLine();

		} catch(IOException e){
			System.err.println("No se puddo guardar el empleado");
		}
	}









}
