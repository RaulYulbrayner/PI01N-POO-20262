package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Operario extends Persona {
    private String codigoEmpleado;
    private LocalDate fechaContratacion;
    private double salarioBasico;

    /**
     * Metodo constructor de la clase operario
     * @param documento del operario
     * @param nombreCompleto del operario
     * @param correo del operario
     * @param telefono del operario
     * @param codigoEmpleado del operario
     * @param fechaContratacion del operario
     * @param salarioBasico del operario
     */
    public Operario(String documento, String nombreCompleto, String correo, String telefono, String codigoEmpleado, LocalDate fechaContratacion, double salarioBasico) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    @Override
    public String toString() {
        return "Operario{" +
                "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                ", salarioBasico=" + salarioBasico +
                '}';
    }
}

