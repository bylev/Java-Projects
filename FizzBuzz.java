
import java.util.*;

public class FizzBuzz {

    public static int n;
    public static int i;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingresa un número: ");
        n = sc.nextInt();

        Fizz(n);

        sc.close();
    }

    public static void Fizz(int n){
       for(i=1; i<= n; i++){
        if(i%3 == 0 && i%5 == 0){
            System.out.println("FizzBuzz");
        } else if(i%3 == 0){
            System.out.println("Fizz");
        }else if(i%5 == 0){
            System.out.println("Buzz");
        }else{
            System.out.println(i);}

       }

       }

    }
    