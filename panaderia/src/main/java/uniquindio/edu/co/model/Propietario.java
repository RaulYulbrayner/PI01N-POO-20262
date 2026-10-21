package uniquindio.edu.co.model;

public class Propietario extends Persona implements GestionPanaderia {

    private int numPropiedades;

    /**
     * Metodo constructor de la clase Propietario
     * @param nombre          de la propietario
     * @param documento       de la propietario
     * @param fechaNacimiento de la propietario
     * @param numPropiedades de la propietario
     */
    public Propietario(String nombre, String documento, String fechaNacimiento,int numPropiedades) {
        super(nombre, documento, fechaNacimiento);
        this.numPropiedades = numPropiedades;
    }

    public int getNumPropiedades() {
        return numPropiedades;
    }

    public void setNumPropiedades(int numPropiedades) {
        this.numPropiedades = numPropiedades;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre=" + getNombre() +
                "documento=" + getDocumento() +
                "fechaNacimiento=" + getFechaNacimiento() +
                "numPropiedades=" + numPropiedades +
                '}';
    }

    @Override
    public String atender() {
        return "Atendiendo a todos los cliente :)";
    }
}
