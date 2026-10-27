package co.edu.uniquindio.poo.model;

public class Cliente extends Persona {

    private String codigoAfiliacion;
    private double porcentajeDescuento;

    /**
     * Metodo constructor de la clase Cliente
     * @param documento del cliente
     * @param nombreCompleto del cliente
     * @param correo del cliente
     * @param telefono del cliente
     * @param codigoAfiliacion del cliente
     * @param porcentajeDescuento Descuento entre 0 y 100.
     */
    public Cliente(String documento, String nombreCompleto, String correo, String telefono, String codigoAfiliacion, double porcentajeDescuento) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigoAfiliacion='" + codigoAfiliacion + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }
}
