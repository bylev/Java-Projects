import java.util.Scanner; // Importa la clase Scanner para leer datos del usuario desde el teclado

public class ControlTotal { // Declara la clase principal llamada Lavado
    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para capturar entrada del usuario
        boolean continuarServicio = true; // Variable booleana que controla si el programa debe continuar ejecutándose

        // Muestra el encabezado de bienvenida del carwash
        System.out.println("==================================");
        System.out.println("      Bienvenido a Carwash Pro");
        System.out.println("==================================");

        // Ciclo principal WHILE que permite procesar múltiples servicios
        while (continuarServicio) { // Mientras continuarServicio sea true, el ciclo se ejecuta
            // Solicita y captura el nombre del cliente
            System.out.print("Por favor, ingrese su nombre: ");
            String nombre = sc.nextLine(); // Lee una línea completa como el nombre del cliente

            // Muestra el menú principal con los servicios disponibles
            System.out.println("\nEstos son nuestros servicios:\n");

            // Describe el servicio básico con precio y características
            System.out.println("1. Servicio Básico ($80)");
            System.out.println("   - Lavado exterior con shampoo especial");
            System.out.println("   - Enjuague con agua a presión");
            System.out.println("   - Secado manual con microfibra\n");

            // Describe el servicio intermedio con precio y características
            System.out.println("2. Servicio Intermedio ($150)");
            System.out.println("   - Todo lo del Servicio Básico");
            System.out.println("   - Aspirado interior");
            System.out.println("   - Limpieza de vidrios interiores y exteriores");
            System.out.println("   - Limpieza de tablero y puertas\n");

            // Describe el servicio premium con precio y características
            System.out.println("3. Servicio Premium ($250)");
            System.out.println("   - Todo lo del Servicio Intermedio");
            System.out.println("   - Encerado a mano con cera premium");
            System.out.println("   - Limpieza y aromatización de tapicería");
            System.out.println("   - Limpieza profunda de rines y llantas");
            System.out.println("   - Aplicación de protector de plásticos\n");

            // Solicita al usuario que seleccione un servicio
            System.out.print("Por favor, seleccione el servicio que desea (1-3): ");
            int opcion = Integer.parseInt(sc.nextLine().trim()); // Convierte la entrada de texto a número entero

            // Variables para almacenar el servicio seleccionado y su precio
            String servicio = ""; // Almacena el nombre del servicio elegido
            double precio = 0; // Almacena el precio del servicio elegido

            // Estructura switch que asigna el servicio y precio según la opción seleccionada
            switch (opcion) {
                case 1: // Si el usuario eligió la opción 1
                    servicio = "Servicio Básico";
                    precio = 80;
                    break; // Sale del switch
                case 2: // Si el usuario eligió la opción 2
                    servicio = "Servicio Intermedio";
                    precio = 150;
                    break; // Sale del switch
                case 3: // Si el usuario eligió la opción 3
                    servicio = "Servicio Premium";
                    precio = 250;
                    break; // Sale del switch
                default: // Si el usuario eligió una opción no válida (diferente de 1, 2 o 3)
                    System.out.println("Opción no válida. Saliendo del sistema.");
                    sc.close(); // Cierra el Scanner para liberar recursos
                    return; // Termina la ejecución del programa
            }

            // Solicita la fecha para agendar la cita
            System.out.print("\nIngrese la fecha para su cita (dd/mm/aaaa): ");
            String fecha = sc.nextLine(); // Lee la fecha como texto

            // Muestra las opciones de métodos de pago disponibles
            System.out.println("\nMétodos de pago disponibles:");
            System.out.println("1. Tarjeta");
            System.out.println("2. Transferencia");
            System.out.println("3. Efectivo");
            System.out.print("Seleccione el método de pago (1-3): ");
            int metodoPago = Integer.parseInt(sc.nextLine().trim()); // Convierte la opción de pago a número

            // Variables para manejar la información del pago
            String metodoPagoStr = ""; // Almacena el nombre del método de pago en texto
            String cuentaBanco = "1234 5678 9012 3456"; // Número de cuenta bancaria para transferencias
            String referencia = "CW" + (int)(Math.random()*100000); // Genera una referencia aleatoria para transferencias

            // Procesa el pago según el método seleccionado
            switch (metodoPago) {
                case 1: // Pago con tarjeta de crédito/débito
                    metodoPagoStr = "Tarjeta";
                    System.out.println("\nIngrese los datos de su tarjeta para procesar el pago.");
                    System.out.print("Número de tarjeta: ");
                    sc.nextLine(); // Lee el número de tarjeta (simulación, no se guarda)
                    System.out.print("Fecha de expiración (MM/AA): ");
                    sc.nextLine(); // Lee la fecha de expiración (simulación)
                    System.out.print("CVV: ");
                    sc.nextLine(); // Lee el código CVV (simulación)
                    System.out.println("Pago realizado exitosamente con tarjeta.");
                    break;
                case 2: // Pago por transferencia bancaria
                    metodoPagoStr = "Transferencia";
                    System.out.println("\nPara transferencias, use la siguiente cuenta bancaria:");
                    System.out.println("Cuenta: " + cuentaBanco); // Muestra el número de cuenta
                    System.out.println("Referencia: " + referencia); // Muestra la referencia generada
                    System.out.print("Presione Enter cuando haya realizado la transferencia...");
                    sc.nextLine(); // Espera que el usuario confirme la transferencia
                    System.out.println("Transferencia confirmada.");
                    break;
                case 3: // Pago en efectivo
                    metodoPagoStr = "Efectivo";
                    System.out.println("\nEl pago se realizará en efectivo al momento del servicio.");
                    break;
                default: // Método de pago no válido
                    System.out.println("Método de pago no válido. Saliendo del sistema.");
                    sc.close(); // Cierra el Scanner
                    return; // Termina el programa
            }

            // Genera y muestra el comprobante de pago con todos los detalles
            System.out.println("\n==================================");
            System.out.println("        COMPROBANTE DE PAGO");
            System.out.println("==================================");
            System.out.println("Cliente: " + nombre); // Muestra el nombre del cliente
            System.out.println("Servicio: " + servicio); // Muestra el servicio contratado
            System.out.println("Fecha de cita: " + fecha); // Muestra la fecha de la cita
            System.out.println("Método de pago: " + metodoPagoStr); // Muestra el método de pago usado
            System.out.println("Total pagado: $" + precio); // Muestra el precio total del servicio
            if (metodoPago == 2) { // Si el pago fue por transferencia, muestra la referencia
                System.out.println("Referencia de transferencia: " + referencia);
            }
            System.out.println("¡Gracias por agendar su cita en Carwash Pro!");
            System.out.println("==================================");

            // Sección de productos adicionales usando DO-WHILE
            boolean comprarExtras = false; // Controla si el cliente quiere seguir comprando extras
            double totalExtras = 0; // Acumula el total de productos adicionales
            String respuesta; // Almacena la respuesta del usuario

            // Ciclo DO-WHILE que permite comprar productos adicionales
            do { // Ejecuta al menos una vez y repite mientras comprarExtras sea true
                System.out.println("\n¿Desea comprar productos adicionales?");
                System.out.println("1. Aromas ($50)");
                System.out.println("2. Ceras premium ($80)");
                System.out.println("3. Forros de volante ($120)");
                System.out.println("4. No, gracias");
                System.out.print("Seleccione una opción (1-4): ");
                int extraOpcion = Integer.parseInt(sc.nextLine().trim()); // Lee la opción de producto adicional

                // Procesa la selección de producto adicional
                switch (extraOpcion) {
                    case 1: // Aroma seleccionado
                        System.out.println("Aroma añadido por $50");
                        totalExtras += 50; // Suma el precio del aroma al total
                        comprarExtras = true; // Permite seguir comprando
                        break;
                    case 2: // Cera premium seleccionada
                        System.out.println("Cera premium añadida por $80");
                        totalExtras += 80; // Suma el precio de la cera al total
                        comprarExtras = true; // Permite seguir comprando
                        break;
                    case 3: // Forro de volante seleccionado
                        System.out.println("Forro de volante añadido por $120");
                        totalExtras += 120; // Suma el precio del forro al total
                        comprarExtras = true; // Permite seguir comprando
                        break;
                    case 4: // No quiere más productos
                        comprarExtras = false; // Termina el ciclo de compras adicionales
                        break;
                    default: // Opción no válida
                        System.out.println("Opción no válida.");
                        comprarExtras = true; // Continúa preguntando por ser opción inválida
                        continue; // Vuelve al inicio del ciclo do-while
                }

                // Si no eligió "No, gracias", pregunta si quiere más productos
                if (extraOpcion != 4) {
                    System.out.print("¿Desea agregar otro producto? (s/n): ");
                    respuesta = sc.nextLine().trim().toLowerCase(); // Lee y convierte a minúsculas
                    // Continúa comprando si responde "s" o "si"
                    comprarExtras = respuesta.equals("s") || respuesta.equals("si");
                }

            } while (comprarExtras); // Repite mientras el cliente quiera seguir comprando

            // Muestra el resumen de compra si compró productos adicionales
            if (totalExtras > 0) { // Solo si el total de extras es mayor que 0
                System.out.println("\n--- RESUMEN DE COMPRA ---");
                System.out.println("Servicio de lavado: $" + precio); // Precio del servicio principal
                System.out.println("Productos adicionales: $" + totalExtras); // Total de productos extras
                System.out.println("TOTAL: $" + (precio + totalExtras)); // Suma total de todo
                System.out.println("-------------------------");
            }

            // Ciclo FOR para mostrar las próximas fechas disponibles
            System.out.println("\nPróximas fechas disponibles:");
            for (int i = 1; i <= 3; i++) { // Repite 3 veces (i va de 1 a 3)
                // Muestra las próximas 3 fechas disponibles (11, 12, 13 de enero)
                System.out.println(i + ". " + (10 + i) + "/01/2025");
            }

            // Pregunta si el cliente quiere lavar otro vehículo
            System.out.print("\n¿Desea agendar el lavado de otro vehículo? (s/n): ");
            String otroVehiculo = sc.nextLine().trim().toLowerCase(); // Lee y convierte a minúsculas
            
            // Verifica si el usuario NO quiere lavar otro vehículo
            if (!otroVehiculo.equals("s") && !otroVehiculo.equals("si")) {
                continuarServicio = false; // Cambia la variable para terminar el ciclo while principal
                System.out.println("\n¡Gracias por elegir Carwash Pro! ¡Hasta la próxima!");
            } else { // Si SÍ quiere lavar otro vehículo
                // Muestra un separador visual para el nuevo servicio
                System.out.println("\n" + "=".repeat(50)); // Repite el símbolo "=" 50 veces
                System.out.println("        NUEVO SERVICIO");
                System.out.println("=".repeat(50)); // Repite el símbolo "=" 50 veces
            }
        } // Fin del ciclo while principal

        sc.close(); // Cierra el Scanner para liberar recursos del sistema
    } // Fin del método main
} // Fin de la clase Lavado