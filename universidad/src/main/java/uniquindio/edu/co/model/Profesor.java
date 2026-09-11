package uniquindio.edu.co.model;

import java.util.List;

public class Profesor {

    //Atributos de la clase Profesor
    private String especialidad, nombre, facultad;
    private int edad, documento;
    private double salario;

    //Relaciones de la clase Profesor
    private List<Curso> listCursosProfesor;

}
