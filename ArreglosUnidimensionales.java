import java.util.*;

public class ArreglosUnidimensionales{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int[] arreglo = new int[10];
        int i = 0;
        int suma =0;

        //Pide al usuario calificaciiones
        for(i=0; i<arreglo.length; i++){
            System.out.println("Ingresa la calificación de la posición " + i + ": ");
            int numero = sc.nextInt();
            arreglo[i] = numero;
        }

        //suma de todas las calificaciones
        for(int n: arreglo){
            suma += n;
        }

        //imprimir promedio 
        double promedio = (double)suma/arreglo.length;

        //Encontrar la mayor calificacion
        int max = arreglo[0];
        int min = arreglo[0];

        for(int n: arreglo){
            if(n>max) max = n;
        } 

        for(int n: arreglo){
            if(n<min) min = n;
            }

        //Cuántas son reprobadas
        int reprobadas = 0;
        for(i = 0; i<arreglo.length; i++)
            if(arreglo[i] < 70){
                reprobadas++;
            }


        System.out.println("suma: " + suma);
        System.out.println("Promedio: " + promedio);
        System.out.println("Número mayor: " + max);
        System.out.println("Número menor: " + min);
        System.out.println("reprobadas: " + reprobadas);
        sc.close();

        }


    }

