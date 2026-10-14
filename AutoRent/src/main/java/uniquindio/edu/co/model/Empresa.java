package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private String ciudad;

    private List<Persona> listEmpresaPersonas;
    private List<Alquiler> listEmpresaAlquileres;
    private List<Vehiculo> listEmpresaVehiculo;

    /**
     * Metodo constructor de la clase Empresa
     * @param nombre de la empresa
     * @param ciudad de la empresa
     */
    public Empresa(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.listEmpresaPersonas = new ArrayList<>();
        this.listEmpresaAlquileres = new ArrayList<>();
        this.listEmpresaVehiculo = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Persona> getListEmpresaPersonas() {
        return listEmpresaPersonas;
    }

    public void setListEmpresaPersonas(List<Persona> listEmpresaPersonas) {
        this.listEmpresaPersonas = listEmpresaPersonas;
    }

    public List<Alquiler> getListEmpresaAlquileres() {
        return listEmpresaAlquileres;
    }

    public void setListEmpresaAlquileres(List<Alquiler> listEmpresaAlquileres) {
        this.listEmpresaAlquileres = listEmpresaAlquileres;
    }

    public List<Vehiculo> getListEmpresaVehiculo() {
        return listEmpresaVehiculo;
    }

    public void setListEmpresaVehiculo(List<Vehiculo> listEmpresaVehiculo) {
        this.listEmpresaVehiculo = listEmpresaVehiculo;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", listEmpresaPersonas=" + listEmpresaPersonas +
                ", listEmpresaAlquileres=" + listEmpresaAlquileres +
                ", listEmpresaVehiculo=" + listEmpresaVehiculo +
                '}';
    }
}
