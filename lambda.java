package Creacion_func;
import java.util.function.*;

public class lambda {
    public static void main(String[] args) {
        double celsius;
        int fahrenheit;

        System.out.println("Fahrenheit      Celsius");
        System.out.println("------------------------------");
        
        try{
        Function<Integer, Double> toCelsius = (f) -> ((f - 32) * 5.0) / 9.0; // Función lambda para convertir Fahrenheit a Celsius
        for (fahrenheit = 50; fahrenheit <= 400; fahrenheit += 50) { // Bucle para recorrer los valores de Fahrenheit
            celsius = toCelsius.apply(fahrenheit); // Aplicar la función lambda
            System.out.println(fahrenheit + "               " + celsius); // Imprimir el resultado
        }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally{
            System.out.println("Conversión completada.");
        }
    }
}