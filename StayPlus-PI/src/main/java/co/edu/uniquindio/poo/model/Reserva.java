package co.edu.uniquindio.poo.model;
import java.util.ArrayList;


public class Reserva {

    private String codigoReserva;
    private String fechaRealizacion;
    private String fechaEntrada;
    private String fechaSalida;
    private String estado;
    private String metodoPago;
    private double valorTotal;

    private Huesped huesped;
    private ArrayList<DetalleReserva> listDetalleReserva;
    private ArrayList<DetalleServicioAdicional> listDetalleServicioAdicional;

    /**
     * Metodo constructor de la clase Reserva.
     * @param codigoReserva código de la reserva
     * @param fechaRealizacion fecha de creación
     * @param fechaEntrada fecha de ingreso
     * @param fechaSalida fecha de salida
     * @param metodoPago método de pago
     * @param huesped huésped que realiza la reserva
     */
    public Reserva(String codigoReserva, String fechaRealizacion, String fechaEntrada, String fechaSalida, String metodoPago, Huesped huesped) {
        this.codigoReserva = codigoReserva;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.metodoPago = metodoPago;
        this.huesped = huesped;
        estado = "Pendiente";
        valorTotal = 0;

        listDetalleReserva = new ArrayList<>();
        listDetalleServicioAdicional = new ArrayList<>();
    }

    /**
     * Metodo que permite agregar una habitación a la reserva.
     * Primero valida que la habitación esté disponible.
     * Si está disponible, crea el detalle de reserva,
     * cambia el estado de la habitación y actualiza
     * el valor total.
     * @param habitacion habitación seleccionada
     * @param cantidadNoches cantidad de noches
     * @return true si la habitación fue agregada,false si no estaba disponible
     */
    public boolean agregarHabitacion(Habitacion habitacion, int cantidadNoches) {
        boolean agregado = false;
        if(habitacion.estaDisponible()) {
            DetalleReserva detalle = new DetalleReserva(habitacion, cantidadNoches, habitacion.getPrecioNoche());
            listDetalleReserva.add(detalle);
            habitacion.cambiarEstado("Reservada");
            calcularValorTotal();
            agregado = true;
        }
        return agregado;
    }

    /**
     * Metodo que permite agregar un servicio adicional utilizado durante la estadía.
     * @param servicio servicio solicitado
     * @param cantidad cantidad solicitada
     */
    public void agregarServicio(ServicioAdicional servicio, int cantidad) {
        DetalleServicioAdicional detalle = new DetalleServicioAdicional(servicio, cantidad);
        listDetalleServicioAdicional.add(detalle);
        calcularValorTotal();
    }

    /**
     * Metodo que permite calcular el valor total de la reserva.
     * costo de habitaciones
     * costo de servicios adicionales
     */
    public void calcularValorTotal() {
        valorTotal = 0;
        for(DetalleReserva detalle : listDetalleReserva) {
            valorTotal += detalle.calcularSubtotal();
        }
        for(DetalleServicioAdicional detalle : listDetalleServicioAdicional) {
            valorTotal += detalle.calcularSubtotal();
        }
    }

    /**
     * Metodo que permite cambiar el estado actual de la reserva.
     * @param estado nuevo estado
     */
    public void cambiarEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }
    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getEstado() {
        return estado;
    }

    public ArrayList<DetalleReserva> getListDetalleReserva() {
        return listDetalleReserva;
    }

    public ArrayList<DetalleServicioAdicional> getListDetalleServicioAdicional() {
        return listDetalleServicioAdicional;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva='" + codigoReserva + '\'' +
                ", fechaRealizacion='" + fechaRealizacion + '\'' +
                ", fechaEntrada='" + fechaEntrada + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", estado='" + estado + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotal=" + valorTotal +
                ", huesped=" + huesped +
                ", listDetalleReserva=" + listDetalleReserva +
                ", listDetalleServicioAdicional=" + listDetalleServicioAdicional +
                '}';
    }
}