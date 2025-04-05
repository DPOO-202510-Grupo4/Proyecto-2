package Persona;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public abstract class Persona {
 protected String nombre;
 protected String login;
 protected String password;
 protected LocalDate fechaNacimiento;
 private static final String PERSONAS_PERSISTENCIA = "persistencia/personas.txt";

public Persona(String nombre, String login, String password, LocalDate fechaNacimiento) {
	this.nombre = nombre;
	this.login = login;
	this.password = password;
	this.fechaNacimiento = fechaNacimiento;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
}

public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}
 
}
