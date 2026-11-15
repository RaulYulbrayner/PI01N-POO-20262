package co.edu.uniquindio.poo.model;

/**
 * Conserva los datos de un recorrido aceptado por una empresa de domicilio.
 * @param empresa empresa que aceptó realizar la entrega
 * @param distanciaKm distancia del recorrido en kilómetros
 * @param costo valor acordado para el servicio
 */
public record Domicilio(ServicioDomicilio empresa, double distanciaKm, double costo) {
}
