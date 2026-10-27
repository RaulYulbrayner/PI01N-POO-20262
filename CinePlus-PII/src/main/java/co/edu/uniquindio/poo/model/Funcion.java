package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Funcion {
    private String codigo;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private double precioBase;
    private Pelicula thePeliculaFuncion;
    private Sala theSalaFuncion;

    /**
     * Metodo constructor de la clase Funcion
     * @param codigo de la funcion
     * @param fecha de la funcion
     * @param horaInicio de la funcion
     * @param precioBase de la funcion
     * @param thePeliculaFuncion de la funcion
     * @param theSalaFuncion de la funcion
     */
    public Funcion(String codigo, LocalDate fecha, LocalTime horaInicio, double precioBase, Pelicula thePeliculaFuncion, Sala theSalaFuncion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.precioBase = precioBase;
        this.thePeliculaFuncion = thePeliculaFuncion;
        this.theSalaFuncion = theSalaFuncion;
    }

    /**
     * Metodo que permite determinar si dos funciones ocupan la misma sala en intervalos superpuestos.
     * Dos funciones pueden coincidir exactamente en el fin y el inicio.
     * @param otraFuncion Función que se compara.
     * @return true si hay conflicto de sala y horarios.
     */
    public boolean tieneConflictoCon(Funcion otraFuncion) {
        boolean conflicto = theSalaFuncion.getCodigo().equalsIgnoreCase(otraFuncion.getTheSalaFuncion().getCodigo())
                && obtenerInicio().isBefore(otraFuncion.obtenerFin())
                && otraFuncion.obtenerInicio().isBefore(obtenerFin());;
        return conflicto;
    }

    /**
     * Metodo que permite obtener la fecha y hora de inicio de la función.
     * @return fecha y hora de inicio.
     */
    public LocalDateTime obtenerInicio() {
        LocalDateTime inicio = LocalDateTime.of(fecha, horaInicio);
        return inicio;
    }

    /**
     * Metodo que permite calcular la fecha y hora de finalización de la función.
     * @return fecha y hora de finalización.
     */
    public LocalDateTime obtenerFin() {
        LocalDateTime fin = obtenerInicio().plusMinutes(thePeliculaFuncion.getDuracionMinutos());
        return fin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Pelicula getThePeliculaFuncion() {
        return thePeliculaFuncion;
    }

    public void setThePeliculaFuncion(Pelicula thePeliculaFuncion) {
        this.thePeliculaFuncion = thePeliculaFuncion;
    }

    public Sala getTheSalaFuncion() {
        return theSalaFuncion;
    }

    public void setTheSalaFuncion(Sala theSalaFuncion) {
        this.theSalaFuncion = theSalaFuncion;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", horaInicio=" + horaInicio +
                ", precioBase=" + precioBase +
                ", thePeliculaFuncion=" + thePeliculaFuncion +
                ", theSalaFuncion=" + theSalaFuncion +
                '}';
    }
}

