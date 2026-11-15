package co.edu.uniquindio.poo.model;


public abstract class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private int tiempoPreparacionMinutos;

    /**
     * Metodo constructor de la clase producto.
     * @param codigo código único en el menú
     * @param nombre nombre del producto
     * @param descripcion descripción del producto
     * @param precioBase precio antes de los incrementos y recargos
     * @param tiempoPreparacionMinutos tiempo estimado en minutos
     */
    protected Producto(String codigo, String nombre, String descripcion, double precioBase, int tiempoPreparacionMinutos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.tiempoPreparacionMinutos = tiempoPreparacionMinutos;
    }

    /**
     * Calcula el precio aplicando las reglas de la categoría.
     * @return precio de venta por unidad
     */
    public abstract double calcularPrecioVenta();

    /**
     * Verifica las condiciones de calidad del producto.
     * @return true si cumple todas las condiciones de su categoría
     */
    public abstract boolean cumpleCondicionesCalidad();

    /** @return categoría a la que pertenece el producto */
    public abstract CategoriaProducto obtenerCategoria();

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getTiempoPreparacionMinutos() {
        return tiempoPreparacionMinutos;
    }
}
