package uniquindio.edu.co.repaso;

//Dada una palabra, determine la cantidad de vocales que tiene.
public class ejercicio5 {

    public static void main(String []args){
        String palabra = "raul";
        System.out.println(contarVocalesPalabra(palabra));
    }

    /**
     * Metodo que permite determinar si un caracter es vocal
     * @param caracter
     * @return
     */
    public static boolean determinarVocal(char caracter){
        boolean esVocal = false;
        if(caracter == 'a' || caracter == 'e'  || caracter == 'i' || caracter == 'o' || caracter == 'u'){
            esVocal = true;
        }
        return esVocal;
    }

    /**
     *
     * @param palabra
     * @return
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





}
