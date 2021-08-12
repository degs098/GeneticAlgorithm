# GeneticAlgorithm													

### INTEGRANTES

Daniel Esteban Gallego Sierra - 1214741637
Jeison Velásquez Sepúlveda - 1152708003


### POBLACIÓN/GENES

El algoritmo genético necesita un conjunto de genes para usarlo y  construir una propuesta inicial. Para esta muestra será un conjunto genérico de letras. 

### **FITNESS**

El valor de la aptitud o fitness que el algoritmo genético proporciona es la única retroalimentación que el motor obtiene para guiarla hacia una solución. En este ejemplo el valor de la aptitud es el número total de letras en la propuesta que puede emparejar la letra en la misma posición de la cadena de texto objetivo.

### MUTATE

Luego, el motor necesita una forma de producir una nueva conjetura mediante la mutación de la actual. La siguiente implementación convierte la cadena padre en una matriz, luego reemplaza 1 letra en la matriz con una seleccionada aleatoriamente de geneSet, y finalmente recombina el resultado en una nueva cadena.

### CRUCE

El cruce en un algoritmo genético es una operación que se realiza con el fin de tener nuevas soluciones que utilicen la información de soluciones anteriores y explotar la información ya generada en el proceso de optimización. En nuestro caso, sería el ciclo que está en el método Main, ya que compara la aptitud de modo que la mejor propuesta se mantiene. Este ciclo se repite hasta que se produce una condición de stop, en este caso cuando todas las letras de la propuesta coinciden con el objetivo.

### PROBABILIDADES

La probabilidad de mutación radica en la operación que tiene como objetivo generar nueva información dentro de la población para obtener cada vez un mejor resultado.
