import java.util.*;

public class Triangulo {
    public static int lado1;
    public static int lado2;
    public static int lado3;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la longitud del primer lado: ");
        lado1 = sc.nextInt();
        System.out.println("Ingrese la longitud del segundo lado: ");
        lado2 = sc.nextInt();
        System.out.println("Ingrese la longitud del tercer lado: ");
        lado3 = sc.nextInt();

        if(equilatero(lado1, lado2, lado3)){
            System.out.println("Es equilatero. ");
        }else if(escaleno(lado1, lado2, lado3) ){
            System.out.println("Es escaleno. ");
        }else{
            System.out.println("Es sosceles");
        }
        sc.close();
        }

    public static boolean equilatero(int lado1, int lado2, int lado3){
        if(lado1 == lado2 && lado1 == lado3 && lado2 == lado3 ){
            return true;
        }else{
            return false;
        }
    }

    public static boolean escaleno(int lado1, int lado2, int lado3){
        if(lado1 != lado2 && lado1 != lado3 && lado3 != lado2){
            return true;
        }else{
            return false;
        }
    }

}
