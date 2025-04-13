package Tiquetes;

import java.util.*;
import Persona.*;
import restricciones.Temporada;

public class GestorTiquetes {
    private HashMap<Cliente, List<Tiquete>> tiquetesVendidos;
    private ArrayList<CategoriaTiquete> categoriasDisponibles;

    public GestorTiquetes(HashMap<Cliente, List<Tiquete>> tiquetesVendidos,
                          ArrayList<CategoriaTiquete> categoriasDisponibles) {
        this.tiquetesVendidos = tiquetesVendidos;
        this.categoriasDisponibles = categoriasDisponibles;
    }

    public Tiquete crearTiqueteTemporada(Cliente cliente, String tipoCategoria, Temporada temporada) {
        CategoriaTiquete categoria = buscarCategoria(tipoCategoria);
        if (categoria == null) return null;

        TiqueteTemporada t = new TiqueteTemporada(
            UUID.randomUUID().toString(),
            categoria,
            false,
            temporada
        );

        agregarTiqueteACliente(cliente, t);
        return t;
    }

    public Tiquete crearTiqueteDia(Cliente cliente, String tipoCategoria, Date fecha) {
        CategoriaTiquete categoria = buscarCategoria(tipoCategoria);
        if (categoria == null) return null;

        TiqueteDia t = new TiqueteDia(
            UUID.randomUUID().toString(),
            null, null, tipoCategoria,
            categoria,
            false,
            cliente,
            fecha
        );

        agregarTiqueteACliente(cliente, t);
        return t;
    }

    public void usarTiquete(Tiquete tiquete) {
        tiquete.marcarComoUsado();
    }

    public ArrayList<Tiquete> getTiquetesDeCliente(Cliente cliente) {
        return new ArrayList<>(tiquetesVendidos.getOrDefault(cliente, new ArrayList<>()));
    }

    private CategoriaTiquete buscarCategoria(String tipoCategoria) {
        for (CategoriaTiquete cat : categoriasDisponibles) {
            if (cat.getNombre().equalsIgnoreCase(tipoCategoria)) {
                return cat;
            }
        }
        return null;
    }

    private void agregarTiqueteACliente(Cliente cliente, Tiquete tiquete) {
        tiquetesVendidos.computeIfAbsent(cliente, k -> new ArrayList<>()).add(tiquete);
    }
}
