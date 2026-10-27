package uniquindio.edu.co.model;

public class Alquiler {

    private String fecha;
    private int codigo;
    private int dias;

    private Vehiculo vehiculo;
    private Persona persona;

    public Alquiler(String fecha, int codigo, Vehiculo vehiculo, Persona persona, int dias) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.vehiculo = vehiculo;
        this.persona = persona;
        this.dias = dias;
    }

    public double calcularTotal(){
             //automovil.calcularTarifa()
        return vehiculo.calcularTarifa(dias);
    }

    public void mostrarAlquiler(){
        System.out.println("La fecha es: " +  fecha);
        System.out.println("La codifo es: " +  codigo);
        System.out.println("El vehiculo es: " + vehiculo.getPlaca());
        System.out.println("Total alquiler: " + calcularTotal());
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "fecha='" + fecha + '\'' +
                ", codigo=" + codigo +
                ", vehiculo=" + vehiculo +
                ", persona=" + persona +
                '}';
    }
}
