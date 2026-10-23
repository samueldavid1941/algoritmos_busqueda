import java.util.Arrays;
import java.util.Scanner;

/** Menú principal para probar los cinco ejercicios. */
public class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Ejercicios de algoritmos de búsqueda ===");
            System.out.println("1. Búsqueda lineal: primer ticket crítico");
            System.out.println("2. Búsqueda binaria: lowerBound de un precio");
            System.out.println("3. Búsqueda por saltos: código en índice ordenado");
            System.out.println("4. Búsqueda por interpolación: IDs uniformes");
            System.out.println("5. Búsqueda exponencial: evento en lista creciente");
            System.out.println("6. Ejecutar casos de prueba");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int option = readInt();
            switch (option) {
                case 1 -> demoLinear();
                case 2 -> demoLowerBound();
                case 3 -> demoJump();
                case 4 -> demoInterpolation();
                case 5 -> demoExponential();
                case 6 -> Pruebas.ejecutar();
                case 0 -> { System.out.println("¡Hasta luego!"); return; }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void demoLinear() {
        boolean[] tickets = {false, false, true, true};
        System.out.println("Cola: " + Arrays.toString(tickets));
        System.out.println("Primer ticket crítico: posición " + BusquedaLineal.primerCritico(tickets));
    }
    private static void demoLowerBound() {
        int[] prices = {10, 20, 20, 20, 35, 50};
        int index = BusquedaBinaria.lowerBound(prices, 20);
        System.out.println("Precios: " + Arrays.toString(prices));
        System.out.println("Insertar 20 en índice " + index + " (antes del primer duplicado).");
    }
    private static void demoJump() {
        int[] codes = {3, 8, 12, 17, 21, 29, 34, 41, 55};
        BusquedaPorSaltos.Resultado result = BusquedaPorSaltos.buscar(codes, 29);
        System.out.println("Códigos: " + Arrays.toString(codes));
        System.out.println("Resultado para 29: " + result);
    }
    private static void demoInterpolation() {
        int[] ids = {100, 110, 120, 120, 120, 150, 160, 170};
        System.out.println("IDs: " + Arrays.toString(ids));
        System.out.println("Primera lectura 120: índice " + BusquedaInterpolacion.buscar(ids, 120));
    }
    private static void demoExponential() {
        int[] events = {2, 5, 9, 14, 22, 31, 47, 60, 88, 103, 150};
        System.out.println("Eventos: " + Arrays.toString(events));
        System.out.println("Evento 88: índice " + BusquedaExponencial.buscar(events, 88));
    }
    private static int readInt() {
        while (INPUT.hasNext() && !INPUT.hasNextInt()) { INPUT.next(); System.out.print("Escribe un número: "); }
        if (!INPUT.hasNext()) return 0;
        return INPUT.nextInt();
    }
}
