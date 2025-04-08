package ParqueDiversiones;

import java.util.Arrays;

//import Atracciones.AtraccionCultural;
import Atracciones.Atracciones.AtraccionMecanica;
//import Persistencias.PersistenciaAtraccionCultural;
import Persistencias.PersistenciaAtraccionMecanica;
//import Persistencias.PersistenciaEmpleado;
//import Persona.Empleado;

public class ParqueDiversiones {

    public static void main(String[] args) {






        AtraccionMecanica atraccionMecanica = new AtraccionMecanica(
            "Montaña Rusa",
            10,  
            Arrays.asList("Seguridad"),
            "Alta",
            5,
            10,
            "Montaña Rusa",
            Arrays.asList("Ninguna"),
            true,
            "Alto",
            50,
            200,
            150,
            180   
        );

        PersistenciaAtraccionMecanica persistenciaAtraccionMecanica = new PersistenciaAtraccionMecanica();
        persistenciaAtraccionMecanica.persistencia("atracciones_mecanicas.txt", atraccionMecanica);
    }

    }


