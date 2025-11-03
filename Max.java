import java.util.*;
import java.util.InputMismatchException;

public class Max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{

        System.out.println("Ingresa el primer número: ");
        int n1=sc.nextInt();
        System.out.println("Ingresa el segundo número: ");
        int n2=sc.nextInt();
        System.out.println("Ingresa el tercer número: ");
        int n3=sc.nextInt();

        int max = max(n1, n2, n3);
        System.out.println("El número mayor es: " + max);
        }catch(InputMismatchException e){
            System.out.println("Error: Entrada inválida. Por favor, ingrese un número entero.\n" + e.getClass().getSimpleName() + " --> " + e.getMessage());
            return;
        }finally{
            System.out.println("Finalizando el programa. Cerrando recursos...");
            sc.close();
        }
    }
    public static int max(int n1, int n2, int n3){
        int max = (n1>n2)? n1 : n2;
        max = (n3>max)? n3 : max;
        return max;
    }
}

