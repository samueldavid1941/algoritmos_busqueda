/** Búsqueda por interpolación para IDs ordenados y aproximadamente uniformes. */
public class BusquedaInterpolacion {
    /** Devuelve la primera coincidencia. Promedio O(log log n), peor caso O(n). */
    public static int buscar(int[] valores, int objetivo) {
        int bajo = 0, alto = valores.length - 1, encontrado = -1;
        while (bajo <= alto && objetivo >= valores[bajo] && objetivo <= valores[alto]) {
            if (valores[bajo] == valores[alto]) {
                if (valores[bajo] == objetivo) encontrado = bajo;
                break;
            }
            long numerador = (long) (objetivo - (long) valores[bajo]) * (alto - bajo);
            int posicion = bajo + (int) (numerador / ((long) valores[alto] - valores[bajo]));
            if (valores[posicion] == objetivo) {
                encontrado = posicion;
                alto = posicion - 1;
            } else if (valores[posicion] < objetivo) bajo = posicion + 1;
            else alto = posicion - 1;
        }
        return encontrado;
    }
}
