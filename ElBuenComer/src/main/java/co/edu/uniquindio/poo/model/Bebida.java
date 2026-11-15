package co.edu.uniquindio.poo.model;

public class Bebida extends Producto {

    private double volumenMililitros;
    private double temperaturaServicio;
    private TipoBebida tipoBebida;
    private boolean requierePreparacionEspecial;

    /**
     * Metodo constructor de la clase bebida.
     * @param codigo código del producto
     * @param nombre nombre de la bebida
     * @param descripcion descripción de la bebida
     * @param precioBase precio antes de aplicar los recargos
     * @param tiempoPreparacionMinutos tiempo estimado en minutos
     * @param volumenMililitros volumen en mililitros
     * @param temperaturaServicio temperatura de servicio en grados Celsius
     * @param tipoBebida clasificación fría o caliente
     * @param requierePreparacionEspecial indica si aplica el recargo fijo
     */
    public Bebida(String codigo, String nombre, String descripcion, double precioBase, int tiempoPreparacionMinutos, double volumenMililitros, double temperaturaServicio, TipoBebida tipoBebida, boolean requierePreparacionEspecial) {
        super(codigo, nombre, descripcion, precioBase, tiempoPreparacionMinutos);
        this.volumenMililitros = volumenMililitros;
        this.temperaturaServicio = temperaturaServicio;
        this.tipoBebida = tipoBebida;
        this.requierePreparacionEspecial = requierePreparacionEspecial;
    }

    /** @return precio base más el 10 % y $3.000 si requiere preparación especial */
    @Override
    public double calcularPrecioVenta() {
        double precioVenta = getPrecioBase() * 1.10;
        if (requierePreparacionEspecial) {
            precioVenta += 3000;
        }
        return precioVenta;
    }

    /** @return true si el volumen y la temperatura están en los rangos permitidos */
    @Override
    public boolean cumpleCondicionesCalidad() {
        boolean volumenValido = volumenMililitros >= 150 && volumenMililitros <= 1500;
        boolean temperaturaValida = false;
        if (tipoBebida == TipoBebida.FRIA) {
            temperaturaValida = temperaturaServicio >= 0 && temperaturaServicio <= 10;
        } else if (tipoBebida == TipoBebida.CALIENTE) {
            temperaturaValida = temperaturaServicio >= 55 && temperaturaServicio <= 85;
        }
        boolean cumple = volumenValido && temperaturaValida;
        return cumple;
    }

    /** @return categoría de bebida */
    @Override
    public CategoriaProducto obtenerCategoria() {
        return CategoriaProducto.BEBIDA;
    }

    public double getVolumenMililitros() {
        return volumenMililitros;
    }

    public double getTemperaturaServicio() {
        return temperaturaServicio;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public boolean isRequierePreparacionEspecial() {
        return requierePreparacionEspecial;
    }
}
