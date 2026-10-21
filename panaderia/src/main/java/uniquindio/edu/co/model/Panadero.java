package uniquindio.edu.co.model;

public class Panadero extends Persona implements GestionPan {

    private double salario;

    /**
     * Metodo constructor de la clase Panadero
     * @param nombre          de la Panadero
     * @param documento       de la Panadero
     * @param fechaNacimiento de la Panadero
     * @param salario de la Panadero
     */
    public Panadero(String nombre, String documento, String fechaNacimiento, double salario) {
        super(nombre, documento, fechaNacimiento);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Panadero{" +
                "nombre=" + getNombre() +
                "documento=" + getDocumento() +
                "fechaNacimiento=" + getFechaNacimiento() +
                "salario=" + salario +
                '}';
    }

    @Override
    public String hacerPan() {
        return "Panadero " + getNombre() + " con salario "
        + getSalario() + " haciendo pan navideño";
    }
}
