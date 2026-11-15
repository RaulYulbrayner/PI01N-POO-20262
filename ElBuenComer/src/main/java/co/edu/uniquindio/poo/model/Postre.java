package co.edu.uniquindio.poo.model;

public class Postre extends Producto {

    private double pesoGramos;
    private double temperaturaAlmacenamiento;
    private boolean requiereRefrigeracion;

    /**
     * Metodo constructor de la clase postre.
     * @param codigo código del producto
     * @param nombre nombre del postre
     * @param descripcion descripción del postre
     * @param precioBase precio antes de aplicar los incrementos
     * @param tiempoPreparacionMinutos tiempo estimado en minutos
     * @param pesoGramos peso en gramos
     * @param temperaturaAlmacenamiento temperatura en grados Celsius
     * @param requiereRefrigeracion indica si debe mantenerse refrigerado
     */
    public Postre(String codigo, String nombre, String descripcion, double precioBase, int tiempoPreparacionMinutos, double pesoGramos, double temperaturaAlmacenamiento, boolean requiereRefrigeracion) {
        super(codigo, nombre, descripcion, precioBase, tiempoPreparacionMinutos);
        this.pesoGramos = pesoGramos;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    /** @return precio base más el 15 % y otro 5 % del precio base si requiere refrigeración */
    @Override
    public double calcularPrecioVenta() {
        double precioVenta = getPrecioBase() * 1.15;
        if (requiereRefrigeracion) {
            precioVenta += getPrecioBase() * 0.05;
        }
        return precioVenta;
    }

    /** @return true si el peso y la temperatura de almacenamiento son válidos */
    @Override
    public boolean cumpleCondicionesCalidad() {
        boolean pesoValido = pesoGramos >= 80 && pesoGramos <= 500;
        boolean temperaturaValida;
        if (requiereRefrigeracion) {
            temperaturaValida = temperaturaAlmacenamiento >= 0
                    && temperaturaAlmacenamiento <= 6;
        } else {
            temperaturaValida = temperaturaAlmacenamiento >= 15
                    && temperaturaAlmacenamiento <= 30;
        }
        boolean cumple = pesoValido && temperaturaValida;
        return cumple;
    }

    /** @return categoría de postre */
    @Override
    public CategoriaProducto obtenerCategoria() {
        return CategoriaProducto.POSTRE;
    }

    public double getPesoGramos() {
        return pesoGramos;
    }

    public double getTemperaturaAlmacenamiento() {
        return temperaturaAlmacenamiento;
    }

    public boolean isRequiereRefrigeracion() {
        return requiereRefrigeracion;
    }
}
