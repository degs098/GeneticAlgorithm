package co.com.poli;

import java.util.Date;
import java.util.Random;

public class Main {

    private static final Random random = new Random();
    private static final String target = "Politécnico Colombiano Jaime Isaza Cadavid";

    public static void main(String[] args) {
        random.setSeed(12345);
        Date startTime = new Date();
        String best_parent = GuessString.generateParent(target.length());
        int best_fitness = GuessString.getFitness(best_parent);
        GuessString.display(best_parent, startTime);

        while (true) {
            String child = GuessString.mutate(best_parent);
            int child_fitness = GuessString.getFitness(child);
            if (best_fitness >= child_fitness) {
                GuessString.display(child, startTime);
            }

            if (child_fitness >= best_parent.length()){
                GuessString.display(child, startTime);
                break;
            }

            best_fitness = child_fitness;
            best_parent = child;
        }
    }


}
