package ua.asymetric.cryptology.random;

import java.util.Random;

public class EmbeddedRandomGenerator implements RandomGenerator {
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
