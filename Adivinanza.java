
package Creacion_func;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Adivinanza{

    //* Variables globales */      
    static final int intentos_max = 3;  // intentos permitidos

    public static void main(String[] args) {
        // Variables locales
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int intento = 0;
        int numSecreto = generarSecreto(10); 
        
        System.out.println("Adivina el número secreto entre 1 y " + 10);

        try{

        do {
            System.out.print("Escribe tu intento: ");
            intento = sc.nextInt();
            contador++;

            mostrarPista(intento, numSecreto, contador);

        } while (intento != numSecreto && contador < intentos_max);

        if (intento == numSecreto) {
            System.out.println("¡Correcto! El número secreto era " + numSecreto);
        } else {
            System.out.println("Se acabaron los intentos. El número era " + numSecreto);
        }
    } catch (Exception e) {
        System.out.println("Error: Debes ingresar un número entero válido.");
        System.out.println("Detalle: " + e.getClass().getSimpleName() + " --> " + e.getMessage());
    } finally {
        System.out.println("Finalizando el programa. Cerrando recursos...");
        sc.close();
    }
    }


    static int generarSecreto(int limite) {
        return (int) (Math.random() * limite) + 1;
    }

    
    static void mostrarPista(int intento, int objetivo, int intentosHechos) {
        if (intento == objetivo) return;                   
        if (intentosHechos >= intentos_max) return;        

        if (intento > objetivo) {
            System.out.println("Muy alto. Intenta con un número menor.");
        } else {
            System.out.println("Muy bajo. Intenta con un número mayor.");
        }
    }
}
