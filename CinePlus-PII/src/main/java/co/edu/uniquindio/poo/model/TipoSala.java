package co.edu.uniquindio.poo.model;

public enum TipoSala {
    TRADICIONAL(0.0), VIP(0.30), TRES_D(0.20);

    private final double recargo;

    /** Construye el tipo de sala con su recargo. */
    TipoSala(double recargo) {
        this.recargo = recargo;
    }

    /** @return Porcentaje de recargo expresado como decimal. */
    public double getRecargo() {
        return recargo;
    }
}
