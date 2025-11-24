import java.util.*;

public class Calificaciones2D {
    public static void main(String[] args){  
        int[][] arreglo = new int[3][3];
        
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < 3;i++ ){
            for(int j = 0; j<3; j++){
                System.out.println("Ingresa la calificación del Alumno " + (i+1) + ", unidad " + (j+1) + ": ");
                arreglo[i][j] = sc.nextInt();
            }
        }

        //Mostrar matriz
        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++){
                System.out.print(arreglo[i][j] + " ");
            }
            System.out.println();
        }

        promedioFilas(arreglo);
        promedioColumnas(arreglo);
        maxmin(arreglo);

        sc.close();
}
    static void promedioFilas(int[][] arreglo) {
        int filas = arreglo.length;
        int columnas = arreglo[0].length;

        for (int fila = 0; fila < filas; fila++) {
            int suma = 0;  

            for (int col = 0; col < columnas; col++) {
                suma += arreglo[fila][col];  
            }

            double promedio = (double) suma / columnas;
            System.out.println("Promedio Estudiante " + (fila + 1) + ": " + promedio);
        }
}

    static void promedioColumnas(int[][] arreglo) {
        int filas = arreglo.length;
        int columnas = arreglo[0].length;

        for (int col = 0; col < columnas; col++) {
            int suma = 0;  

            for (int fila = 0; fila < columnas; fila++) {
                suma += arreglo[fila][col];  
            }

            double promedio = (double) suma / filas;
            System.out.println("Promedio Unidad " + (col+ 1) + ": " + promedio);
        }
}

    static void maxmin(int[][] arreglo){
        int max = arreglo[0][0]; 
        int min = arreglo[0][0];

        for(int[] fila : arreglo){
            for(int valor: fila){
                if(valor > max) max = valor;
                if(valor < min) min = valor;
            }
        }
        System.out.println("Valor max: " + max);
        System.out.println("Valor min: " + min);
    }
}