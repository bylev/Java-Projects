import java.util.*;


public class email {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String correo;
        boolean valido = false;

        do {
            System.out.print("Ingresa un correo: ");
            correo = sc.nextLine().trim();  // elimina espacios al inicio y final

            // Reiniciar bandera de validación
            valido = true;

            // 1. Validar que no esté vacío
            if (correo.isEmpty()) {
                System.out.println("Correo inválido: no puede estar vacío.");
                valido = false;
            }

            // 2. Validar que contenga exactamente un '@'
            int posArroba = correo.indexOf('@');
            int posArrobaFinal = correo.lastIndexOf('@');

            // Valida si falta @ o si hay más de uno
            for(int i = 0; i < correo.length(); i++) {
                if(correo.charAt(i) == '@') {
                    posArroba = i;
                    break;
                }
            }

            // Validar que antes del @ haya al menos 1 caracter
            if (posArroba == -1 || posArroba != posArrobaFinal) {
                System.out.println("Correo inválido: debe contener exactamente un '@'.");
                valido = false;
            }
            // 4. Validar que después del @ exista al menos un "."

            int posPunto = correo.indexOf('.', posArroba);
            if (posPunto == -1) {
                System.out.println("Correo inválido: debe contener al menos un '.' después del '@'.");
                valido = false;
            }

            // 5. Validar que el dominio tenga al menos 2 letras
            int posUltimoPunto = correo.lastIndexOf('.');
            String dominio = correo.substring(posUltimoPunto + 1);
            if (dominio.length() < 2) {
                System.out.println("Correo inválido: el dominio debe tener al menos 2 letras.");
                valido = false;
            }
            

            boolean tieneEspacios = false;
            for (int i = 0; i < correo.length(); i++) {
                if (correo.charAt(i) == ' ') {
                    tieneEspacios = true;
                    break;
                }
            }

            if (tieneEspacios) {
                System.out.println("Correo inválido: no debe contener espacios.");
                valido = false;
            }

            if (!valido) {
                System.out.println("Intenta de nuevo.\n");
            }

        } while (!valido);

        System.out.println("\nCorreo válido.");
        sc.close();
    }
    
}
