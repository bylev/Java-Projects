package Creacion_func;
import java.util.*;

public class ciclo{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.println("Ingresa un número: ");
            String numero = sc.nextLine();

            int numeroConvertido=convertir(numero);

            ulam(numeroConvertido);

        } catch(NumberFormatException e){
            System.out.println("Error: Debes ingresar un número entero válido.");
            System.out.println("Detalle: " + e.getClass().getSimpleName() + " --> " + e.getMessage());
            return;
        } finally{
            System.out.println("Finalizando el programa. Cerrando recursos...");
            sc.close();
        }
    } 
        static int convertir(String numero){
            int entero = Integer.parseInt(numero);
            return entero;
        }
        public static void ulam(int n){
            while(n != 1 ){
                if (n % 2 ==0 ){
                    n = n/2;
                }else{
                    n = (n*3)+1;
                }
                System.out.println(n);
            }
        }
    }