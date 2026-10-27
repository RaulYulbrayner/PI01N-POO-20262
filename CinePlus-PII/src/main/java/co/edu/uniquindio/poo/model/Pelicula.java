package co.edu.uniquindio.poo.model;

public class Pelicula {
    private String codigo;
    private String titulo;
    private int duracionMinutos;
    private Genero genero;
    private int edadMinima;

    /**
     * Metodo constructor de la clase Pelicula
     * @param codigo de la pelicula
     * @param titulo de la pelicula
     * @param duracionMinutos de la pelicula
     * @param genero de la pelicula
     * @param edadMinima de la pelicula
     */
    public Pelicula(String codigo, String titulo, int duracionMinutos, Genero genero, int edadMinima) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.edadMinima = edadMinima;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                ", genero=" + genero +
                ", edadMinima=" + edadMinima +
                '}';
    }
}
