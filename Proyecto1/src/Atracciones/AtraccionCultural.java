package Atracciones;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import Persona.Empleado;
import Persona.Persona;
import Tiquetes.CategoriaTiquete;
import Tiquetes.Tiquete;
import restricciones.RestriccionesCultural;
import restricciones.Temporada;

public class AtraccionCultural extends Atraccion {

    private ArrayList<Temporada> disponibilidad;
    private RestriccionesCultural restricciones;
    private ArrayList<Empleado> empleadosAsignados;

    public AtraccionCultural(String nombre, String ubicacion, int cupoMax, int minEmpleados, boolean deTemporada,
                             Temporada temporada, ArrayList<Temporada> disponibilidad,
                             RestriccionesCultural restricciones, ArrayList<Empleado> empleadosAsignados) {
        super(nombre, ubicacion, cupoMax, minEmpleados, deTemporada, temporada);
        this.disponibilidad = disponibilidad;
        this.restricciones = restricciones;
        this.empleadosAsignados = empleadosAsignados;
    }

    @Override
    public boolean esDisponible(Date fecha) {
        if (!enFuncionamiento) return false;

        if (deTemporada && temporada != null) {
            return temporada.estaDentroDeTemporada(fecha);
        }

        for (Temporada t : disponibilidad) {
            if (t.estaDentroDeTemporada(fecha)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean verificarEmpleados() {
        return empleadosAsignados != null && empleadosAsignados.size() >= minEmpleados;
    }

    public boolean validarRestricciones(Persona persona, Tiquete tiquete) {
        return validarEdad(persona) && validarTiquete(tiquete);
    }

    public boolean validarEdad(Persona persona) {
        if (restricciones == null) return true;

        LocalDate fechaNacimiento = persona.getFechaNacimiento();
        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();

        return edad >= restricciones.getEdad();
    }

    public boolean validarTiquete(Tiquete tiquete) {
        if (restricciones == null) return true;
        return restricciones.permiteTiquete(tiquete.getCategoria(), this);
    }

    public ArrayList<Temporada> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(ArrayList<Temporada> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public RestriccionesCultural getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(RestriccionesCultural restricciones) {
        this.restricciones = restricciones;
    }

    public ArrayList<Empleado> getEmpleadosAsignados() {
        return empleadosAsignados;
    }

    public void setEmpleadosAsignados(ArrayList<Empleado> empleadosAsignados) {
        this.empleadosAsignados = empleadosAsignados;
    }
    

    @Override
    public String toString() {
        return "AtraccionCultural [" + nombre + ", ubicación = " + ubicacion + "]";
    }
}