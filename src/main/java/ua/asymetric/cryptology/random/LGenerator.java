package ua.asymetric.cryptology.random;

import ua.asymetric.cryptology.LSR;

public abstract class LGenerator extends RandomGenerator {
    private static final String GENERATOR_NAME = "L";
    private LSR lsr;
    private long seed;

    LGenerator(LSR lsr) {
        this.lsr = lsr;
    }

    @Override
    public void updateState() {
        seed = System.nanoTime();
        lsr.setCondition(seed);
    }

    @Override
    public Object getSeed() {
        return Long.valueOf(seed);
    }

    @Override
    public int generate() {
        return lsr.tact();
    }
}
