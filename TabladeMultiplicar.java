import java.util.Scanner;

public class TabladeMultiplicar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;

        // ---------------------------------
        // 1. PEDIR Y VALIDAR EL NÚMERO
        // ---------------------------------
        
        do {
            System.out.print("Ingresa un número entero positivo: ");

            if (!sc.hasNextInt()) {
                System.out.println("Error: Debes ingresar un número entero.");
                sc.nextLine();
                continue;
            }

            numero = sc.nextInt();
            sc.nextLine();

            if (numero <= 0) {
                System.out.println("Error: el número debe ser mayor que 0.");
                continue;
            }

            valido = true;

        } while (!valido);

        // ---------------------------------
        // 2. CREAR MATRIZ 1 x 10
        // ---------------------------------
        int[][] tabla = new int[1][10];

        for (int i = 0; i < 10; i++) {
            tabla[0][i] = numero * (i + 1);
        }

        // ---------------------------------
        // 3. IMPRIMIR TABLA DE MULTIPLICAR
        // ---------------------------------
        System.out.println("\n=== TABLA DEL " + numero + " ===");

        for (int i = 0; i < 10; i++) {
            System.out.println(numero + " x " + (i + 1) + " = " + tabla[0][i]);
        }

        sc.close();
    }
}
