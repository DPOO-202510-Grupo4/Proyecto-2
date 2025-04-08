package Persona;

import java.time.LocalDate;
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

	@Override
	public LocalDate getFechaNacimiento() {
		// TODO Auto-generated method stub
		return super.getFechaNacimiento();
	}

	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		// TODO Auto-generated method stub
		super.setFechaNacimiento(fechaNacimiento);
	}

	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub
		super.setLogin(login);
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	//@Override
	public String getTurno() {
		// TODO Auto-generated method stub
		return this.turno;
	}

	public void setTurno(String turno){
		this.turno = turno;
	}


	}




	
	
}
