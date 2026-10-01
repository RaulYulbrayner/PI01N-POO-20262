package co.edu.uniquindio.poo.model;

public class ServicioAdicional {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponible;

    /**
     * Metodo constructor de la clase ServicioAdicional.
     * Al crear un servicio, inicialmente queda disponible
     * para ser utilizado por los huéspedes.
     * @param codigo código del servicio
     * @param nombre nombre del servicio
     * @param descripcion descripción del servicio
     * @param precio valor del servicio
     */
    public ServicioAdicional(String codigo, String nombre, String descripcion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        disponible = true;
    }

    /**
     * Metodo que permite verificar si el servicio está disponible.
     * @return true si está disponible false en caso contrario
     */
    public boolean estaDisponible() {
        return disponible;
    }

    /**
     * Metodo que permite cambiar el estado de disponibilidad del servicio.
     * @param disponible nuevo estado del servicio
     */
    public void cambiarDisponibilidad(boolean disponible) {
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return "ServicioAdicional{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                '}';
    }
}
