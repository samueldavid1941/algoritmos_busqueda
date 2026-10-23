/** Búsqueda en una lista ordenada revisando bloques y contando comparaciones. */
public class BusquedaPorSaltos {
    public static class Resultado {
        public final int indice;
        public final int comparaciones;
        Resultado(int indice, int comparaciones) { this.indice = indice; this.comparaciones = comparaciones; }
        @Override public String toString() { return "índice=" + indice + ", comparaciones=" + comparaciones; }
    }

    /** Complejidad O(√n) tiempo y O(1) espacio. */
    public static Resultado buscar(int[] valores, int objetivo) {
        int n = valores.length, comparaciones = 0;
        if (n == 0) return new Resultado(-1, 0);
        int salto = Math.max(1, (int) Math.sqrt(n));
        int inicio = 0, fin = salto;
        while (inicio < n) {
            int ultimo = Math.min(fin, n) - 1;
            comparaciones++;
            if (valores[ultimo] >= objetivo) {
                for (int i = inicio; i <= ultimo; i++) {
                    comparaciones++;
                    if (valores[i] == objetivo) return new Resultado(i, comparaciones);
                    if (valores[i] > objetivo) return new Resultado(-1, comparaciones);
                }
                return new Resultado(-1, comparaciones);
            }
            inicio = fin;
            fin += salto;
        }
        return new Resultado(-1, comparaciones);
    }
}
