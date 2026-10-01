package co.edu.uniquindio.poo.model;

public class DetalleServicioAdicional {

    private ServicioAdicional servicio;
    private int cantidad;
    private double costo;

    /**
     * Metodo constructor de la clase DetalleServicio.
     * @param servicio servicio adicional asociado
     * @param cantidad cantidad solicitada del servicio
     */
    public DetalleServicioAdicional(ServicioAdicional servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.costo = servicio.getPrecio() * cantidad;
    }

    public ServicioAdicional getServicio() {
        return servicio;
    }

    public void setServicio(ServicioAdicional servicio) {
        this.servicio = servicio;
        actualizarCosto();
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Metodo que modifica la cantidad solicitada del servicio.
     * @param cantidad nueva cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        actualizarCosto();
    }

    public double getCosto() {
        return costo;
    }

    private void actualizarCosto() {
        this.costo = servicio.getPrecio() * cantidad;
    }

    public double calcularSubtotal() {
        return costo;
    }

    @Override
    public String toString() {
        return "DetalleServicioAdicional{" +
                "servicio=" + servicio +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                '}';
    }
}
