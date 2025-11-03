import java.util.*;

public class MenuRecursivo {

    // Variables globales 

    public static final Scanner sc = new Scanner(System.in);
    public static boolean continuarServicio;
    public static String servicio = "";
    public static int precio = 0;  
    public static String nombre = "";
    public static String metodoPagoStr = "";
    public static final String cuentaBanco = "1234 5678 9012 3456";
    public static String fecha = "";
    public static String referencia = "CW" + (int)(Math.random()*100000); 
    static boolean comprarExtras = false;
    static double totalExtras = 0.0;


    //Procedimiento que muestra el encabezado
    public static void encabezado(){
        System.out.println("==================================");
        System.out.println("      Bienvenido a Carwash Pro");
        System.out.println("==================================");
    }

    //Procedimiento que muestra el Menú
    public static void mostrarMenu(){
        try{
            System.out.print("Por favor, ingrese su nombre: ");
            nombre = sc.nextLine();

            // Servicios
            System.out.println("1. Servicio Básico ($80)");
            System.out.println("   - Lavado exterior con shampoo especial");
            System.out.println("   - Enjuague con agua a presión");
            System.out.println("   - Secado manual con microfibra\n");

            System.out.println("2. Servicio Intermedio ($150)");
            System.out.println("   - Todo lo del Servicio Básico");
            System.out.println("   - Aspirado interior");
            System.out.println("   - Limpieza de vidrios interiores y exteriores");
            System.out.println("   - Limpieza de tablero y puertas\n");

            System.out.println("3. Servicio Premium ($250)");
            System.out.println("   - Todo lo del Servicio Intermedio");
            System.out.println("   - Encerado a mano con cera premium");
            System.out.println("   - Limpieza y aromatización de tapicería");
            System.out.println("   - Limpieza profunda de rines y llantas");
            System.out.println("   - Aplicación de protector de plásticos\n");

            System.out.print("Por favor, seleccione el servicio que desea (1-3): ");
            int opcion = Integer.parseInt(sc.nextLine().trim());
        
            switch (opcion) {
                case 1:
                    servicio = "Servicio Básico";
                    precio = 80;
                    break;
                case 2:
                    servicio = "Servicio Intermedio"; 
                    precio = 150;
                    break;
                case 3:
                    servicio = "Servicio Premium";
                    precio = 250;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida (1-3).");
                    mostrarMenu(); 
                    return;
            }
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
            System.out.println("Por favor, intente nuevamente.");
            mostrarMenu(); 
        }
    }
    
        //Función para agendar la cita 
        public static void agendarCita(){
            try{
                mostrarFechas();
                boolean fechaValida = false;
                do {
                    System.out.println("Ingrese la fecha para su cita (DD/MM/AAAA): ");
                    fecha = sc.nextLine();
                    if (fecha.matches("^([0-2][0-9]|3[0-1])/([0][1-9]|1[0-2])/\\d{4}$")) {
                        fechaValida = true;
                    } else {
                        System.out.println("Formato de fecha inválido. Por favor, ingrese la fecha en formato DD/MM/AAAA.");
                    }
                } while (!fechaValida);
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
                System.out.println("Por favor, intente nuevamente.");
                agendarCita(); 
            }
        }

