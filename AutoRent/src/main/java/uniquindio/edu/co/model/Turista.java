package uniquindio.edu.co.model;

public class Turista extends Persona {

    private String visa;

    /**
     * Metodo constructor de la clase Turista
     * @param nombre    del tursita
     * @param email     del tursita
     * @param documento del tursita
     * @param visa del tursita
     */
    public Turista(String nombre, String email, String documento, String visa) {
        super(nombre, email, documento);
        this.visa = visa;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }
}
