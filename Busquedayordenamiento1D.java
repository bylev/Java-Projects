import java.util.*;


public class Busquedayordenamiento1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int[] arreglo = new int[10];
        
        for(int i =0 ; i<arreglo.length; i++){
            System.out.println("Ingresa el valor de la posición " + i + ": ");
            int valor = sc.nextInt();
            arreglo[i] = valor;
        }

        System.out.println("Arreglo Original: " + Arrays.toString(arreglo));
        System.out.println("Número a buscar en el arreglo: ");
        int buscar = sc.nextInt();
        int pos = busquedaLineal(arreglo, buscar);
        
        // if(busquedaLineal(arreglo, buscar) != -1){
        //     System.out.println("El número se encontró en la posición: " + busquedaLineal(arreglo, buscar));
        // } else{
        //     System.out.println("El número no se encuentra en el arreglo.");
        // }
        if(pos != -1){
            System.out.println("El número se encontró en la posición: " + pos);
        }else{
            System.out.println("El número no se encontró en el arreglo.");
        }

        sc.close();
        
    }

    public static int busquedaLineal(int[] arreglo, int x ){
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i] == x) return i; 
        }
        return -1;
    }

}
