package ua.asymetric.cryptology.random;

import java.util.Random;

public class EmbeddedRandomGenerator extends RandomGenerator {
    private static final String GENERATOR_NAME = "Java";
    private Random random;
    private long seed;

    public EmbeddedRandomGenerator() {
        seed = System.nanoTime();
        this.random = new Random(seed);
    }

    @Override
    public void updateState() {
    }

    @Override
    public int generate() {
        return random.nextInt();
    }

    @Override
    public byte generateRandomByte() {
        return (byte) generate();
    }

    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }

    @Override
    public Object getSeed() {
        return Long.valueOf(seed);
    }
}
