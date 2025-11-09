
import java.util.*;
import java.util.function.IntPredicate;

public class Palindromo{
     //! La función esPalindromo que toma un numero entero, devuelve true cuando x es mayor o igual a 0. 

    private static final IntPredicate noNegativo = x -> x >= 0;  // Condición para números no negativos
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
     
        try{
            System.out.println("Ingresa un número entero: ");
            String n = sc.nextLine();

            int numeroConvertido = convertir(n); //Convierte mi String a Entero.
            if(!noNegativo.test(numeroConvertido)){ //! .equals evalúa strings, y .test evalúa enteros.
                System.out.println("Error: El número debe ser no negativo.");
                return;
            }

            boolean resultado = esPalindromo(n); // Llama a la función esPalindromo y evalúa mi número.
            imprimirResultado(resultado); //Imprime true o false.

        }catch(NumberFormatException e){
            System.out.println("Error: Debes ingresar un número entero válido.");
            System.out.println("Detalle: " + e.getClass().getSimpleName() + " --> " + e.getMessage());
            return;
        }finally{
            System.out.println("Finalizando el programa. Cerrando recursos...");
            sc.close();
        }
    }
    // Función que evalúa si un número es palíndromo
    public static boolean esPalindromo(String n){
        n = n.trim(); // Elimina espacios en blanco al inicio y al final
        int longitud = n.length(); // Obtiene la longitud de la cadena
        for(int i = 0; i < longitud / 2; i++){ //Para i <-- 0 HASTA (longitd/2)-1 HACER:
            if(n.charAt(i) != n.charAt(longitud - 1 - i)){ // Si el caracter en la posición i es diferente al caracter en la posición longitud-1-i
                return false; // Devuelve falso
            }
        }
        return true; // Devuelve verdadero
    }

    static int convertir(String numero){ // Función que convierte Str -> int
        int entero = Integer.parseInt(numero);
        return entero;
    }

    //Procedimiento imprimir resultado
    public static void imprimirResultado(boolean resultado){
        System.out.println(resultado ? "True" : "False"); //Escribe en pseudocodigo: SI resultado ES true ENTONCES ESCRIBE "True" SINO ESCRIBE "False"
    }
}

   


