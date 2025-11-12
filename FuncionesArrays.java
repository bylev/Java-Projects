import java.util.*;


public class FuncionesArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] Arreglo = new int[5];
        int i;

        for(i= 0; i<Arreglo.length; i++){
            System.out.println("Ingresa un número X en la posición " + i + ": ");
            int numero = sc.nextInt();
            Arreglo[i] = numero;
        } 
         
        System.out.println("Arreglo:" + Arrays.toString(Arreglo));
        System.out.println("Suma total de los elementos: " + Arrays.stream(Arreglo).sum());
        System.out.println("Promedio: " + Arrays.stream(Arreglo).average());
        System.out.println("Número mayor: " + Arrays.stream(Arreglo).max());
        System.out.println("Número menor: "+ Arrays.stream(Arreglo).min());

        //Ordenar arreglo
        Arrays.sort(Arreglo);
        System.out.println(Arrays.toString(Arreglo));

        //Buscar un valor
        System.out.println("Ingresa el valor a buscar: ");
        int x = sc.nextInt();
        int pos = Arrays.binarySearch(Arreglo, x);
        System.out.println("Elemento " + x + " se encuentra en la posición: "+ pos);
        
        sc.close();
    }
}


