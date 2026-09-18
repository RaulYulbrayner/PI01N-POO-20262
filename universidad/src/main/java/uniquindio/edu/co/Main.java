package uniquindio.edu.co;

import uniquindio.edu.co.model.Estudiante;
import uniquindio.edu.co.model.Universidad;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Universidad universidad = new Universidad("2N",
                "UQ", 3111, 18000,
                "Publica",  "Armenia", 100);

        Universidad universidad1 = new Universidad("2N",
                "EAM", 3111, 18000,
                "Publica",  "Armenia", 100);

        Universidad universidad2 = new Universidad("2N",
                "GRAN COLOMBIA", 3111, 18000,
                "Publica",  "Armenia", 100);

        int opcion = 0;
        while(opcion != 5){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            MENÚ
                            1. Matricular un estudiante
                            2. Buscar un estudiante
                            3. Eliminar un estudiante
                            4. Mostrar información de la Universidad
                            5. Salir
                            Seleccione una opción:
                            """));
            if(opcion == 1){
                String genero = JOptionPane.showInputDialog(null, "Ingrese el genero del estudiante");
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante");
                String fechaNacimiento = JOptionPane.showInputDialog(null, "Ingrese la fechaNacimiento del estudiante");
                String carrera = JOptionPane.showInputDialog(null, "Ingrese la carrera del estudiante");
                int cod = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del estudiante"));
                universidad2.matricularEstudiante(genero, nombre, fechaNacimiento, carrera, cod);
            } else if (opcion == 2) {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del estudiante a buscar:"));
                Estudiante estudiante = universidad2.buscarEstudiante(codigo);
                if(estudiante != null){
                    JOptionPane.showMessageDialog(null, "Estudiante encontrado:\n" + estudiante.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "El estudiante no existe");
                }
            } else if (opcion == 3) {
                int codigo = Integer.parseInt( JOptionPane.showInputDialog(null, "Ingrese el codigo del estudiante que desea eliminar"));
                universidad2.eliminarEstudiante(codigo);
                JOptionPane.showMessageDialog(null, "El estudiante fue eliminado");
            } else if (opcion == 4) {
                JOptionPane.showMessageDialog(null, universidad2.toString());
            } else if(opcion == 5){
                JOptionPane.showMessageDialog(null, "Saliendo del programa, chao muchachos");
            }
        }
    }
}