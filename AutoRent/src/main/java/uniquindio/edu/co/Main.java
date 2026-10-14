package uniquindio.edu.co;

import uniquindio.edu.co.model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Vehiculo v1 = new Automovil("ASZ123","MAZDA",
                "2010", "2009", EstadoVehiculo.BUENO, 5);

        Vehiculo v2 = new Motocicleta("BB23T","MAZDA",
                "2010", "2009", EstadoVehiculo.BUENO, 150);

        Vehiculo v3 = new Camioneta("CCC345","MAZDA",
                "2010", "2009", EstadoVehiculo.BUENO, 10);

        Persona persona = new Turista("Raul","aaa",
                "1111","sddd");

        Alquiler alquiler = new Alquiler("13/10/2026", 123,
                v2, persona, 5);

        Alquiler alquiler2 = new Alquiler("13/10/2026", 123,
                v1, persona, 3);

        alquiler.mostrarAlquiler();

        System.out.println("--------------");

        alquiler2.mostrarAlquiler();

    }

}