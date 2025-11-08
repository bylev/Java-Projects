import java.util.*;


public class OrdenayBusca {
    public static int[] Arreglo = new int[10];
    public static final Scanner sc = new Scanner(System.in);  
    public static void main(String[] args) {  

        for(int i = 0; i<Arreglo.length; i++){
            System.out.println("Ingresa un número X en la posición " + i + ": ");
            int numero = sc.nextInt();
            Arreglo[i] = numero;
        }

        mostrarElementos(Arreglo);
        BubbleSort(Arreglo);
        System.out.println("Arreglo ordenado de menor a mayor:");
        mostrarElementos(Arreglo);
        buscarNumero(Arreglo);

    }

    static void mostrarElementos(int[] Arreglo){
        int i = 0;
        while(i < Arreglo.length){
            System.out.println("Elemento " + i + ": " + Arreglo[i]);
            i++;
        }
    }

    static void BubbleSort(int[] Arreglo){

        int n = Arreglo.length;
        for(int i = 0; i < n-1; i++ ){
            for(int j=0; j<n-1; j++){
                if(Arreglo[j] > Arreglo[j+1]){
                    int temp = Arreglo[j];
                    Arreglo[j] = Arreglo[j+1];
                    Arreglo[j+1] = temp;
                }
            }
        }
    }
    
    static void buscarNumero(int[] Arreglo){
        System.out.println("Ingrese el número a buscar: ");
        int numeroaBuscar= sc.nextInt();
        boolean encontrado = false;
        int n = Arreglo.length;
        int i;

        for(i = 0; i < n; i++){
            if(Arreglo[i] == numeroaBuscar){
                encontrado = true;
                break;
            }
        }

        if(encontrado == true){
            System.out.println("El número se encontró en la posición " +  i + ".");
        }else{
            System.out.println("El número no se ha encontrado");
        }

        }
    }

    

