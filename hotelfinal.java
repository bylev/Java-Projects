import java.util.Scanner;
import java.util.InputMismatchException;

// Clase principal del sistema de reservas de hotel
public class hotelfinal{

    // Variables globales para que las funciones puedan acceder a ellas

    static Scanner sc;
    static String nombre, tipo;
    static int noches;
    static boolean desayuno;
    static double subtotal, base, total, impuesto, monto;

    public static void main(String[] args) {

        // Declaración de las variables locales
        int opcion;
        double total1, total2;

        total1 = 0;
        total2 = 0;

        sc = new Scanner(System.in);

        do {
            // Llamar a la función que muestra el menú
            menuHotel();

            // Leer la opción seleccionada por el usuario
            opcion = sc.nextInt();
            sc.nextLine();

            // Validar que opcion está entre 1 y 4
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            } // Procesar la opción seleccionada
            switch (opcion) {

                case 1:
                    // Procesar primera reserva: recopilar datos y calcular costo
                    nombre = leerNombre();
                    tipo = leerTipoHabitacion();
                    noches = leerNoches();
                    desayuno = leerDesayuno();
                    subtotal = calcularSubtotal(tipo, noches, desayuno);
                    total1 = totalConImpuesto(total);
                    ticket(nombre, tipo, noches, desayuno, monto);
                    break;

                case 2:
                    // Procesar segunda reserva: recopilar datos y calcular costo
                    nombre = leerNombre();
                    tipo = leerTipoHabitacion();
                    noches = leerNoches();
                    desayuno = leerDesayuno();
                    subtotal = calcularSubtotal(tipo, noches, desayuno);
                    total2 = totalConImpuesto(total);
                    ticket(nombre, tipo, noches, desayuno, monto);
                    break;

                case 3:
                    // Mostrar resumen de ambas reservas y total acumulado
                    System.out.println("===== RESUMEN DE RESERVAS =====");
                    System.out.println("Reserva 1: $" + total1);
                    System.out.println("Reserva 2: $" + total2);
                    System.out.println("TOTAL A PAGAR: $" + (total1 + total2));
                    break;
            }

        } while (opcion != 4);

        // Cerrar el scanner al finalizar el programa
        sc.close();
    }

    // ==================================
    // FUNCIONES DEL PROGRAMA
    // ==================================

    // Función que retorna la tarifa base según el tipo de habitación
    public static double tarifaBase(String tipo) {
        tipo = tipo.toUpperCase();
        switch (tipo) {
            case "ESTANDAR":
                return 800;

            case "DOBLE":
                return 1200;

            case "SUITE":
                return 2000;
        }
        return 0;
    }

    // Función que calcula el subtotal incluyendo tipo de habitación, noches y
    // desayuno(opcional)
    public static double calcularSubtotal(String tipo, int noches, boolean desayuno) {
        base = tarifaBase(tipo);
        subtotal = base * noches;
        // Si incluye desayuno, agregar $150 por noche
        if (desayuno == true) {
            subtotal = subtotal + (150 * noches);
        }
        return subtotal;
    }

    // Función que calcula el total agregando impuestos (16%)
    public static double totalConImpuesto(double monto) {
        impuesto = 0.16;
        total = subtotal + (subtotal * impuesto);
        return total;
    }

    // Función que imprime el ticket de reserva con todos los detalles
    public static void ticket(String nombre, String tipo, int noches, boolean desayuno, double total) {
        System.out.println("-----TICKET DE RESERVA-----");
        System.out.println("Cliente:" + nombre);
        System.out.println("Tipo de habitación:" + tipo);
        System.out.println("Noches:" + noches);

        // Mostrar si incluye desayuno o no
        if (desayuno == true) {
            System.out.println("Incluye desayuno: Sí");
        } else {
            System.out.println("Incluye desayuno: No");
        }
        System.out.println("Total con impuesto: $" + total);
        System.out.println("--------------------------------");
    }

    // Función que lee y valida el nombre del cliente (no puede estar vacío)
    public static String leerNombre() {
        do {
            System.out.println("Ingrese nombre del cliente:");
            nombre = sc.nextLine();
        } while (nombre.equals(""));
        return nombre;
    }

    // Función que lee y valida el tipo de habitación (solo acepta 3 opciones)
    public static String leerTipoHabitacion() {
        do {
            System.out.println("Ingrese tipo de habitación (Estándar / Doble / Suite)");
            tipo = sc.nextLine().toUpperCase();

        } while (!tipo.equals("ESTANDAR") && !tipo.equals("DOBLE") && !tipo.equals("SUITE"));
        return tipo;
    }

    // Función que lee y valida el número de noches (entre 1 y 30)
    public static int leerNoches() {
        do {
            try {
                System.out.println("Ingrese número de noches (1-30)");
                noches = sc.nextInt();
                sc.nextLine();

                if (noches < 1 || noches > 30) {
                    System.out.println("Número de noches inválido. Intente de nuevo");
                }

            } catch (InputMismatchException e) {
                // Manejo de errores si el usuario ingresa texto en lugar de número
                System.out.println("Error: ingrese un número entero entre 1 y 30");
                sc.nextLine();
                noches = 0;
            }
        } while (noches < 1 || noches > 30);
        return noches;
    }

    // Función que lee y valida si el cliente quiere desayuno (S/N)
    public static boolean leerDesayuno() {
        String respuesta;
        do {
            System.out.println("¿Desea incluir desayuno? (S/N)");
            respuesta = sc.nextLine().toUpperCase();

            if (respuesta.equals("S")) {
                return true;
            } else if (respuesta.equals("N")) {
                return false;
            } else {
                System.out.println("Respuesta inválida. Use S o N");
            }
        } while (true);
    }

    // Procedimiento que muestra el menú principal
    public static void menuHotel() {
        System.out.println("====================");
        System.out.println("     MENÚ HOTEL    ");
        System.out.println("====================");
        System.out.println("1. Cotizar reserva 1");
        System.out.println("2. Cotizar reserva 2");
        System.out.println("3. Mostrar ambas y total acumulado");
        System.out.println("4. Salir");
        System.out.println("\n Seleccione una opción");
    }

}

