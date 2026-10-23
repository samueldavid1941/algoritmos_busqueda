/** Búsqueda exponencial en una lista ordenada que puede crecer durante la carga. */
public class BusquedaExponencial {
    /** Encuentra una cota exponencial y hace búsqueda binaria. O(log p). */
    public static int buscar(int[] valores, int objetivo) {
        int n = valores.length;
        if (n == 0) return -1;
        if (valores[0] == objetivo) return 0;
        int cota = 1;
        while (cota < n && valores[cota] < objetivo) {
            cota = cota > n / 2 ? n : cota * 2;
        }
        return busquedaBinaria(valores, objetivo, cota / 2, Math.min(cota, n - 1));
    }

    private static int busquedaBinaria(int[] valores, int objetivo, int izquierda, int derecha) {
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (valores[medio] == objetivo) {
                while (medio > 0 && valores[medio - 1] == objetivo) medio--;
                return medio;
            }
            if (valores[medio] < objetivo) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return -1;
    }
}
