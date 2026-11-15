package co.edu.uniquindio.poo.model;

public class PlatoFuerte extends Producto {

    private double pesoGramos;
    private TipoPreparacion tipoPreparacion;
    private boolean coccionAprobada;

    /**
     * Metodo constructor de la clase plato fuerte.
     * @param codigo código del producto
     * @param nombre nombre del plato
     * @param descripcion descripción del plato
     * @param precioBase precio antes del incremento
     * @param tiempoPreparacionMinutos tiempo estimado en minutos
     * @param pesoGramos peso en gramos
     * @param tipoPreparacion tipo de preparación
     * @param coccionAprobada indica si superó el control de cocción
     */
    public PlatoFuerte(String codigo, String nombre, String descripcion, double precioBase, int tiempoPreparacionMinutos, double pesoGramos, TipoPreparacion tipoPreparacion, boolean coccionAprobada) {
        super(codigo, nombre, descripcion, precioBase, tiempoPreparacionMinutos);
        this.pesoGramos = pesoGramos;
        this.tipoPreparacion = tipoPreparacion;
        this.coccionAprobada = coccionAprobada;
    }

    @Override
    public double calcularPrecioVenta() {
        double precioVenta = getPrecioBase() * 1.20;
        return precioVenta;
    }

    @Override
    public boolean cumpleCondicionesCalidad() {
        int tiempo = getTiempoPreparacionMinutos();
        boolean pesoValido = pesoGramos >= 200 && pesoGramos <= 900;
        boolean tiempoValido = tiempo >= 10 && tiempo <= 60;
        boolean cumple = pesoValido && tiempoValido && coccionAprobada;
        return cumple;
    }

    @Override
    public CategoriaProducto obtenerCategoria() {
        return CategoriaProducto.PLATO_FUERTE;
    }

    public double getPesoGramos() {
        return pesoGramos;
    }

    public TipoPreparacion getTipoPreparacion() {
        return tipoPreparacion;
    }

    public boolean isCoccionAprobada() {
        return coccionAprobada;
    }
}
