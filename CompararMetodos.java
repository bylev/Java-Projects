import java.util.Arrays;

public class CompararMetodos {
    public static void main(String[] args) {
    
        int[] arreglo = new int[100];

        for(int i= 0; i < arreglo.length; i++){
            arreglo[i] = (int)(Math.random()*100);
        }

        //Imprimir arreglo
        System.out.println("Arreglo Original: " + Arrays.toString(arreglo));
        int[] arregloburbuja = arreglo.clone();
        Burbuja(arregloburbuja);
        System.out.println("Arreglo burbuja:  " + Arrays.toString(arregloburbuja));
        int[] ASeleccion = arreglo.clone();
        seleccion(ASeleccion);
        System.out.println("Arreglo seleccion: " + Arrays.toString(ASeleccion));
        int[] Ainsercion = arreglo.clone();
        insercion(Ainsercion);
        System.out.println("Arreglo inserción: " + Arrays.toString(Ainsercion));


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

    static void seleccion(int[] arreglo){
        for(int i=0; i<arreglo.length-1; i++){
            int min= i; //posicion del menor

            for(int j=i+1; j<arreglo.length; j++){
                if(arreglo[j] < arreglo[min]){
                    min = j;
                }
            }
            if(min!= i){
                int temp = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min]=temp;
            }
        }
    }

    static void insercion(int[] arreglo){
        for(int i=1; i<arreglo.length;i++){
            int valor=arreglo[i];
            int j = i-1;
            while(j>= 0 && arreglo[j] > valor){
                arreglo[j+1] = arreglo[j];
                j--;
            }
            arreglo[j+1] = valor;
        }
        
    }

}
