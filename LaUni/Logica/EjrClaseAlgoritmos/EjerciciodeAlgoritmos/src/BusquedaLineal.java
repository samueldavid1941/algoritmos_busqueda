/** Búsqueda del primer ticket crítico sin cambiar el orden de la cola. */
public class BusquedaLineal {
    /** Devuelve el índice del primer ticket crítico o -1 si no existe. O(n). */
    public static int primerCritico(boolean[] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i]) return i;
        }
        return -1;
    }
}
