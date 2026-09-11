package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Universidad {

    //Atributos de la clase Universidad
    public String direccion, ciudad;
    public String nombre;
    public int telefono;
    private int numEstudiante, cantProfesores;
    public String tipoUniversidad;

    //Relaciones de la clase Universidad
    private List<Curso> listUniversidadCursos;
    private List<Estudiante> listUniversidadEstudiantes;
    private List<Profesor> listUniversidadProfesores;


    public Universidad(String direccion, String nombre, int telefono,
                       int numEstudiante, String tipoUniversidad, String ciudad, int cantProfesores){
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.telefono = telefono;
        this.numEstudiante = numEstudiante;
        this.cantProfesores = cantProfesores;
        this.tipoUniversidad = tipoUniversidad;

        this.listUniversidadCursos = new ArrayList<>();
        this.listUniversidadEstudiantes = new ArrayList<>();
        this.listUniversidadProfesores = new ArrayList<>();
    }

}
