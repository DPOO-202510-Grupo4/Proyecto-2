package ParqueDiversiones;

import java.text.SimpleDateFormat;
import java.util.*;

import Atracciones.Atracciones.AtraccionCultural;
//import Atracciones.AtraccionCultural;
import Atracciones.Atracciones.AtraccionMecanica;
import Persistencias.PersistenciaAtraccionCultural;
//import Persistencias.PersistenciaAtraccionCultural;
import Persistencias.PersistenciaAtraccionMecanica;
//import Persistencias.PersistenciaEmpleado;
//import Persona.Empleado;
//Nota en commits
public class ParqueDiversiones {

    public static void main(String[] args) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fecha = formato.parse("07/04/2025 10:00");
        Date horario = formato.parse("07/04/2025 11:00");




        AtraccionMecanica atraccionMecanica = new AtraccionMecanica(
            "Zona Gris",
            10,  
            Arrays.asList("Seguridad"),
            "Alta",
            5,
            10,
            "La Momia",
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

    AtraccionCultural atraccionCultural = new AtraccionCultural(
        "Zona Colonial",                  
        30,                               
        Arrays.asList("Ninguna"),         
        "Media",                          
        2,                               
        5,                                
        "Museo de Historia",              
        Arrays.asList("Lluvia"),          
        false,                            
        fecha,                            
        horario                           
    );

        PersistenciaAtraccionCultural persistencia = new PersistenciaAtraccionCultural();
        persistencia.persistencia("atracciones_culturales.txt", atraccionCultural);
    }




    }


