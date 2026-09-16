package uniquindio.edu.co.model;

public class Estudiante {

    // Atributos de la clase Estudiante
    private String genero, nombre, fechaNacimiento, carrera;
    private int cod;

    /**
     * Metodo constructor de la clase Estudiante
     * @param genero del estudiante
     * @param nombre del estudiante
     * @param fechaNacimiento del estudiante
     * @param carrera del estudiante
     */
    public Estudiante(String genero, String nombre, String fechaNacimiento, String carrera, int cod){
        this.genero = genero;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                " genero='" + genero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
