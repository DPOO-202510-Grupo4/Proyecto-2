package Tiquetes;

import Persona.Cliente;

public class Factura {

    protected Tiquete tiquete;
    protected Cliente cliente;

    public Factura(Tiquete tiquete, Cliente cliente) {
        this.tiquete = tiquete;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
