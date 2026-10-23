# Ejercicios de búsqueda en Java

Proyecto sencillo de consola, sin dependencias externas. Requiere Java 14 o superior.

## Ejecutar

Desde la carpeta `EjerciciodeAlgoritmos`:

```text
javac src/*.java
java -cp src Main
```

El menú permite ver una demostración de cada ejercicio o ejecutar los casos límite con la opción 6. Cada algoritmo está separado en su propia clase dentro de `src`: `BusquedaLineal`, `BusquedaBinaria`, `BusquedaPorSaltos`, `BusquedaInterpolacion` y `BusquedaExponencial`. `Main` muestra el menú y `Pruebas` ejecuta los ejemplos límite.

## Decisiones y complejidad

| Ejercicio | Estructura/idea | Complejidad | Justificación |
|---|---|---|---|
| Primer ticket crítico | Recorrido lineal | O(n) tiempo, O(1) espacio | Se conserva el orden original y se detiene en el primer ticket crítico. No hace falta copiar ni reordenar la cola. |
| `lowerBound` de precios | Búsqueda binaria | O(log n) tiempo, O(1) espacio | En una lista ordenada descarta la mitad en cada paso. Devuelve la primera posición con valor mayor o igual, incluso si hay duplicados; el final de la lista es una posición válida para insertar. |
| Código por bloques | Búsqueda por saltos | O(√n) tiempo, O(1) espacio | Salta bloques de tamaño aproximado √n y revisa linealmente el bloque candidato. Cuenta cada comparación entre un código y el objetivo. |
| Lectura en IDs uniformes | Búsqueda por interpolación | O(log log n) promedio con distribución uniforme; O(n) peor caso | Estima la posición según el valor y ajusta los límites. Al encontrar el ID sigue buscando a la izquierda para devolver la primera repetición. |
| Evento en lista creciente | Búsqueda exponencial | O(log p), donde p es la posición del evento; O(log n) como cota | Duplica el límite mientras carga la lista y el objetivo siga más adelante; después aplica búsqueda binaria dentro del rango encontrado. |

Las búsquedas sobre listas ordenadas presuponen que los datos realmente están ordenados. Interpolación además funciona mejor cuando los valores están distribuidos de forma aproximadamente uniforme.

## Casos límite incluidos

Se prueban listas vacías, objetivo ausente, extremos, ausencia de tickets críticos, valores repetidos y un arreglo constante para interpolación. El proyecto no modifica los arreglos de entrada.
