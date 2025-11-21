import java.util.*;

public class Invertir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arreglo = new int[5];

        //Ingresar arreglo por teclado
        for(int i=0; i<arreglo.length; i++){
            System.out.println("Ingresa el valor de la posición " + i + ": ");
            int numero = sc.nextInt();
            arreglo[i] = numero;
        }

        //mostrar arreglo
        System.out.println("Arreglo: " + Arrays.toString(arreglo));

        //Invertir arreglo
        int[] ArregloInvertido = new int[arreglo.length];
        for(int i = 0; i<arreglo.length; i++){
            ArregloInvertido[i] = arreglo[arreglo.length-1-i];
        }

        System.out.println("Arreglo Invertido: " + Arrays.toString(ArregloInvertido));

        sc.close();
    }
    
}
