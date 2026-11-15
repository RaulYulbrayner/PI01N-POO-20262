package co.edu.uniquindio.poo.model;

public class EntregaSegura implements ServicioDomicilio {

    private static final double TARIFA_BASE = 7000;
    private static final double TARIFA_POR_KILOMETRO = 1000;
    private static final double DISTANCIA_MAXIMA_KM = 20;
    private static final double DISTANCIA_PARA_RECARGO_KM = 5;
    private static final double RECARGO = 3000;

    @Override
    public boolean aceptaRecorrido(double distanciaKm) {
        boolean aceptado = distanciaKm > 0 && distanciaKm <= DISTANCIA_MAXIMA_KM;
        return aceptado;
    }

    @Override
    public double calcularCosto(double distanciaKm) {
        double costo = 0;
        if (aceptaRecorrido(distanciaKm)) {
            costo = TARIFA_BASE + TARIFA_POR_KILOMETRO * distanciaKm;
            if (distanciaKm > DISTANCIA_PARA_RECARGO_KM) {
                costo += RECARGO;
            }
        }
        return costo;
    }
}
