package Tiquetes;

import Persona.Cliente;

public class Factura {

    protected Tiquete tiquete;
    protected Cliente cliente;

    public Factura(Tiquete tiquete) {
        this.tiquete = tiquete;
    }
}
