package uniquindio.edu.co.model;

public class Automovil extends Vehiculo {

    private int numPuertas;

    /**
     * Metodo constructor de la clase Vehiculo
     * @param placa          del vehiculo
     * @param marca          del vehiculo
     * @param modelo         del vehiculo
     * @param anioFab        del vehiculo
     * @param estadoVehiculo
     */
    public Automovil(String placa, String marca, String modelo, String anioFab, EstadoVehiculo estadoVehiculo, int numPuertas) {
        super(placa, marca, modelo, anioFab, estadoVehiculo);
        this.numPuertas = numPuertas;
    }

    @Override
    public double calcularTarifa(int dias) {
        double valor = (TARIFA + 20000) * dias;
        return valor;
    }

}
