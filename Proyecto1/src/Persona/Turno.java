package Persona;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Turno {
private Date fecha;
private Boolean turnoApertura;
private Boolean turnoCierre;
private String lugarTrabajo;

public Turno(Date fecha, Boolean turnoApertura, Boolean turnoCierre, String lugarTrabajo) {
    this.fecha = fecha;
    this.turnoApertura = turnoApertura;
    this.turnoCierre = turnoCierre;
    this.lugarTrabajo = lugarTrabajo;
}

public Date getFecha() {
    return fecha;
}

public String getLugarTrabajo() {
    return lugarTrabajo;
}

@Override
public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return "Fecha: " + sdf.format(fecha)
           + ", Apertura: " + turnoApertura
           + ", Cierre: " + turnoCierre
           + ", Lugar: " + lugarTrabajo;
}
}