/** Búsqueda binaria para insertar precios y mantener el orden. */
public class BusquedaBinaria {
    /** Primera posición cuyo valor es mayor o igual al objetivo. O(log n). */
    public static int lowerBound(int[] precios, int objetivo) {
        int izquierda = 0, derecha = precios.length;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (precios[medio] < objetivo) izquierda = medio + 1;
            else derecha = medio;
        }
        return izquierda;
    }
}
