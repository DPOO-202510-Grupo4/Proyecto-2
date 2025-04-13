package Atracciones;

import java.util.ArrayList;
import java.util.Date;

import Persona.Empleado;
import restricciones.Temporada;

public abstract class Atraccion {

    protected String ubicacion;
    protected int cupoMax;
    protected int minEmpleados;
    protected String nombre;
    protected Temporada temporada;
    protected boolean deTemporada;
    protected boolean enFuncionamiento;


    public Atraccion(String nombre, String ubicacion, int cupoMax, int minEmpleados, boolean deTemporada, Temporada temporada) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.cupoMax = cupoMax;
        this.minEmpleados = minEmpleados;
        this.deTemporada = deTemporada;
        this.temporada = temporada;
        this.enFuncionamiento = true; 
    }



    public boolean esDisponible(Date fecha) {
    	//TODO Implementar usando temporadas y fecha actual

        return true;
    }

    public boolean verificarEmpleados() {

        return true; 
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean isEnFuncionamiento() {
        return enFuncionamiento;
    }

    public void setEnFuncionamiento(boolean enFuncionamiento) {
        this.enFuncionamiento = enFuncionamiento;
    }

    public boolean isDeTemporada() {
        return deTemporada;
    }

    public Temporada getTemporada() {
        return temporada;
    }



	public boolean estaDisponible() {
		// TODO Auto-generated method stub
		return false;
	}



	protected boolean verificarMinimoEmpleados(Date fecha) {
		// TODO Auto-generated method stub
		return false;
	}



	protected ArrayList<Empleado> getEmpleadosAsignados() {
		// TODO Auto-generated method stub
		return null;
	}
}
