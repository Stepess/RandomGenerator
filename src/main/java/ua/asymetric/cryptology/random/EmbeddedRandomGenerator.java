package ua.asymetric.cryptology.random;

import java.util.Random;

public class EmbeddedRandomGenerator extends RandomGenerator {
    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }

    private static final String GENERATOR_NAME = "Java";
    private Random random;

    public EmbeddedRandomGenerator() {
        this.random = new Random();
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
}
