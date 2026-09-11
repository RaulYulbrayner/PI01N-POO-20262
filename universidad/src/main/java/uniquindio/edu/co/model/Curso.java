package uniquindio.edu.co.model;

import java.util.EnumSet;
import java.util.List;

public class Curso {

    //Atributos de la clase Curso
    private String nombre;
    private String horario;

    //Relaciones de la clase Curso
    private List<Estudiante> listEstudiantesCurso;
    private Profesor profesor;

}
