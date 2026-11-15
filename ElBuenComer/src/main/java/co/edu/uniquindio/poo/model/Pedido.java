package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String codigo;
    private LocalDateTime fecha;
    private Cliente cliente;
    private ModalidadEntrega modalidad;
    private List<DetallePedido> ListDetallesPedido;
    private LocalDateTime fechaConfirmacion;
    private EstadoPedido estado;
    private Domicilio domicilioAceptado;

    /**
     * Metodo constructor de la clase pedido.
     * @param codigo código único del pedido
     * @param fecha fecha y hora de creación
     * @param cliente cliente que realiza el pedido
     * @param modalidad modalidad de entrega
     */
    public Pedido(String codigo, LocalDateTime fecha, Cliente cliente, ModalidadEntrega modalidad) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.modalidad = modalidad;
        ListDetallesPedido = new ArrayList<>();
        estado = EstadoPedido.PENDIENTE;
    }

    /**
     * Metodo que agrega un producto con su cantidad a un pedido pendiente.
     * @param producto producto solicitado
     * @param cantidad número de unidades
     * @return true si se agregó el detalle
     */
    public boolean agregarProducto(Producto producto, int cantidad) {
        boolean agregado = false;
        if (estado == EstadoPedido.PENDIENTE && producto != null && cantidad > 0 && producto.cumpleCondicionesCalidad()) {
            agregado = ListDetallesPedido.add(new DetallePedido(producto, cantidad));
        }
        return agregado;
    }

    /**
     * Metodo que solicita el recorrido a la empresa elegida y guarda los datos si lo acepta.
     * Si la empresa rechaza el recorrido, se conserva el domicilio aceptado anterior.
     * @param empresa empresa elegida para la entrega
     * @param distanciaKm distancia del recorrido en kilómetros
     * @return true si se registró el domicilio aceptado
     */
    public boolean solicitarDomicilio(ServicioDomicilio empresa, double distanciaKm) {
        boolean aceptado = false;
        if (estado == EstadoPedido.PENDIENTE && modalidad == ModalidadEntrega.DOMICILIO && empresa != null && empresa.aceptaRecorrido(distanciaKm)) {
            double costo = empresa.calcularCosto(distanciaKm);
            domicilioAceptado = new Domicilio(empresa, distanciaKm, costo);
            aceptado = true;
        }
        return aceptado;
    }

    /**
     * Metodo que confirma el pedido y fija los precios después de que el restaurante
     * haya verificado las condiciones de confirmación.
     * @return true si el pedido pasó de pendiente a confirmado
     */
    boolean marcarComoConfirmado() {
        boolean confirmado = false;
        if (estado == EstadoPedido.PENDIENTE) {
            for (DetallePedido detalle : ListDetallesPedido) {
                detalle.fijarPrecioUnitario();
            }
            fechaConfirmacion = LocalDateTime.now();
            estado = EstadoPedido.CONFIRMADO;
            confirmado = true;
        }
        return confirmado;
    }

    /**
     * Metodo que permite marcar como entregado un pedido
     * @return
     */
    public boolean marcarComoEntregado() {
        boolean entregado = false;
        if (estado == EstadoPedido.CONFIRMADO) {
            estado = EstadoPedido.ENTREGADO;
            entregado = true;
        }
        return entregado;
    }

    /**
     * Metodo que permite cancelar un pedido
     * @return true si el pedido pendiente o confirmado pasó a cancelado
     */
    public boolean cancelar() {
        boolean cancelado = false;
        if (estado == EstadoPedido.PENDIENTE || estado == EstadoPedido.CONFIRMADO) {
            estado = EstadoPedido.CANCELADO;
            cancelado = true;
        }
        return cancelado;
    }

    /**
     * Metodo que permite calcular el subtotal de los productos del pedido
     * @return suma de los subtotales de productos
     */
    public double calcularSubtotalProductos() {
        double subtotal = 0;
        for (DetallePedido detalle : ListDetallesPedido) {
            subtotal += detalle.calcularSubtotal();
        }
        return subtotal;
    }

    /**
     * Metodo que permite clacular el costo de un domicilio
     * @return costo del domicilio aceptado, o cero si no se ha asignado
     */
    public double calcularCostoDomicilio() {
        double costo = 0;
        if (domicilioAceptado != null) {
            costo = domicilioAceptado.costo();
        }
        return costo;
    }

    /**
     * Metodo que permite calcular el total de un pedido
     * @return subtotal de productos más el costo del domicilio
     */
    public double calcularTotal() {
        double total = calcularSubtotalProductos() + calcularCostoDomicilio();
        return total;
    }

    /**
     * @return true si el pedido está confirmado o entregado
     */
    public boolean cuentaComoVenta() {
        boolean venta = estado == EstadoPedido.CONFIRMADO || estado == EstadoPedido.ENTREGADO;
        return venta;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public LocalDateTime getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ModalidadEntrega getModalidad() {
        return modalidad;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public List<DetallePedido> getDetalles() {
        List<DetallePedido> copia = new ArrayList<>(ListDetallesPedido);
        return copia;
    }

    public Domicilio getDomicilioAceptado() {
        return domicilioAceptado;
    }
}
