package co.edu.uniquindio.poo.model;

public class Habitacion {

    private int numero;
    private int piso;
    private String tipo;
    private int capacidadMaxima;
    private double precioNoche;
    private String disponibilidad;

    /**
     * Metodo constructor de la clase Habitacion.
     * Al crear una habitación inicialmente queda
     * disponible para ser reservada.
     * @param numero número de habitación
     * @param piso piso donde está ubicada
     * @param tipo tipo de habitación
     * @param capacidadMaxima capacidad máxima
     * @param precioNoche precio por noche
     */
    public Habitacion(int numero, int piso, String tipo, int capacidadMaxima, double precioNoche) {
        this.numero = numero;
        this.piso = piso;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
        this.precioNoche = precioNoche;
        disponibilidad = "Disponible";
    }

    /**
     * Metodo que permiet verifica si la habitación se encuentra disponible para realizar una reserva.
     * @return true si está disponible false si tiene otro estado
     */
    public boolean estaDisponible() {
        return disponibilidad.equals("Disponible");
    }

    /**
     * Metodo que permite cambiar el estado actual de la habitación.
     * Este método permite actualizar la disponibilidad
     * cuando una habitación es reservada, ocupada o enviada a mantenimiento.
     * @param disponibilidad nuevo estado de la habitación
     */
    public void cambiarEstado(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setEstado(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", piso=" + piso +
                ", tipo='" + tipo + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", precioNoche=" + precioNoche +
                ", disponibilidad='" + disponibilidad + '\'' +
                '}';
    }
}
