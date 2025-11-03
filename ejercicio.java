package Creacion_func;
import java.util.*;

public class ejercicio{
    static Scanner sc = new Scanner(System.in); //Instancia de la clase Scanner para leer datos
   
    public static int leerNumero(){
        int n;    
        
        do{ 
            System.out.println("Ingresa un número entero positivo: "); 
            n = sc.nextInt(); // Leo n
        } while(n<1);
        // retornar n
        return n;
    }

    public static void cuentaRegresiva(int n){
        System.out.print("Cuenta regresiva: ");
        for(int i = n; i >= 1; i--){ // para cuando i valga n, i debe ser mayor o igual 1, y debe hacer i-1
            System.out.print(i+ " "); // Imprime el valor de i
        }
        System.out.println("¡Despegue!");
    }

    public static void main(String[] args){
        int numero;
        numero = leerNumero();
        cuentaRegresiva(numero);
        
        sc.close();
    }
    
    


}

