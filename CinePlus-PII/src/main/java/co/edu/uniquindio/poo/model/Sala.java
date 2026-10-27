package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String codigo;
    private String nombre;
    private int capacidadMaxima;
    private TipoSala tipoSala;
    private List<Asiento> listSalaAsientos;

    /**
     * Matodo constructor de la clase sala con una cantidad de filas y asientos por fila.
     * Los asientos se construyen con letras A, B, C... y números desde 1.
     * @param codigo Código único de la sala.
     * @param nombre Nombre de la sala.
     * @param filas Número de filas (de 1 a 26).
     * @param asientosPorFila Cantidad de asientos en cada fila.
     * @param tipoSala Tipo de sala.
     */
    public Sala(String codigo, String nombre, int filas, int asientosPorFila, TipoSala tipoSala) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoSala = tipoSala;
        this.capacidadMaxima = filas * asientosPorFila;
        this.listSalaAsientos = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            String fila = String.valueOf((char) ('A' + i));
            for (int j = 1; j <= asientosPorFila; j++) {
                listSalaAsientos.add(new Asiento(fila, j));
            }
        }
    }

    /**
     * Metodo que permite buscar un asiento en la lista de asientos de esta sala.
     * @param fila Fila solicitada.
     * @param numero Número solicitado.
     * @return Asiento encontrado o null si no existe.
     */
    public Asiento buscarAsiento(String fila, int numero) {
        Asiento encontrado = null;
        if (fila != null) {
            for (Asiento asiento : listSalaAsientos) {
                if (asiento.getFila().equalsIgnoreCase(fila.trim()) && asiento.getNumero() == numero) {
                    encontrado = asiento;
                }
            }
        }
        return encontrado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public List<Asiento> getListSalaAsientos() {
        return listSalaAsientos;
    }

    public void setListSalaAsientos(List<Asiento> listSalaAsientos) {
        this.listSalaAsientos = listSalaAsientos;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", tipoSala=" + tipoSala +
                ", listSalaAsientos=" + listSalaAsientos +
                '}';
    }
}
