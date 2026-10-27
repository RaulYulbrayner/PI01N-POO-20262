package uniquindio.edu.co;

import uniquindio.edu.co.model.*;

public class App {

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante(
                "M", "RAUL","1991",
                "ING", EstadoEstudiante.NUEVO,
                123, EstadoPersona.ACTIVO
        );

        Profesor profesor = new Profesor("Yulbraynner",
                3333, EstadoPersona.ACTIVO,
                "Software", "Ing", 30,
                500
        );

        System.out.println(estudiante);
        estudiante.comer();
        estudiante.dormir();
        profesor.dormir();

    }

}
