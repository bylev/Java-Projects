import java.util.*;

public class BurbujaBinaria {
    public static void main(String[] args) {
        int[] arreglo = new int[10];
        Scanner sc = new Scanner (System.in);
        
        for(int i= 0; i<arreglo.length; i++){
            arreglo[i] = (int)(Math.random()*10);
        }

        System.out.println("Arreglo original: " + Arrays.toString(arreglo));
        int[] ArregloOrdenado = arreglo.clone();
        Burbuja(ArregloOrdenado);
        System.out.println("Arreglo ordenado: " + Arrays.toString(ArregloOrdenado));
        System.out.println("================================================");
        int x = 0;
        System.out.println("Ingresa el número a buscar: ");
        x = sc.nextInt();
        int resultado = busquedaBinaria(ArregloOrdenado, x);
        String encontrado = (resultado != -1) ? "Se encontró el resultado en la posición " + resultado + "." : "No se encontró el número en el arreglo.";
        System.out.println(encontrado);
       
       //Conntar cuántos números similares al que se busca hay.
        int suma = 0;
        for(int n : ArregloOrdenado){
            if(n == x){
                suma++;
            }
        }

        System.out.println("Números repetidos: " + suma);
        sc.close();
    }

    static void Burbuja(int[] arreglo){
        for(int i=0; i<arreglo.length-1; i++){
            for(int j = 0; j<arreglo.length-1-i; j++){
                if(arreglo[j] > arreglo[j+1]){
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temp;
                }
            }
        }
    }

    static int busquedaBinaria(int[] arreglo, int x){
        int ini =0, fin = arreglo.length-1;
        while(ini<=fin){
            int mid = (ini + fin)/2;
            if (arreglo[mid] == x)
                return mid;
            else if (arreglo[mid] < x)
                ini = mid + 1;
            else
                fin = mid - 1;
        }
        return -1;
    }
    
}
