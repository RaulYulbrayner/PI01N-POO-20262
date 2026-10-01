package co.edu.uniquindio.poo.model;

public class Huesped {

    private String nombreCompleto;
    private String documento;
    private String telefono;
    private String correo;
    private String paisProcedencia;

    /**
     * Metodo constructor de la clase Huesped.
     * @param documento documento de identidad
     * @param nombreCompleto nombre completo
     * @param telefono número telefónico
     * @param correo correo electrónico
     * @param paisProcedencia país de procedencia
     */
    public Huesped(String documento, String nombreCompleto, String telefono, String correo, String paisProcedencia) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.paisProcedencia = paisProcedencia;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "documento='" + documento + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", paisProcedencia='" + paisProcedencia + '\'' +
                '}';
    }
}