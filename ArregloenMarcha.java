/** =====================================================================
 * Hecho por: Diego Ramírez y Michelle Cámara
 * Realizado como Actividad 1 de la materia de programación estructurada 
 * en el Tecnológico de Software.
 ========================================================================**/


import java.util.Scanner;

public class ArregloenMarcha{
    public static final Scanner sc = new Scanner(System.in);

    
 
    static int[] invertirOrden(int[] A) {
        int[] invertido = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            invertido[i] = A[A.length - 1 - i];
        }
        
        return invertido;
    }
    
    static void MostrarArreglo(int[] arreglo) {

        System.out.println("\n--- Contenido del Arreglo ---");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Posición " + i);
            System.out.println("Contiene el número: " + arreglo[i]);
            System.out.println("---------------------------");
        }
    }

 
    static void ParesArreglo(int[] arreglo){

        System.out.println("\n=== Números Pares en el Arreglo ===");
       
        int parescontad0r = 0; 

        for(int i = 0; i < arreglo.length; i++){
            
            if(arreglo[i] % 2 == 0) {
                System.out.println("El número par es: " + arreglo[i] + " en la posición: " + i );
                parescontad0r++;
            }
        }
        
       
        if(parescontad0r == 0) {
            System.out.println("No se encontraron números pares en el arreglo ingresado.");
        }
        System.out.println("===================================");
    }

    static void OrdenarArreglo(int[] arreglo){
        QuickSort(arreglo, 0, arreglo.length -1);
        System.out.println("Arreglo ordenado de menor a mayor:");
        MostrarArreglo(arreglo);
    }

    static void QuickSort(int[] arreglo, int inicio, int fin){
        if(inicio < fin){
            int pivote = particion(arreglo, inicio, fin);
            QuickSort(arreglo, inicio, pivote - 1);
            QuickSort(arreglo, pivote + 1, fin);
        }
    }

    static int particion(int[] arreglo, int inicio, int fin){
       int pivote = arreglo[fin];
       int i = inicio -1;

       for(int j = inicio; j<fin; j++){
        if(arreglo[j] <= pivote){
            i++;
            int temp = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = temp;
        }
       }

         int temp = arreglo[i + 1];
         arreglo[i + 1] = arreglo[fin];
         arreglo[fin] = temp;
         return i + 1;
        }
    
    static int BusquedaArreglo(int[] numeros2, int x){
        System.out.println("Ingresa el número a buscar: ");
        x = sc.nextInt();
        int inicio = 0;
        int fin  = numeros2.length -1;
        while(inicio <= fin){
            int mid = (inicio + fin)/2;
            if(numeros2[mid] == x) return mid;
            else if(numeros2[mid] < x) inicio = mid +1;
            else fin = mid -1;
        }

        return -1;
        }

    static void main(String[] args) {
        int[] numeros2 = new int[10];    
        int opcion;
        
        do {
            System.out.println("============ MENÚ ===============");
            System.out.println("1. Ingresar elementos al arreglo.");
            System.out.println("2. Mostrar elementos del arreglo.");
            System.out.println("3. Mostrar el total de elementos pares en el arreglo.");
            System.out.println("4. Invertir arreglo.");
            System.out.println("5. Ordenar arreglo (de menor a mayor).");
            System.out.println("6. Buscar elemento en el arreglo.");
            System.out.println("7. Salir.");
            System.out.print("Seleccione una opción (1-7): ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < numeros2.length; i++) {
                        System.out.print("Ingrese el número para la posición " + i + ": ");
                        int numeroIngresado = sc.nextInt();
                        numeros2[i] = numeroIngresado;
                    }
                    System.out.println("\nNúmeros ingresados con éxito.");
                    break;
                    
                case 2: 
                    MostrarArreglo(numeros2);
                    break;
                    
                case 3:
                    ParesArreglo(numeros2);
                    break;
                    
                case 4:
                    int[] numerosInvertidos = invertirOrden(numeros2);
                    System.out.println("\n=== Arreglo Invertido ===");
                    MostrarArreglo(numerosInvertidos);
                    break;
                case 5:
                    OrdenarArreglo(numeros2);
                    break;
                case 6:
                    int x = 0; 
                    int resultado = BusquedaArreglo(numeros2, x);
                    if (resultado != -1) {
                        System.out.println("Número encontrado en la posición: " + resultado);
                    } else {
                        System.out.println("Número no encontrado en el arreglo.");
                    }
                case 7: 
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 7.");
                    break;  

            }    
        } while (opcion != 7);

    }
}