package co.edu.uniquindio.poo.model;

public class Asiento {
    private final String fila;
    private final int numero;

    /**
     * Metodo constructor de la clase Asiento
     * @param fila Fila del asiento
     * @param numero Número del asiento dentro de la fila.
     */
    public Asiento(String fila, int numero) {
        this.fila = fila.trim().toUpperCase();
        this.numero = numero;
    }

    public String getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "fila='" + fila + '\'' +
                ", numero=" + numero +
                '}';
    }
}

