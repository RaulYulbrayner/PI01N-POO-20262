package co.edu.uniquindio.poo.model;

public interface ServicioDomicilio {

    /**
     * Verifica si la empresa acepta la distancia solicitada.
     * @param distanciaKm distancia del recorrido en kilómetros
     * @return true si la distancia es positiva y está dentro de la cobertura
     */
    boolean aceptaRecorrido(double distanciaKm);

    /**
     * Calcula la tarifa del recorrido.
     * @param distanciaKm distancia del recorrido en kilómetros
     * @return costo del domicilio, o cero si el recorrido se rechaza
     */
    double calcularCosto(double distanciaKm);
}
