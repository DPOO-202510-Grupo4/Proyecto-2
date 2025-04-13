package restricciones;

import java.util.ArrayList;
import java.util.List;

import Atracciones.Atraccion;
import Tiquetes.CategoriaTiquete;

public class RestriccionesMecanica extends Restricciones {

    private int alturaMin;
    private int alturaMax;
    private int pesoMin;
    private int pesoMax;
    private ArrayList<String> salud;

    public RestriccionesMecanica(ArrayList<String> clima, String exclusividad, int alturaMin, int alturaMax,
                                 int pesoMin, int pesoMax, ArrayList<String> salud) {
        super(clima, exclusividad);
        this.alturaMin = alturaMin;
        this.alturaMax = alturaMax;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
        this.salud = salud;
    }

    public int getAlturaMin() {
        return alturaMin;
    }

    public void setAlturaMin(int alturaMin) {
        this.alturaMin = alturaMin;
    }

    public int getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(int alturaMax) {
        this.alturaMax = alturaMax;
    }

    public int getPesoMin() {
        return pesoMin;
    }

    public void setPesoMin(int pesoMin) {
        this.pesoMin = pesoMin;
    }

    public int getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(int pesoMax) {
        this.pesoMax = pesoMax;
    }

    public ArrayList<String> getSalud() {
        return salud;
    }

    public void setSalud(ArrayList<String> salud) {
        this.salud = salud;
    }

    public boolean puedeOperarSegunClima(String climaActual) {
        return !getClima().contains(climaActual.toLowerCase());
    }

    public boolean validarAlturaYPeso(int altura, int peso) {
        return altura >= alturaMin && altura <= alturaMax &&
               peso >= pesoMin && peso <= pesoMax;
    }

    public boolean permiteTiquete(CategoriaTiquete categoria, Atraccion atraccion) {
	    return categoria.getAtraccionesDisponibles().contains(atraccion);
	}

    public boolean tieneRestriccionMedica(List<String> condicionesDelUsuario) {
        for (String condicion : condicionesDelUsuario) {
            if (salud.contains(condicion.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}