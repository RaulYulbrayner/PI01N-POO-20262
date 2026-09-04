package uniquindio.edu.co.repaso;

import javax.swing.*;

//Dada una palabra, determine la cantidad de vocales que tiene.
public class ejercicio5 {

    public static void main(String []args){
        String palabra = JOptionPane.showInputDialog("Ingrese la palabra");
        int cantidad = contarVocalesPalabra(palabra);
        JOptionPane.showMessageDialog(null, "La cantidad de vocales que tiene la palabra " +  palabra + " es: " + cantidad);
    }

    /**
     * Metodo que permite determinar si un caracter es vocal
     * @param caracter
     * @return
     */
    public static boolean determinarVocal(char caracter){
        boolean esVocal = false;
        // Ej: A -> a
        caracter = Character.toLowerCase(caracter);
        if(caracter == 'a' || caracter == 'e'  || caracter == 'i' || caracter == 'o' || caracter == 'u'){
            esVocal = true;
        }
        return esVocal;
    }

    /**
     * Metodo que permite contar la cantidad de vocales que tiene una palabra
     * @param palabra
     * @return cantidad de vocales
     */
    public static int contarVocalesPalabra(String palabra){
        int contador = 0;
        for(int i = 0; i < palabra.length(); i++){
            char letra = palabra.charAt(i);
            if(determinarVocal(letra)){
                contador++;
            }
        }
        return contador;
    }

    //Metodo con dos responsabilidades
    public static int contarVocalesPalabra2(String palabra){
        int contador = 0;
        for(int i = 0; i < palabra.length(); i++){
            char letra = palabra.charAt(i);
            letra = Character.toLowerCase(letra);
            if(letra == 'a' || letra == 'e'  || letra == 'i' || letra == 'o' || letra == 'u'){
                contador++;
            }
        }
        return contador;
    }

}
