package uniquindio.edu.co;

import uniquindio.edu.co.model.Estudiante;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante("M", "Raul", "1990", "Ing Sistemas");
        Estudiante estudiante1 = new Estudiante("F", "Linda", "1990", "Ing Sistemas");
        System.out.println(estudiante.toString());
        System.out.println(estudiante1.toString());

    }

}