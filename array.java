import java.util.*;

public class array{
    public static int i;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int[] vector = new int[5];

        for(i=0; i<vector.length; i++){
            System.out.println("Ingresa el número X de la posicion " + i + ": ");
            int numero = sc.nextInt();
            vector[i] = numero;
        }

        
        mostrarElementos(vector);
        operaciones(vector);


        sc.close();
        }

        public static void mostrarElementos(int[] vector){
            i = 0;
            while(i<vector.length){
                System.out.println("Elemento " + i + ": " + vector[i]);
                i++;
            }
        }
        
        public static void operaciones(int[] vector){
            int suma = 0;
            

             for(int n: vector){
                    suma +=n;
            }

            
             double promedio = (double)suma/vector.length;

            //Valor maximo
            int max = vector[0];


            for(int n: vector){
                if(n>max){
                    max = n;
                }
            }

            System.out.println("Suma: " + suma);
            System.out.println("Promedio: " + promedio);
            System.out.println("Número mayor: " + max);

        }

    }


