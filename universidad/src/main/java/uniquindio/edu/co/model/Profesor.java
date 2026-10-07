package uniquindio.edu.co.model;

public class Profesor extends Persona {

    private String especialidad, facultad;
    private int edad;
    double salario;

    /**
     * Metodo constructor de la clase profesor
     * @param nombre del profesor
     * @param documento del profesor
     * @param estado del profesor
     * @param especialidad del profesor
     * @param facultad del profesor
     * @param edad del profesor
     * @param salario del profesor
     */
    public Profesor(String nombre, int documento, Estado estado,
                    String especialidad, String facultad, int edad, double salario) {
        super(nombre, documento, estado);
        this.especialidad = especialidad;
        this.facultad = facultad;
        this.edad = edad;
        this.salario = salario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "especialidad='" + especialidad + '\'' +
                ", facultad='" + facultad + '\'' +
                ", edad=" + getNombre() +
                ", salario=" + salario +
                '}';
    }

}