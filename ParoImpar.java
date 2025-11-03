import java.util.*;


public class ParoImpar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un número entero: ");
       try{
        int numero = sc.nextInt();
        boolean esPar = esPar(numero);
        if (numero == 0){
            System.out.println("El número es cero.");
        } else if (esPar){
            System.out.println("El número es par.");
        } else {
            System.out.println("El número es impar.");
        }
       }catch(InputMismatchException e){
        System.out.println("Error: Entrada inválida. Por favor, ingrese un número entero.\n" + e.getClass().getSimpleName() + " --> " + e.getMessage());
        return;
    }finally{
        System.out.println("Finalizando el programa. Cerrando recursos...");
        sc.close();
    }
    }

    public static boolean esPar(int n){
        return n % 2 == 0;
    }


    
}
