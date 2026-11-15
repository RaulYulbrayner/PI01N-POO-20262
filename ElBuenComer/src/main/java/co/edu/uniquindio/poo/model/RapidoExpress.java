package co.edu.uniquindio.poo.model;

public class RapidoExpress implements ServicioDomicilio {

    private static final double TARIFA_BASE = 5000;
    private static final double TARIFA_POR_KILOMETRO = 1500;
    private static final double DISTANCIA_MAXIMA_KM = 12;

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
        }
        return costo;
    }
}
