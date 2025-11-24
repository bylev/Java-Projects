import java.util.*;


public class Transponer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas, columnas;

        System.out.println("====== SELECCIONAR TAMAÑO DE LA MATRIZ CUADRADA ========");
        System.out.println("Ingresa el número de filas: ");
        filas = sc.nextInt();
        System.out.println("Ingresa el número de columnas: ");
        columnas = sc.nextInt();

        int[][] matriz = new int[filas][columnas];

        for(int i = 0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                System.out.println("Elemento en la fila " + i + ", columna " + j + ": ");
                matriz[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matriz original: ");
        MostrarMatriz(matriz);
        PromedioFilas(matriz, filas, columnas);
        promedioColumnas(matriz, filas, columnas);
        maxmin(matriz);
        System.out.println("Transpuesta: ");
        transponer(matriz);
        sc.close();

    }

    static void transponer(int[][] matriz){
        int[][] matrizT = new int[matriz[0].length][matriz.length];


        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matrizT[j][i] = matriz[i][j];
            }
        }

        MostrarMatriz(matrizT);        
    }
    
    static void MostrarMatriz(int[][] matriz){
        for(int i = 0 ; i<matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void PromedioFilas(int[][] matriz, int filas, int columnas){
        
        for(int i = 0; i < filas; i++){
            int suma = 0;
            for(int j = 0; j< columnas; j++){
                suma+= matriz[i][j];
            }
            double promedio = (double) suma/ columnas;
            System.out.println("Promedio (fila " + i + "): " + promedio);
             
        }
    }

    static void promedioColumnas(int[][] matriz, int filas, int columnas){
        for(int j = 0; j<columnas; j++){
            int suma = 0;
            for(int i = 0; i<filas; i++){
                suma+=matriz[i][j];
            }
            double promedio = (double) suma/filas;
            System.out.println("Promedio (columa " + j + "): " + promedio);
        }
    }
    
    static void maxmin(int[][] matriz){
        int max = matriz[0][0];
        int min = matriz[0][0];

        for(int[] fila: matriz){
            for(int valor: fila){
                if(valor>max) max = valor;
                if(valor<min) min = valor;
            }
        }
        System.out.println("El valor máximo: " + max);
        System.out.println("El valor mínimo: " + min);
    }

}
