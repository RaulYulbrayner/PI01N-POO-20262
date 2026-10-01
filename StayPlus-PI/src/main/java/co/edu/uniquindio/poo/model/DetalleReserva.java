package co.edu.uniquindio.poo.model;

public class DetalleReserva {

    private Habitacion habitacion;
    private int cantidadNoches;
    private double precioAplicado;

    /**
     * Metodo constructor de la clase DetalleReserva.
     * @param habitacion habitación seleccionada
     * @param cantidadNoches cantidad de noches reservadas
     * @param precioAplicado precio aplicado por noche
     */
    public DetalleReserva(Habitacion habitacion, int cantidadNoches, double precioAplicado) {
        this.habitacion = habitacion;
        this.cantidadNoches = cantidadNoches;
        this.precioAplicado = precioAplicado;
    }

    /**
     * Metodo que permite alcula5 el valor total del alojamiento
     * para esta habitación.
     * La operación se realiza multiplicando
     * las noches reservadas por el precio aplicado.
     * @return subtotal de la habitación
     */
    public double calcularSubtotal() {
        return cantidadNoches * precioAplicado;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public double getPrecioAplicado() {
        return precioAplicado;
    }

    public void setPrecioAplicado(double precioAplicado) {
        this.precioAplicado = precioAplicado;
    }

    @Override
    public String toString() {
        return "DetalleReserva{" +
                "habitacion=" + habitacion +
                ", cantidadNoches=" + cantidadNoches +
                ", precioAplicado=" + precioAplicado +
                '}';
    }
}
