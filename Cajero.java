
import java.util.*;

public class Cajero{
    public static void main(String[] args){
        int pinCorrecto = 1234;
        int intentos = 0;
        int opcion, pinIngresado;
        double saldo =1800.67;
        double monto;
        char seguir;

        Scanner sc = new Scanner(System.in);

        while(intentos < 3){
            System.out.println("Ingrese PIN: ");
            pinIngresado = sc.nextInt();
            if (pinIngresado == pinCorrecto){
                System.out.println("Acceso accedido");
                 do{
            System.out.println("==== CAJERO ====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.println("Elija la opción deseada: ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Su saldo actual es: $ "+ saldo);
                    break;
                case 2: 
                    System.out.println("Digite el monto a depositar: ");
                    monto = sc.nextDouble();
                    if(monto > 0 ){
                        saldo = saldo + monto;
                        System.out.println("Depósito exitoso. Nuevo saldo: $ "+ saldo);
                    }else{
                        System.out.println("Monto invalido.");
                    }
                        break;
                case 3:
                    System.out.println("Monto a retirar: $ ");
                    monto = sc.nextDouble();
                    if(monto <= 0){
                        System.out.println("Monto invalido.");
                    }else if(monto <= saldo){
                        saldo = saldo - monto;
                        System.out.println("Retiro exitoso. Nuevo saldo: $ " + saldo);
                    } else{
                        System.out.println("Fondos insuficientes. ");
                    }
                    break; 
                case 4: 
                    System.out.println("Gracias por usar el cajero.");
                    sc.close();
                    break;
                default:
                    System.out.println("Opción invalida");
                    }

            System.out.println("¿Desea hacer otro movimiento? (S/N)");
            sc.nextLine();
            String seguirSn = sc.nextLine().trim();

            seguir = seguirSn.isEmpty() ? 'N' : Character.toUpperCase(seguirSn.charAt(0));

            } while(seguir == 'S');
            sc.close();
            
    } else{
                intentos++;
                System.out.println("PIN incorrecto. Intentos: " + intentos + "/" + 3);
            } 
            
            if (intentos == 3){
                System.out.println("Cuenta bloqueada. Por favor, consulte con el banco.");
                return;
            }      
}
}
}
