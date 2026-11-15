package co.edu.uniquindio.poo.model;

public class Cliente {

    private String numeroDocumento;
    private String nombreCompleto;
    private String telefono;
    private String correoElectronico;
    private String direccionResidencia;

    /**
     * Metodo constructor de la clase clietne
     * @param numeroDocumento número de documento
     * @param nombreCompleto nombre completo
     * @param telefono número de contacto
     * @param correoElectronico correo electrónico
     * @param direccionResidencia dirección de residencia
     */
    public Cliente(String numeroDocumento, String nombreCompleto, String telefono, String correoElectronico, String direccionResidencia) {
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }
}
