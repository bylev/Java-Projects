import java.util.Scanner;
import java.util.InputMismatchException;

public class Hoteldekiki {
    public static Scanner sc = new Scanner(System.in);
    public static String nombre, tipo;
    public static int noches;
    public static boolean desayuno;
    public static double subtotal, base, total, impuesto, monto;
    public static double total1 = 0;
    public static double total2 = 0;

    private static final double Tarifa_Estandar = 800;
    private static final double Tarifa_Doble = 1200;
    private static final double Tarifa_Suite = 2000;
    private static final double Tarifa_Desayuno = 150;
    private static final double Tasa_Impuesto = 0.16;

    public static void MostrarHotel() {
        System.out.println("=================================");
        System.out.println("Bienvenidos al hotel de kiki");
        System.out.println("=================================");
        System.out.println("1. Cotizar reserva 1");
        System.out.println("2. Cotizar reserva 2");
        System.out.println("3. Mostrar ambas y total acumulado");
        System.out.println("4. Salir");
        System.out.println("Seleccione una opción (1-4): ");
    }

    public static void MenuHotel() {
        int opcion;
        do {
            MostrarHotel();
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción no valida\n");
                    continue;
                }
                
                switch (opcion) {
                    case 1:
                        procesarReserva(1);
                        break;
                    case 2:
                        procesarReserva(2);
                        break;
                    case 3:
                        System.out.println("\nTotal reserva 1: $" + total1);
                        System.out.println("Total reserva 2: $" + total2);
                        System.out.println("total acumulado: $" + (total1 + total2) + "\n");
                        break;
                    case 4:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("error: ingrese un numero valido\n");
                sc.nextLine();
                opcion = 0;
            }
        } while (opcion != 4);
        
        System.out.println("gracias por usar el sistema de cotizacion del hotel. vuelva pronto!");
    }

    private static void procesarReserva(int numeroReserva) {
        subtotal = 0;
        tipo = leerTipoHabitacion();
        nombre = leerNombre();
        noches = leerNoches();
        desayuno = leerDesayuno();

        subtotal = calcularSubtotal(tipo, noches, desayuno);
        total = totalConImpuesto(subtotal);
        
        if (numeroReserva == 1) {
            total1 = total;
        } else {
            total2 = total;
        }
        
        ticket(nombre, tipo, noches, desayuno, total);
    }

    public static double TarifaBase(String tipo) {
        tipo = tipo.toLowerCase();
        switch (tipo) {
            case "estandar":
                return Tarifa_Estandar;
            case "doble":
                return Tarifa_Doble;
            case "suite":
                return Tarifa_Suite;
            default:
                return 0.0;
        }
    }

    public static double calcularSubtotal(String tipo, int noches, boolean desayuno) {
        base = TarifaBase(tipo);
        double subtotalCalculado = base * noches;
        
        if (desayuno) {
            subtotalCalculado += Tarifa_Desayuno * noches;
        }
        
        return subtotalCalculado;
    }

    static double totalConImpuesto(double monto) {
        return monto * (1 + Tasa_Impuesto);
    }

    public static void ticket(String nombre, String tipo, int noches, boolean desayuno, double total) {
        System.out.println("\n----- TICKET DE RESERVA -----");
        System.out.println("Cliente: " + nombre);
        System.out.println("Tipo de habitacion: " + tipo);
        System.out.println("Noches: " + noches);
        System.out.println("Desayuno: " + (desayuno ? "Si" : "No"));
        System.out.println("Total: $" +  total);
        System.out.println("--------------------------------\n");
    }

    public static String leerTipoHabitacion() {
        System.out.print("Tipo de habitacion (estandar/doble/suite): ");
        tipo = sc.nextLine().trim().toLowerCase();
        
        if (!tipo.equals("estandar") && !tipo.equals("doble") && !tipo.equals("suite")) {
            System.out.println("tipo incorrecto. Intente de nuevo.\n");
            return leerTipoHabitacion();
        }
        return tipo;
    }

    public static String leerNombre() {
        do{
            System.out.println("Ingrese nombre del cliente:");
            nombre = sc.nextLine();
        } while(nombre.equals(""));
        return nombre;
    }

    public static int leerNoches() {
        try {
            System.out.print("Numero de noches (1-30): ");
            noches = sc.nextInt();
            sc.nextLine();
            
            if (noches < 1 || noches > 30) {
                System.out.println("Número de noches inválido. Intente de nuevo.\n");
                return leerNoches();
            }
            return noches;
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un numero válido");
            sc.nextLine();
            return leerNoches();
        }
    }

    public static boolean leerDesayuno() {
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

    public static void main(String[] args) {
        MenuHotel();
    }
}
