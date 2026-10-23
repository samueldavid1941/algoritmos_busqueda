/** Casos de prueba básicos para cada algoritmo. */
public class Pruebas {
    public static void ejecutar() {
        verificar("lineal primer crítico", BusquedaLineal.primerCritico(new boolean[]{false, true, true}) == 1);
        verificar("lineal ninguno", BusquedaLineal.primerCritico(new boolean[]{false, false}) == -1);
        verificar("lineal vacío", BusquedaLineal.primerCritico(new boolean[]{}) == -1);
        verificar("lowerBound duplicados", BusquedaBinaria.lowerBound(new int[]{1, 2, 2, 2, 4}, 2) == 1);
        verificar("lowerBound insertar al final", BusquedaBinaria.lowerBound(new int[]{1, 3}, 8) == 2);
        verificar("lowerBound vacío", BusquedaBinaria.lowerBound(new int[]{}, 4) == 0);
        verificar("saltos encontrado", BusquedaPorSaltos.buscar(new int[]{1, 3, 5, 7, 9}, 7).indice == 3);
        verificar("saltos ausente", BusquedaPorSaltos.buscar(new int[]{1, 3, 5, 7, 9}, 8).indice == -1);
        verificar("saltos vacío", BusquedaPorSaltos.buscar(new int[]{}, 1).indice == -1);
        verificar("interpolación duplicados", BusquedaInterpolacion.buscar(new int[]{10, 20, 20, 20, 30}, 20) == 1);
        verificar("interpolación constante", BusquedaInterpolacion.buscar(new int[]{5, 5, 5}, 5) == 0);
        verificar("interpolación fuera de rango", BusquedaInterpolacion.buscar(new int[]{10, 20, 30}, 40) == -1);
        verificar("exponencial encontrado", BusquedaExponencial.buscar(new int[]{2, 5, 9, 14, 22, 31}, 22) == 4);
        verificar("exponencial duplicados", BusquedaExponencial.buscar(new int[]{1, 2, 2, 2, 4}, 2) == 1);
        verificar("exponencial vacío", BusquedaExponencial.buscar(new int[]{}, 1) == -1);
    }

    private static void verificar(String nombre, boolean correcto) {
        System.out.println((correcto ? "[OK] " : "[FALLO] ") + nombre);
        if (!correcto) throw new AssertionError("Falló: " + nombre);
    }
}
