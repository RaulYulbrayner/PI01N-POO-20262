package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CineTest {

    Cliente cliente1 = new Cliente("123", "RAUL", "raul@gmail.com","123","123", 10);
    Operario operario1 = new Operario("1234", "Juan", "raul@gmail.com","123","1234", LocalDate.now(), 1500000);
    Sala sala1 = new Sala("S01", "Sala Tradicional", 20, 10, TipoSala.TRADICIONAL);
    Pelicula pelicula1 = new Pelicula("P001", "Titanic", 160, Genero.DRAMA, 15);
    Funcion funcion1 = new Funcion("FOO1", LocalDate.now(), LocalTime.now(), 1500, pelicula1, sala1 );
    Venta venta = new Venta("001",LocalDate.now(), cliente1, operario1, null);

    @Test
    void buscarPelicula() {
        
    }
}