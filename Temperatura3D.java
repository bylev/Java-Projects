import java.util.*;

public class Temperatura3D {
    public static void main(String[] args){
        
        double[][][] cubo = new double[2][3][2]; // 2 días, 3 hrs x dia, 2 sensores

        Rellenar(cubo);
        MostrarElementos(cubo);
        SumaTotal(cubo);
        PromedioTotal(cubo);
        maxmin(cubo);
    }

    static void Rellenar(double[][][] cubo){

        Scanner sc = new Scanner(System.in); 

        for(int i= 0; i<cubo.length; i++){
            for(int j = 0; j< cubo[i].length; j++){
                for(int k=0; k<cubo[i][j].length; k++){
                    System.out.println("==== RELLENA EL ARREGLO ====");
                    System.out.println("Elemento en fila " + i + ", columna " + j + ", profundidad " + k + ": ");
                    cubo[i][j][k] = sc.nextDouble();
                }
            }
        }
        sc.close();
    }

    static void MostrarElementos(double[][][] cubo){
        for(int i=0; i<cubo.length; i++){
            for(int j = 0; j<cubo[i].length; j++){
                for(int k = 0; k<cubo[i][j].length; k++){
                    System.out.print(cubo[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
    }

    static void SumaTotal(double[][][] cubo){
        int suma = 0;
        for(int i= 0; i < cubo.length; i++){
            for(int j = 0; j < cubo[i].length; j++){
                for(int k = 0; k<cubo[i][j].length; k++){
                    suma+= cubo[i][j][k];
                }
            }
        }
        System.out.println("Suma total: "+ suma);
    }

    static void PromedioTotal(double[][][] cubo){
        int total = 0;
        double suma = 0;
        for(int i = 0; i<cubo.length; i++){
            for(int j = 0; j<cubo[i].length; j++){
                for(int k=0; k<cubo[i][j].length; k++){
                    suma+=cubo[i][j][k];
                    total+=1;
                }
            }
        }
        double promedio = (double) suma / total;
        System.out.println("Promedio Total: " + promedio);
        }

    static void maxmin(double[][][] cubo){
        double max = cubo[0][0][0];
        double min = cubo[0][0][0];

        for(double[][] matriz : cubo){ // recorrer cada matriz 2D
            for(double[] fila : matriz){ // recorrer cada fila
                for(double valor : fila){ // recorrer cada valor
                    if(valor > max) max = valor;
                    if(valor < min) min = valor;
                }
            }
        }
        System.out.println("Valor maximo: " + max);
        System.out.println("Valor minimo: " + min);
    }

        
}
