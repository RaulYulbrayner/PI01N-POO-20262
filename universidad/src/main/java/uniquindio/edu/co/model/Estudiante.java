package uniquindio.edu.co.model;

public class Estudiante {

    // Atributos de la clase Estudiante
    private String genero, nombre, fechaNacimiento, carrera;

    /**
     * Metodo constructor de la clase Estudiante
     * @param genero del estudiante
     * @param nombre del estudiante
     * @param fechaNacimiento del estudiante
     * @param carrera del estudiante
     */
    public Estudiante(String genero, String nombre, String fechaNacimiento
    , String carrera){
        this.genero = genero;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "genero='" + genero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
