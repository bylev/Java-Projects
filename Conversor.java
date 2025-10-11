import java.util.*;

public class Conversor{
    public static void main (String[] args){
        int opcion;
        double valor, resultado;
        final double km_por_milla = 1.609344;
        final double lb_por_kg = 2.20462;
        char seguir;
        Scanner sc = new Scanner(System.in);

        do{

        System.out.println("Seleccione la conversión que desea realizar:");
        System.out.println("1. Celsius --> Fahrenheit");
        System.out.println("2. Fahrenheit --> Celsius");
        System.out.println("3. Kilómetros --> Millas");
        System.out.println("4. Millas --> Kilómetros");
        System.out.println("5. Libras --> Kilogramos");
        System.out.println("6. Kilogramos --> Libras");
        System.out.print("7. Salir\n");
        opcion = sc.nextInt();

        switch(opcion){
            case 1:
                System.out.println("Ingesa °C: ");
                valor = sc.nextDouble();
                resultado = (valor * 9.0/5.0) + 32;
                System.out.println(valor + "°C= " + resultado + "°F");
            break;
            case 2:
                System.out.println("Ingesa °F: ");
                valor = sc.nextDouble();
                resultado = (valor - 32) * 5.0/9.0;
                System.out.println(valor + "°F= " + resultado + "°C");
            break;
            case 3:
                System.out.println("Ingresa km: ");
                valor = sc.nextDouble();
                resultado = valor / km_por_milla;
                System.out.println(valor + " km= " + resultado + " mi");
            break;
            case 4: 
                System.out.println("Ingresa mi: ");
                valor = sc.nextDouble();
                resultado = valor * km_por_milla;
                System.out.println(valor + "mi= " + resultado + "km");
            break;
            case 5: 
                System.out.println("Ingresa lb: ");
                valor = sc.nextDouble();
                resultado = valor * lb_por_kg;
                System.out.println(valor + "lb= " + resultado + "kg");
                
            break;
            case 6:
                System.out.println("Ingresa kg: ");
                valor = sc.nextDouble();
                resultado = valor * lb_por_kg;
                System.out.println(valor + "kg" + resultado + "lb");
            break;
            case 7:
                System.out.println("Saliendo...");
                sc.close();
                return;
            default:
                System.out.println("Opción invalida");
        }
        System.out.println("¿Otra conversión? S/N");
        sc.nextLine();
        String resp = sc.nextLine().trim();
        seguir = resp.isEmpty() ?  'N' : Character.toUpperCase(resp.charAt(0));
        
        } while(seguir == 'S');
        
        System.out.println("Gracias por usar el conversor!");
        
        sc.close();
        
        
    }
}