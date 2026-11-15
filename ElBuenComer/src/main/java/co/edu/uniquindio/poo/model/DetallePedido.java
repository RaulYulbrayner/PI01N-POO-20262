package co.edu.uniquindio.poo.model;

public class DetallePedido {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    /**
     * Crea un detalle con el precio de venta actual del producto.
     * @param producto producto solicitado
     * @param cantidad número de unidades solicitadas
     */
    public DetallePedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        fijarPrecioUnitario();
    }

    /**
     * Guarda el precio de venta del producto. El pedido llama esta operación
     * al confirmar para conservar el precio de la venta.
     */
    public void fijarPrecioUnitario() {
        precioUnitario = producto.calcularPrecioVenta();
    }

    /** @return precio unitario multiplicado por las unidades solicitadas */
    public double calcularSubtotal() {
        double subtotal = precioUnitario * cantidad;
        return subtotal;
    }

    /** @return producto solicitado */
    public Producto getProducto() {
        return producto;
    }

    /** @return unidades solicitadas */
    public int getCantidad() {
        return cantidad;
    }

    /** @return precio unitario registrado en el detalle */
    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
