package uniquindio.edu.co.model;

public class Estudiante extends Persona {

    // Atributos de la clase Estudiante
    private String genero, fechaNacimiento, carrera;
    private EstadoEstudiante estadoEstudiante;

    /**
     * Metodo constructor de la clase Estudiante
     * @param genero del estudiante
     * @param nombre del estudiante
     * @param fechaNacimiento del estudiante
     * @param carrera del estudiante
     */
    public Estudiante(String genero, String nombre, String fechaNacimiento, String carrera, EstadoEstudiante estadoEstudiante, int documento, EstadoPersona estadoPersona){
        super(nombre, documento, estadoPersona);
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
        this.estadoEstudiante = estadoEstudiante;
    }

    public void atenderServicio(){
        comer();
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

    public EstadoEstudiante getEstadoEstudiante() {
        return estadoEstudiante;
    }

    public void setEstadoEstudiante(EstadoEstudiante estadoEstudiante) {
        this.estadoEstudiante = estadoEstudiante;
    }

    @Override
    public void dormir() {
        System.out.println("Estudiante roncando..... :)");
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "genero='" + genero + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", carrera='" + carrera + '\'' +
                ", estadoEstudiante=" + estadoEstudiante +
                ", mombre=" + getNombre() +
                ", documento=" + getDocumento() +
                ", estadoPersona=" + getEstadoPersona() +
                '}';
    }
}
