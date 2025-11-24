import java.util.*;


public class Transpuesta3D {

    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("========= TRANSPUESTA DE UNA MATRIZ 3D ===========");

        System.out.println("Ingresa el tamaño de la matriz cuadrada 3D");

        System.out.println("Filas: ");
        int filas = sc.nextInt();
        System.out.println("Columnas: ");
        int columnas = sc.nextInt();
        System.out.println("Capas: ");
        int capas = sc.nextInt();

        int[][][] cubo = new int[filas][columnas][capas];

        System.out.println("======== AÑADIR ELEMENTOS DE LAS MATRIZ 3D ============");
        RellenarMatriz(cubo);
        mostrarMatriz(cubo);
        System.out.println("========TRANSPUESTA ===============");
        transponer(cubo);
        System.out.println("======== VALOR MAXIMO Y MINIMO ==========");
        maxmin(cubo);
        System.out.println("=========== SUMA POR CAPAS =============");
        SumaCapas(cubo);
        System.out.println("============= APLANAR Y ORDENAR ============");
        int[] vector = aplanarCubo(cubo);
        System.out.println("Vector: " + Arrays.toString(vector));
        ordenarCubo(vector);
        System.out.println("========= ORDENAR CON BUBBLE ==========");
        ordenarBubble(vector);
        System.out.println("Vector ordenado: " + Arrays.toString(vector));
        System.out.println("================  BUSQUEDA =================");
        System.out.println("Ingresa el número que quieres buscar: ");
        int valor = sc.nextInt();
        int[] pos = busquedaSecuencial(cubo, valor);
        if(pos[0] != -1){
            System.out.println("El valor se encontró en la posición: [" + filas + ", " + columnas + ", " + capas+"]");
        } else{ 
            System.out.println("La posición no se encuentra en la matriz.");
        }


        
    }

    static void RellenarMatriz(int[][][] cubo){
        for(int i = 0; i < cubo.length; i++){
            for(int j = 0; j < cubo[i].length; j++){
                for(int k =0; k<cubo[i][j].length; k++){
                    System.out.println("Elemento en f" + i+ ", col" + j + ", capa" + k + ": ");
                    cubo[i][j][k] = sc.nextInt();
                }
            }
        }
    }

    static void mostrarMatriz(int[][][] cubo){
        for(int i = 0; i<cubo.length; i++){
            for(int j = 0; j<cubo[i].length; j++){
                for(int k =0; k<cubo[i][j].length; k++){
                    System.out.print(cubo[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
        

    static void transponer(int[][][] cubo){
        int filas = cubo.length;
        int columnas = cubo[0].length;
        int capas = cubo[0][0].length;
        int[][][] cuboT = new int[filas][columnas][capas];

       for(int i = 0; i<capas; i++){    
        for(int j = 0; j<filas; j++){
            for(int k = 0; k<columnas; k++){
                cuboT[k][j][i] = cubo[i][j][k];
            }
        }
       }
       mostrarMatriz(cuboT);
    }

    static void maxmin(int[][][] cubo){
        int max= cubo[0][0][0];
        int min= cubo[0][0][0];

        for(int[][] matriz: cubo){
            for(int[] fila: matriz){
                for(int valor: fila){
                    if(valor > max) max = valor;
                    if(valor < min) min = valor;
                }
            }
        }
        System.out.println("Valor max: " + max + "\nValor mín: " + min);
    }
    
    static void SumaCapas(int[][][] cubo){
        for(int k = 0; k < cubo.length; k++){
            int sumaCapa = 0;
            for(int i = 0; i<cubo[k].length; i++){
                for(int j = 0; j<cubo[k][i].length; j++){
                    sumaCapa+=cubo[k][i][j];
                }
            }
            System.out.println("Suma de la capa " + k + ": " + sumaCapa);
        }
    }

    static int[] aplanarCubo(int[][][] cubo){
        int capas = cubo.length;
        int filas = cubo[0].length;
        int columnas = cubo[0][0].length; 
        int[] vector = new int[capas * filas * columnas];
        int index = 0;

        for(int k = 0; k<capas; k++){
            for(int j =0; j<filas; j++){
                for( int i =0 ; i< columnas; i++){
                    vector[index++] = cubo[k][j][i];
                }
            }
        }
        return vector;
    }

    static void ordenarCubo(int[] vector){
        // funcion predefinida
        Arrays.sort(vector);
        System.out.println("Arreglo ordenado(funcion): " + Arrays.toString(vector));
    }
    
    static void ordenarBubble(int[] vector){
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = 0; j < vector.length - 1 - i; j++) {
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }

    static int[] busquedaSecuencial(int[][][] cubo, int valor){
        for(int i=0; i<cubo.length; i++){
            for(int j = 0; j<cubo[i].length; j++){
                for(int k = 0; k<cubo[i][j].length; k++){
                    if(cubo[i][j][k] == valor){
                        return new int[]{i,j,k};
                    }
                }
            }
        }
        return new int[]{-1,-1,-1};
    }
    
}
