import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;


public class TextoInteligente {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=============== MENÚ ===============");
            System.out.println("1. Validar números telefónicos");
            System.out.println("2. Formatear y estandarizar correos electrónicos");
            System.out.println("3. Extraer fechas de un texto");
            System.out.println("4. Salir ");
            System.out.println("======================================");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    boolean valido;
                    System.out.println("\n==== VALIDAR NÚMEROS TELEFÓNICOS ==== ");
                    do {
                        System.out.print("Ingresa un número telefónico con formato (XXX) XXX-XXXX.\n");
                        System.out.println("Ejemplo: (123) 456-7890");
                        System.out.print(">> ");
                        String telefono = sc.nextLine().trim();
                        valido = validarTelefono(telefono);

                        if (valido) {
                            System.out.println("El número ingresado se ha validado correctamente. ");
                            System.out.println("Estandarizado: " + telefono);
                            System.out.println("Formato: Válido");
                        } else {
                            System.out.println("Número inválido. Intente de nuevo.");
                            System.out.println("Estandarizado: (XXX) XXX-XXXX");
                        }
                    } while (!valido);

                    break;
                case 2:
                    System.out.println("\n==== CORREOS ELECTRÓNICOS ==== ");
                    System.out.println("Ingresa los correos deseados separados por comas (,) ");
                    System.out.println("Ejemplo:  correo1@gmail.com, correo2@gmail.com,  correo3@gmail.com");
                    System.out.print(">> ");
                    String serie = sc.nextLine();

                    String[] correos = serie.split(",");

                    procesarCorreos(correos);

                    System.out.println("\n==== CORREOS ESTANDARIZADOS Y SU VALIDEZ ====");

                    for (int i = 0; i < correos.length; i++) {
                        String estado = "Válido";

                        if (!correoValidez(correos[i]))
                            estado = "Inválido";

                        System.out.println("\n[ CORREO " + (i + 1) + " ]");
                        System.out.println("Estandarizado: " + correos[i]);
                        System.out.println("Formato: " + estado);
                    }
                    break;
                case 3:
                    System.out.println("\n==== EXTRAER FECHAS DE UN TEXTO ==== ");
                    System.out.println("Ingresa un texto que contenga fechas en formato DD/MM/AAAA: ");
                    System.out.println("Ejemplo: Hoy es 25/11/2025");
                    System.out.print(">> ");
                    String texto = sc.nextLine();
                    List<String> fechas = extraerFechas(texto);

                        if (fechas.isEmpty()) {
                            System.out.println("No se encontró ninguna fecha en el texto.");
                        } else {
                            System.out.println("Se encontraron " + fechas.size() + " fecha(s):");
                            for (String fecha : fechas) {
                                System.out.println(fecha); 
                            }
                        }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }

    //TODO: Función que valida el número de teléfono
    public static boolean validarTelefono(String telefono) {
        if (telefono.isEmpty())
            return false;

        String patron = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";

        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(telefono);

        return m.matches();
    }

    // TODO: Formatear y estandarizar correos electrónicos

    static final Pattern formatoMail = Pattern
            .compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");

    public static void procesarCorreos(String[] listaCorreos) {
        for (int i = 0; i < listaCorreos.length; i++) {
            String correo = listaCorreos[i].trim().toLowerCase();
            listaCorreos[i] = correo;
        }
    }

    public static boolean correoValidez(String correo) {
        Matcher valido = formatoMail.matcher(correo);
        return valido.matches();
    }

    // TODO: Extraer fechas de un texto
       public static List<String> extraerFechas(String texto) {
        
        if (texto.isEmpty())
            return new ArrayList<>();

        List<String> lista = new ArrayList<>();
    
        Pattern patron = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher buscador = patron.matcher(texto);

        while (buscador.find()) {
            lista.add(buscador.group());
        }

        return lista;
    }
}
