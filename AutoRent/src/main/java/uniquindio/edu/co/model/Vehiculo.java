package uniquindio.edu.co.model;

public abstract class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private String anioFab;
    public final static double TARIFA = 10000;
    private EstadoVehiculo estadoVehiculo;

    /**
     * Metodo constructor de la clase Vehiculo
     * @param placa del vehiculo
     * @param marca del vehiculo
     * @param modelo del vehiculo
     * @param anioFab del vehiculo
     */
    public Vehiculo(String placa, String marca, String modelo, String anioFab, EstadoVehiculo estadoVehiculo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFab = anioFab;
        this.estadoVehiculo = estadoVehiculo;
    }

    public abstract double calcularTarifa(int dias);

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnioFab() {
        return anioFab;
    }

    public void setAnioFab(String anioFab) {
        this.anioFab = anioFab;
    }

    public EstadoVehiculo getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(EstadoVehiculo estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anioFab='" + anioFab + '\'' +
                ", estadoVehiculo=" + estadoVehiculo +
                '}';
    }
}
