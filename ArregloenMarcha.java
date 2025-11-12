/** =====================================================================
 * Hecho por: Diego Ramírez, Ariff Medina y Michelle Cámara
 * Realizado como Actividad 1 de la materia de programación estructurada 
 * en el Tecnológico de Software.
 ========================================================================**/


import java.util.Scanner;
import java.util.InputMismatchException;


public class ArregloenMarcha{
    public static final Scanner sc = new Scanner(System.in);

    // Función que invierte la posición de los elementos del arreglo
    static int[] invertirOrden(int[] arreglo) {

        int[] invertido = new int[arreglo.length];

        for (int i = 0; i < arreglo.length; i++) {
            invertido[i] = arreglo[arreglo.length - 1 - i];
        }

        System.out.println("\n=== Arreglo Invertido ===");
        return invertido;
    }

    // Esta funcion muestra el arreglo ingresado por el usuario
    static void MostrarArreglo(int[] arreglo) {

        // validación para comprobar si el arreglo tiene contenido
        if (estaVacio(arreglo)) {
            System.out.println("\nError: No se puede realizar. El arreglo está vacío.");
            return;
        }

        System.out.println("\n--- Contenido del Arreglo ---");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Posición " + i);
            System.out.println("Contiene el número: " + arreglo[i]);
            System.out.println("---------------------------");
        }
    }

    // Esta funcion muestra los elementos pares que existen en el arreglo,
    // si el elemento es divisible entre 2, lo muestra en pantalla.
    static void ParesArreglo(int[] arreglo) {

        // validación para comprobar si el arreglo tiene contenido
        if (estaVacio(arreglo)) {
            System.out.println("\nError: No hay elementos pares que mostrar. El arreglo está vacío.");
            return;
        }

        System.out.println("\n=== Números Pares en el Arreglo ===");

        int paresContador = 0;
        int contadores = 0;

        for (int n : arreglo) {
            if (n % 2 == 0)
                contadores++;
        }
        System.out.println("En total en el arreglo hay " + contadores + " pares, los pares son: ");

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] % 2 == 0) {
                System.out.println(arreglo[i]);
                paresContador++;
            }
        }

        if (paresContador == 0) {
            System.out.println("No se encontraron números pares en el arreglo ingresado.");
        }
    }

    // Esta funcion ordena el arreglo de menor a mayor usando QuickSort
    static void OrdenarArreglo(int[] arreglo) {

        // validación para comprobar si el arreglo tiene contenido
        if (estaVacio(arreglo)) {
            System.out.println("\nError: No hay elementos que ordenar. El arreglo está vacío.");
            return;
        }

        // Llamada a la función que ordena los elementos
        QuickSort(arreglo, 0, arreglo.length - 1);
        System.out.println("Arreglo ordenado de menor a mayor:");
        MostrarArreglo(arreglo);
    }

    // Función encargada de hacer el QuickSort
    static void QuickSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            // Se obtiene la posición del pivote y se ordenan los elementos a su alrededor
            int pivote = particion(arreglo, inicio, fin);
            QuickSort(arreglo, inicio, pivote - 1);
            QuickSort(arreglo, pivote + 1, fin);
        }
    }

    static int particion(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        // Coloca el pivote en su posición final y devuelve su índice
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temp;
        return i + 1;
    }

    // Función para buscar un elemento dentro del arreglo
    static int busquedaArreglo(int[] arreglo, int x) {

        // validación para comprobar si el arreglo tiene contenido
        if (estaVacio(arreglo)) {
            return -1;
        }

        // validación para comprobar si el arreglo está ordenado
        if (!estaOrdenado(arreglo)) {
            return -1;
        }

        System.out.print("\nIngresa el número a buscar: ");
        x = sc.nextInt();
        int inicio = 0;
        int fin = arreglo.length - 1;
        while (inicio <= fin) {
            int mid = (inicio + fin) / 2;
            if (arreglo[mid] == x)
                return mid;
            else if (arreglo[mid] < x)
                inicio = mid + 1;
            else
                fin = mid - 1;
        }

        return -1;
    }

    // Validación que comprueba el estado del contenido del arreglo
    static boolean estaVacio(int[] arreglo) {
        for (int n : arreglo) {
            if (n != 0)
                return false;
        }
        return true;
    }

    // Validación que comprueba el estado del orden del arreglo
    static boolean estaOrdenado(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            if (arreglo[i] > arreglo[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numeros2 = new int[10];
        int opcion;

        try {
            do {
                System.out.println("\n============ MENÚ ===============");
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
                        System.out.println();
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
                        MostrarArreglo(numerosInvertidos);
                        break;
                    case 5:
                        OrdenarArreglo(numeros2);
                        break;
                    case 6:
                        int x = 0;
                        int resultado = busquedaArreglo(numeros2, x);

                        // Validaciones de si tiene contenido y si está ordenado
                        if (estaVacio(numeros2)) {
                            System.out.println("\nError: No hay elementos que buscar. El arreglo está vacío.");
                            break;
                        }
                        if (!estaOrdenado(numeros2)) {
                            System.out.println("\nError: El arreglo no está ordenado. Ordénalo antes de buscar.");
                            break;
                        }

                        // Estado final de la busqueda
                        if (resultado != -1) {
                            System.out.println("El número ingresado se encuentra en la posición: " + resultado);
                        } else {
                            System.out.println("Número no encontrado en el arreglo.");
                        }
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("\nOpción no válida. Por favor, seleccione una opción del 1 al 7.");
                        break;
                }
            } while (opcion != 7);
        }

        catch (InputMismatchException e) {
            System.out.println("Error: Entrada no valida. Ingresa únicamente números enteros.");
        }

        sc.close();
    }
}
