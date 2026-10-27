package uniquindio.edu.co.model;

public class Motocicleta extends Vehiculo {

    private int cilindraje;

    /**
     * Metodo constructor de la clase Vehiculo
     *
     * @param placa          del vehiculo
     * @param marca          del vehiculo
     * @param modelo         del vehiculo
     * @param anioFab        del vehiculo
     * @param estadoVehiculo
     */
    public Motocicleta(String placa, String marca, String modelo, String anioFab, EstadoVehiculo estadoVehiculo, int cilindraje) {
        super(placa, marca, modelo, anioFab, estadoVehiculo);
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularTarifa(int dias) {
        double valor = TARIFA * dias * 0.90;
        return valor;
    }
}
