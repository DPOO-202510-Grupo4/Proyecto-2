
import Tiquetes.Tiquete;
import Tiquetes.CategoriaTiquete;
import Persona.Cliente;

public class Factura {

    protected Tiquete tiquete;
    protected Cliente cliente;

    public Factura(Tiquete tiquete) {
        this.tiquete = tiquete;
    }
}
