package Persona;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Empleado extends Persona {

	private ArrayList<Turno> turnos;
	private ArrayList<String> tareas;
	private Capacitaciones capacitaciones;
	private Rol rolActual; 
	private LugarTrabajo lugarTrabajo;

	public Empleado(String nombre, String login, String password, LocalDate fechaNacimiento, ArrayList<Turno> turnos, ArrayList<String> tareas,
			Capacitaciones capacitaciones, Rol rolActual, LugarTrabajo lugarTrabajo) {
		super(nombre, login, password, fechaNacimiento);
		this.turnos = new ArrayList<Turno>();
		this.tareas = new ArrayList<String>();
		this.capacitaciones = capacitaciones;
		this.rolActual = rolActual;
		this.lugarTrabajo = lugarTrabajo;
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


	public ArrayList<Turno> getTurnos() {
		return this.turnos;
	}

	public ArrayList<Turno> setTurno(Turno turno) {
		turnos.add(turno);
		return this.turnos;
	}

	public ArrayList<LugarTrabajo> getLugarTrabajo() {
		return this.lugarTrabajo;

	}




	
	

