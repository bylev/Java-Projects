import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExploradorPalabras {

    private static final String ARCHIVO_ENTRADA = "palabras.txt";
    private static final String ARCHIVO_SALIDA  = "reporte_palabras.txt";

    public static void main(String[] args) {

        int totalLineas = 0;
        int totalPalabras = 0;
        String palabraMasLarga = "";
        String palabraMasCorta = null;
        int ocurrencias = 0;

        Scanner sc = new Scanner(System.in);

        try {
            // 1. Primera pasada: leer el archivo palabras.txt
            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ENTRADA));
            String linea;

            while ((linea = br.readLine()) != null ) {

                linea = linea.trim();

                if (linea.isEmpty()) {
                    continue;
                }

                // Contar líneas
                totalLineas++;

                // Separar palabras
                String[] palabras = linea.split("\\s+");
                

                for(String p: palabras){
                    if(p.isEmpty()) continue;
                


                // TOTAL DE PALABRAS
                totalPalabras++;

                if(palabraMasLarga.length() < p.length()){
                    palabraMasLarga = p;
                }
                
                // PALABRA MÁS CORTA
                if(palabraMasCorta == null || p.length() < palabraMasCorta.length()){
                    palabraMasCorta = p;
                }
            }

            
            }

            br.close();

            // 2. Solicitar palabra a buscar
            System.out.print("Ingresa la palabra a buscar: ");
            String buscada = sc.nextLine();

            // 3. Segunda pasada: contar ocurrencias
            BufferedReader br2 = new BufferedReader(new FileReader(ARCHIVO_ENTRADA));
            String linea2;

            while ((linea2 = br2.readLine()) != null ) {

                linea2 = linea2.trim();

                if (!linea2.isEmpty()) continue;

                String[] palabras2 = linea2.split("\\s+");

                for(String p: palabras2){
                    if(p.equalsIgnoreCase(buscada)){
                        ocurrencias++;
                    }
                }
            }

            br2.close();

            // 4. Crear archivo de salida
            PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_SALIDA));

            pw.println("Reporte de análisis de palabras");
            pw.println("------------------------------");
            pw.println("Total de líneas: " + totalLineas);
            pw.println("Total de palabras: " + totalPalabras );
            pw.println("Palabra más larga: " + palabraMasLarga);
            pw.println("Palabra más corta: " +palabraMasCorta);
            pw.println("Palabra buscada: " + buscada);
            pw.println("Ocurrencias encontradas: " + ocurrencias);

            pw.close();

            System.out.println("Reporte generado: " + ARCHIVO_SALIDA);

        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