        //Procedimiento para seleccionar el método de pago
        public static void seleccionarMetodoPago(){
            try {
                System.out.println("\nMétodos de pago disponibles:");
                System.out.println("1. Tarjeta");
                System.out.println("2. Transferencia");
                System.out.println("3. Efectivo");
                System.out.print("Seleccione el método de pago (1-3): ");
                int metodoPago = Integer.parseInt(sc.nextLine().trim()); 

                switch (metodoPago) {
                    case 1:
                        metodoPagoStr = "Tarjeta";
                        break;
                    case 2:
                        metodoPagoStr = "Transferencia";
                        break;
                    case 3:
                        metodoPagoStr = "Efectivo";
                        break;
                    default:
                        System.out.println("Método de pago no válido. Por favor, seleccione una opción válida (1-3).");
                        seleccionarMetodoPago();
                        return;
                }
            }
            catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
                System.out.println(("Detalle: " + e.toString()));
                System.out.println("Por favor, intente nuevamente.");
                seleccionarMetodoPago();
            }
        }

            //Funcion para mostrar comprobante
            public static void mostrarComprobante(){
                System.out.println("\n==================================");
                System.out.println("        COMPROBANTE DE PAGO");
                System.out.println("==================================");
                System.out.println("Cliente: " + nombre);
                System.out.println("Servicio: " + servicio);
                System.out.println("Fecha de cita: " + fecha);
                System.out.println("Método de pago: " + metodoPagoStr);
                System.out.println("Total pagado: $" + precio);

                if(metodoPagoStr.equals("Transferencia")){
                    System.out.println("Número de cuenta para transferencia: " + cuentaBanco);
                }

                System.out.println("¡Gracias por agendar su cita en Carwash Pro!");
                System.out.println("==================================");
            }


        //Procedimiento para mostrar submenu de productos adicionales.
        public static void mostrarSubmenu(){
            String respuesta;

            System.out.println("\n¿Desea comprar productos adicionales?");
            System.out.println("1. Aromas ($50)");
            System.out.println("2. Ceras premium ($80)");
            System.out.println("3. Forros de volante ($120)");
            System.out.println("4. No, gracias");
            System.out.print("Seleccione una opción (1-4): ");
            int extraOpcion = Integer.parseInt(sc.nextLine().trim()); 
            
            switch(extraOpcion){
                case 1: // Aroma seleccionado
                        System.out.println("Aroma añadido por $50");
                        totalExtras += 50; // Suma el precio del aroma al total
                        comprarExtras = true; // Permite seguir comprando
                        System.out.print("¿Desea agregar otro producto? (SI/NO): ");
                        respuesta = sc.nextLine().trim().toUpperCase();
                        if(respuesta.equals("SI")){
                            mostrarSubmenu();
                        } else {
                            mostrarComprobante();
                        }
                        break;
                    case 2: // Cera premium seleccionada
                        System.out.println("Cera premium añadida por $80");
                        totalExtras += 80; 
                        comprarExtras = true; 
                        System.out.print("¿Desea agregar otro producto? (SI/NO): ");
                        respuesta = sc.nextLine().trim().toUpperCase();
                        if(respuesta.equals("SI")){
                            mostrarSubmenu();
                        } else {
                            mostrarComprobante();
                        }
                        break;
                    case 3: 
                        System.out.println("Forro de volante añadido por $120");
                        totalExtras += 120; 
                        comprarExtras = true; 
                        System.out.print("¿Desea agregar otro producto? (SI/NO): ");
                        respuesta = sc.nextLine().trim().toUpperCase();
                        if(respuesta.equals("SI")){
                            mostrarSubmenu();
                        } else {
                            mostrarComprobante();
                        }
                        break;
                    case 4: 
                        comprarExtras = false; 
                        mostrarComprobante();
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        mostrarSubmenu();
                        break;
            }
        }

        //Funcion para mostrar las proximas fechas disponibles
        public static void mostrarFechas(){
            System.out.println("\nPróximas fechas disponibles:");
            
            int dia = (int)(Math.random()*28)+1;
            int mes = (int)(Math.random()*12)+1;

           
            for (int i = 1; i <= 3; i++) { 
                System.out.println(i + ". " + (dia < 10 ? "0" + i : dia) + "/" + (mes < 10 ? "0" + mes : mes) + "/2025");
            }
        } 

        //Procedimiento que pregunta si desea lavar otro vehículo
        public static void lavarOtroVehiculo(){
            System.out.print("\n¿Desea agendar el lavado de otro vehículo? (s/n): ");
            String otroVehiculo = sc.nextLine().trim().toUpperCase(); 

            if(otroVehiculo.equals("S")|| otroVehiculo.equals("SI")){
                continuarServicio = true;
            } else {
                continuarServicio = false; 
                System.out.println("\n¡Gracias por elegir Carwash Pro! ¡Hasta la próxima!");
                return;
            }
        }

        //Programa principal
    public static void main(String[] args) {
        encabezado();
        continuarServicio = true; 
        while(continuarServicio){
            mostrarMenu();
            agendarCita();
            seleccionarMetodoPago();
            mostrarSubmenu();
            lavarOtroVehiculo();
            mostrarComprobante();
        }
        sc.close();
    }
    }
