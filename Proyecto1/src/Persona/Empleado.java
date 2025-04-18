package Persona;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empleado extends Persona {

	private ArrayList<Turno> turnos;
	private ArrayList<String> tareas;
	private Capacitaciones capacitaciones;
	private Rol rolActual; 
	private LugarTrabajo lugarTrabajo;

	public Empleado(String nombre, String login, String password, LocalDate fechaNacimiento) {
	    super(nombre, login, password, fechaNacimiento);
	    this.turnos = new ArrayList<>();
	    this.tareas = new ArrayList<>();
	    this.capacitaciones = null;
	    this.rolActual = null;
	    this.lugarTrabajo = null;
	}

	@Override
	public LocalDate getFechaNacimiento() {
		return super.getFechaNacimiento();
	}

	@Override
	public String getLogin() {
		return super.getLogin();
	}

	@Override
	public String getNombre() {
		return super.getNombre();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		super.setFechaNacimiento(fechaNacimiento);
	}

	@Override
	public void setLogin(String login) {
		super.setLogin(login);
	}

	@Override
	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}

	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}


	public ArrayList<Turno> getTurnos() {
		return this.turnos;
	}

	public ArrayList<Turno> setTurno(Turno turno) {
		turnos.add(turno);
		return this.turnos;
	}

	public LugarTrabajo getLugarTrabajo() {
		return this.lugarTrabajo;

	}

	public Capacitaciones getCapacitaciones() {
		return this.capacitaciones;
	}

	public ArrayList<String> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<String> tareas) {
		this.tareas = tareas;
	}

	public Rol getRolActual() {
		return rolActual;
	}
	
}



	
	

