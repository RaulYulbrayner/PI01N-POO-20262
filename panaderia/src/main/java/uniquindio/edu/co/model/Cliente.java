package uniquindio.edu.co.model;

public class Cliente extends Persona implements Comprable, GestionPan{
    /**
     * Metodo constructor de la clase Cliente
     * @param nombre          de la cliente
     * @param documento       de la cliente
     * @param fechaNacimiento de la cliente
     */
    public Cliente(String nombre, String documento, String fechaNacimiento) {
        super(nombre, documento, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre=" + getNombre() +
                "documento=" + getDocumento() +
                "fechaNacimiento=" + getFechaNacimiento() +
                '}';
    }

    @Override
    public String comprarPan() {
        return "El cliente "  + getNombre() + " esta comprando pan por valor de: " + VALOR;
    }

    @Override
    public String hacerPan() {
        return "El cliente " + getNombre() + " esta trabajando haciendo buñuelos navideños";
    }
}
