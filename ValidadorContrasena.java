import java.util.Scanner;

public class ValidadorContrasena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String contrasena;
        boolean valido;

        do {
            System.out.print("Ingresa una contraseña: ");
            contrasena = sc.nextLine();

            valido = true; // se asume válida hasta comprobar lo contrario

            // ----------------------------
            // 1. Validar longitud >= 8
            // ----------------------------
            if (contrasena.length() < 8) {
                System.out.println("Error: La contraseña debe ser mínimo de 8 caracteres.");
                valido = false;
            }

            // ----------------------------
            // 2. Validar al menos una mayúscula
            // ----------------------------
            boolean tieneMayus = false;
            for (int i = 0; i < contrasena.length(); i++) {
                char c = contrasena.charAt(i);
                if (Character.isUpperCase(c)) {
                    tieneMayus = true;
                    break;
                }
            }
            if (!tieneMayus) {
                System.out.println("Error: Debe contener al menos una letra mayúscula.");
                valido = false;
            }

            // ----------------------------
            // 3. Validar al menos una minúscula
            // ----------------------------
            boolean tieneMinus = false;
            for (int i = 0; i < contrasena.length(); i++) {
                char c = contrasena.charAt(i);
                if (Character.isLowerCase(c)) {
                    tieneMinus = true;
                    break;
                }
            }
            if (!tieneMinus) {
                System.out.println("Error: Debe contener al menos una letra minúscula.");
                valido = false;
            }

            // ----------------------------
            // 4. Validar al menos un dígito
            // ----------------------------
            boolean tieneDigito = false;
            for (int i = 0; i < contrasena.length(); i++) {
                char c = contrasena.charAt(i);
                if (Character.isDigit(c)) {
                    tieneDigito = true;
                    break;
                }
            }

            if (!tieneDigito) {
                System.out.println("Error: Debe contener al menos un dígito.");
                valido = false;
            }

            // ----------------------------
            // 5. Validar que NO existan espacios
            // ----------------------------
            boolean tieneEspacio = false;
            for (int i = 0; i < contrasena.length(); i++) {
                char c = contrasena.charAt(i);
                if (Character.isWhitespace(c)) {
                    tieneEspacio = true;
                    break;
                }
            }

            if (tieneEspacio) {
                System.out.println("Error: La contraseña no debe contener espacios.");
                valido = false;
            }

            // Mensaje final si no es válida
            if (!valido) {
                System.out.println("La contraseña no cumple los requisitos. Intenta de nuevo.\n");
            }

        } while (!valido);

        System.out.println("Contraseña válida.");
        sc.close();
    }
}
