package uniquindio.edu.co.model;

public class Camioneta extends Vehiculo {

    private int capacidadCarga;

    /**
     * Metodo constructor de la clase Vehiculo
     *
     * @param placa          del vehiculo
     * @param marca          del vehiculo
     * @param modelo         del vehiculo
     * @param anioFab        del vehiculo
     * @param estadoVehiculo
     */
    public Camioneta(String placa, String marca, String modelo, String anioFab, EstadoVehiculo estadoVehiculo, int capacidadCarga) {
        super(placa, marca, modelo, anioFab, estadoVehiculo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularTarifa(int dias) {
        double valor = (TARIFA + 50000) * dias;
        return valor;
    }
}
