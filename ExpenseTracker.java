import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.regex.Pattern;

public class ExpenseTracker{
    static final String archivo = "gastos.csv";
    //Conjunto<String> categorias = new Conjunto<>();
    List<String> Categorias = Arrays.asList("Comida", "Transporte", "Vivienda", "Salud", "Educacion", "Entretenimiento");

    //TIPO: Gasto
    static class Gasto{
        String fecha;
        String categoria;
        String descripcion;
        double monto;
        
        Gasto(String fecha, String categoria, String descripcion, double monto) {
            this.fecha = fecha;
            this.categoria = categoria;
            this.descripcion = descripcion;
            this.monto = monto;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String listaGastos = cargarDesdeCSV(archivo);

        while(true){
            mostrarMenu();
            System.out.println("Elige una opcion: ");
            int opcion = sc.nextInt();

            switch(opcion){
                case 1: 
                    agregarGasto(listaGastos);
                    break;
                case 2: 
                    listarGastos(listaGastos);
                    break;
                case 3:
                    filtrarPorMesYCategoria(listaGastos);
                    break; 
                case 4: 
                    mostrarReportes(listaGastos);
                    break;
                case 5: 
                    guardarenCSV(listaGastos, archivo);
                    System.out.println("Guardado.");
                    break;
                case 6: 
                    guardarenCSV(listaGastos, archivo);
                    System.out.println("Adiós!");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }

        }
    }

    static void mostrarMenu(){
        System.out.println("==== EXPENSE TRACKER =====");
        System.out.println("1) Agregar gastos");
        System.out.println("2) Listar gastos");
        System.out.println("3) Filtrar (por mes y categoría)");;
        System.out.println("4) Reportes");
        System.out.println("5) Guardar");
        System.out.println("6) Salir");
    }

    static void agregarGasto(List<Gasto> listaGastos) {
    String fecha = leerFechaISO("Fecha (YYYY-MM-DD): ");
    String categoria = leerCategoria("Categoría: ");
    String descripcion = leerCadenaNoVacia("Descripción: ");
    double monto = leerRealPositivo("Monto (>0): ");

    Gasto gasto = new Gasto(fecha, categoria, descripcion, monto);
    listaGastos.add(gasto);
    System.out.println("Gasto agregado.");
}

}