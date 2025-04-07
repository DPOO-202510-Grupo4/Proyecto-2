package Persona;

import java.util.Date;
import java.util.ArrayList;

public abstract class Empleado extends Persona {
	protected Capacitaciones capacitaciones;
	protected ArrayList<Turno> turnos;
	protected ArrayList<String> tareas;
	protected String rolActual;

	public Empleado(String nombre, String login, String password, Date fechaNacimiento) {
		super(nombre, login, password, fechaNacimiento);
	}

	public void consultarCapacitacion(){

	}

	public void consultarTurno(Date fecha){
		
	}

	public void registrarVenta(){
		
	}

	public void registrarTiquete(){
		
	}

}
