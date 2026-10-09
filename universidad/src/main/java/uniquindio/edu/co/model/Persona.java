package uniquindio.edu.co.model;

public abstract class Persona {

    private String nombre;
    private int documento;
    private EstadoPersona estado;

    /**
     * Metodo constructor de la clase persona
     * @param nombre de la persona
     * @param documento de la persona
     * @param estado de la persona
     */
    public Persona(String nombre, int documento, EstadoPersona estado) {
        this.nombre = nombre;
        this.documento = documento;
        this.estado = estado;
    }

    public abstract void dormir();

    public void comer(){
        System.out.println("Perona comiendo");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public EstadoPersona getEstadoPersona() {
        return estado;
    }

    public void setEsta(EstadoPersona esta) {
        this.estado = esta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", documento=" + documento +
                ", esta=" + estado +
                '}';
    }
}
