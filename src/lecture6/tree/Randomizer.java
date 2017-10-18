package lecture6.tree;

import java.util.Random;

public class Randomizer {
    private Random random = new Random();
    private int bound;
    private static final int DEFAULT_BOUND = 3;

    public Randomizer() {
        this.bound = DEFAULT_BOUND;
    }

    public Randomizer(int bound) {
        this.bound = bound;
    }

    /**
     * randomizes a vaues from 1 to the bound set in constructor
     * @return
     */
    public int newRandomInt() {
        return random.nextInt(this.bound) + 1;
    }
}
