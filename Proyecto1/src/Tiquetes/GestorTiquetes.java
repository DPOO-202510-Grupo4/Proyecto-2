package Tiquetes;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import Persona.*;
import restricciones.Temporada;

public class GestorTiquetes {
	private HashMap<Tiquete, Cliente> tiquetesVendidos;
	private ArrayList<CategoriaTiquete> categoriasDisponibles;
	public GestorTiquetes(HashMap<Tiquete, Cliente> tiquetesVendidos,
			ArrayList<CategoriaTiquete> categoriasDisponibles) {
		this.tiquetesVendidos = tiquetesVendidos;
		this.categoriasDisponibles = categoriasDisponibles;
	}
	
	public Tiquete crearTiqueteTemporada(Cliente cliente, String tipoCategoria, Temporada temporada) {
	    CategoriaTiquete categoria = null;
	    for (CategoriaTiquete cat : categoriasDisponibles) {
	        if (cat.getNombre().equals(tipoCategoria)) {
	            categoria = cat;
	            break;
	        }
	    }
	    if (categoria == null) return null;
	    Boolean usado = false;

	    TiqueteTemporada t = new TiqueteTemporada(UUID.randomUUID().toString(), categoria, usado, temporada );
	    tiquetesVendidos.put(t, cliente);
	    return t;
	}

	public Tiquete crearTiqueteDia(Cliente cliente, String tipoCategoria, Date fecha) {
	    CategoriaTiquete categoria = null;
	    for (CategoriaTiquete cat : categoriasDisponibles) {
	        if (cat.getNombre().equals(tipoCategoria)) {
	            categoria = cat;
	            break;
	        }
	    }
	    if (categoria == null) return null;
	    Boolean usado = false;

	    TiqueteDia t = new TiqueteDia(UUID.randomUUID().toString(), categoria, usado, fecha);
	    tiquetesVendidos.put(t, cliente);
	    return t;
	}

	public void UsarTiquete(Tiquete tiquete) {
	    tiquete.marcarComoUsado();
	}
	public ArrayList<Tiquete> getTiquetesDeCliente(Cliente cliente) {
	    ArrayList<Tiquete> resultado = new ArrayList<>();
	    for (Tiquete t : tiquetesVendidos.keySet()) {
	        if (tiquetesVendidos.get(t).equals(cliente)) {
	            resultado.add(t);
	        }
	    }
	    return resultado;
	}

}
