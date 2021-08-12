package co.com.poli;

import java.util.Date;
import java.util.Random;

public class GuessString {

    private static final String geneSet = " aábcdeéfghiíjklmnoópqrstuúvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!.,";
    private static final String target = "Politécnico Colombiano Jaime Isaza Cadavid";
    private static final Random random = new Random();

    /**
     * Necesitamos una forma de generar una cadena aleatoria (un invitado) a partir del conjunto de genes.
     * @param length El número de caracteres aleatorios que se generarán a partir de un conjunto de genes.
     */
    static String generateParent(int length) {
        StringBuilder genes = new StringBuilder();

        for (int i = 0; i < length; i++) {
            genes.append(geneSet.charAt(random.nextInt(geneSet.length())));
        }

        return genes.toString();
    }

    /**
     * Necesitamos definir un fitness
     * @param guess La aptitud es la única respuesta que recibe el motor para guiarlo hacia una solución.
     * @return contador La aptitud (fitness) es el número total en la conjetura que coincide con la letra
     *  en la misma posición de la contraseña.
     */
    static int getFitness(String guess){
        char[] guess_array = guess.toCharArray();
        char[] target_array = target.toCharArray();

        int contador = 0;

        for(int i = 0; i < target_array.length; i++) {
            if (guess_array[i] == target_array[i]) {
                contador++;
            }
        }

        return contador;

    }

    /**
     *
     * Necesitamos una nueva forma de producir una nueva suposición que mute la actual. Conecta la cadena principal a una matriz
     * y reemplaza 1 letra en la matriz con una seleccionada al azar del geneSet.
     * @param parent cadena principal para mutar
     * @return guess_array cadena mutada
     */
    static String mutate(String parent){
        char[] guess_array = parent.toCharArray();
        char[] target_array = target.toCharArray();

        for(int i = 0; i < target_array.length; i++) {
            if (guess_array[i] != target_array[i]) {
                char gene = geneSet.charAt(random.nextInt(geneSet.length()));
                // ¿Es el nuevo gen el mismo que estaba en esa posición?
                // Reemplazar el gen seleccionado si es el mismo que se supone que debe reemplazar,
                // lo que puede evitar un número significativo de suposiciones desperdiciadas.
                while (gene != guess_array[i]){
                    guess_array[i] = gene;
                }
            }
        }

        return String.valueOf(guess_array);

    }

    /**
     * Función encargada de mostrar las iteraciones y las cadenas resultantes.
     * @param guess cadena mutada de la iteración actual
     * @param startTime tiempo de ejecución de la mutación
     */
    static void display(String guess, Date startTime) {
        Date time = new Date();
        System.out.println("Guess: " + guess+ ", Fitness: " + getFitness(guess) + ", Time: " + (time.getTime() - startTime.getTime()) + " milisegundos" );
    }
}
