package Persona;

import java.util.ArrayList;

public abstract class Empleado extends Persona {
	private ArrayList<Turno> turnos;
	private ArrayList<String> tareas;
	private Capacitaciones capacitaciones;
	private Rol rolActual; 
	private LugarTrabajo lugarTrabajo;
	public Empleado(String nombre, String login, String password, ArrayList<Turno> turnos, ArrayList<String> tareas,
			Capacitaciones capacitaciones, Rol rolActual, LugarTrabajo lugarTrabajo) {
		this.turnos = turnos;
		this.tareas = tareas;
		this.capacitaciones = capacitaciones;
		this.rolActual = rolActual;
		this.lugarTrabajo = lugarTrabajo;
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
