package uniquindio.edu.co;

import uniquindio.edu.co.model.Cliente;
import uniquindio.edu.co.model.Panadero;
import uniquindio.edu.co.model.Persona;
import uniquindio.edu.co.model.Propietario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Raul", "12345", "1990");

        Propietario propietario = new Propietario("Don chucho", "3244",
                "1980", 100);

        Panadero panadero = new Panadero("Messi", "9876",
                "1985", 100000);

        System.out.println(cliente.comprarPan());

        System.out.println(cliente.hacerPan());

        System.out.println(panadero.hacerPan());

    }

}