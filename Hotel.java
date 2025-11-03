import java.util.*;

public class Hotel {
    public static final Scanner sc = new Scanner(System.in);
    public static String nombre; 
    public static String tipo;
    public static int noches;
    public static boolean desayuno;
    public static double subtotal, base, monto;
    public static double total1 = 0;
    public static double total2 = 0;
  
    

    public static void menuHotel(){

        int opcion;
        do{
            System.out.println("====================");
            System.out.println("     MENÚ HOTEL    ");
            System.out.println("====================");
            System.out.println("1. Cotizar reserva 1");
            System.out.println("2. Cotizar reserva 2");
            System.out.println("3. Mostrar ambas y total acumulado");
            System.out.println("4. Salir");
            System.out.println("\n Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 
        
            switch(opcion){
                case 1:
                    nombre = leerNombre();
                    tipo = leerTipoHabitacion();
                    noches = leerNoches();
                    desayuno = leerDesayuno();
                    subtotal = calcularSubtotal(tipo, noches, desayuno);
                    total1 = totalConImpuesto(monto);
                    ticket(nombre, tipo, noches, desayuno, total1);
                    break;

                case 2:
                    nombre = leerNombre();
                    tipo = leerTipoHabitacion();
                    noches = leerNoches();
                    desayuno = leerDesayuno();
                    subtotal = calcularSubtotal(tipo, noches, desayuno);
                    total2 = totalConImpuesto(monto);
                    ticket(nombre, tipo, noches, desayuno, total2);
                    break;

                case 3:
                    System.out.println("Total reserva 1: $" + total1);
                    System.out.println("Total reserva 2: $" + total2);
                    System.out.println("Total acumulado: $" + (total1 + total2));
                    break;

                case 4:
                    System.out.println("Gracias por usar el sistema de cotización del hotel. Vuelva pronto!");
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while(opcion != 4);
        }


    //Función de tarifa base según tipo de habitación
    public static double tarifaBase(String tipo){
            
            tipo = tipo.toUpperCase();
            switch(tipo){
                case "ESTANDAR":
                    return 800;
                case "DOBLE":
                    return  1200;
                case "SUITE":
                    return 2000;
                default:
                    System.out.println("Tipo de habitación inválido.");
                    return 0;
                }
            }

    public static double calcularSubtotal(String tipo, int noches, boolean desayuno){
            base =tarifaBase(tipo);
            subtotal = base * noches;
           
            if(desayuno){
                subtotal += 150 * noches;
            }
            return subtotal;
        }

    // Funcion para calcular el total con impuesto
    public static double totalConImpuesto(double monto){
        double impuesto = 0.16;
        monto = subtotal;
        return monto * (1 + impuesto);
    }

    // Función para imprimir el ticket
    public static void ticket(String nombre, String tipo, int noches, boolean desayuno, double total){
            System.out.println("-----TICKET DE RESERVA-----");
            System.out.println("Cliente:" + nombre);
            System.out.println("Tipo de habitación:" + tipo);
            System.out.println("Noches:" + noches);

            if(desayuno){
                System.out.println("Incluye desayuno: Sí");
            } else {
                System.out.println("Incluye desayuno: No");
            }
            System.out.println("Total con impuesto: $" + total);
            System.out.println("--------------------------------");
    }

    //Función para leer nombre
    public static String leerNombre(){
        do{
            System.out.println("Ingrese nombre del cliente:");
            nombre = sc.nextLine();
        } while(nombre.equals(""));
        return nombre;
    }

    //Función para leer tipo de habitación
    public static String leerTipoHabitacion(){
        System.out.println("Ingrese tipo de habitación (Estandar, Doble, Suite):");
        tipo = sc.nextLine().toUpperCase();

        if(!tipo.equals("ESTANDAR") && !tipo.equals("DOBLE") && !tipo.equals("SUITE")){
            System.out.println("Tipo inválido. Intente de nuevo.");
            return leerTipoHabitacion();
        } else {
            return tipo;
        }
    }

    //Función para leer número de noches
    public static int leerNoches(){
        try {
            System.out.println("Ingrese número de noches: ");
            noches = sc.nextInt();
            sc.nextLine();
        
            if(noches < 1 || noches > 30){
                throw new IllegalArgumentException("Número de noches inválido.");
            }
            return noches;
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número válido.");
            sc.nextLine(); 
            return leerNoches();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
            return leerNoches();
        }
    }

    //Funcion leer desayuno

    public static boolean leerDesayuno(){
        String respuesta;
        System.out.println("¿Desea incluir el desayuno? (S/N)");
        respuesta= sc.nextLine().toUpperCase();

        if(respuesta.equals("S")){
            return true;
        } else if(respuesta.equals("N")){
            return false;
        } else {
            System.out.println("Respuesta inválida. Intente de nuevo.");
            return leerDesayuno();
        }
    }

    //Programa principal
    public static void main(String[] args) {
            menuHotel();
    }
}




