package ua.asymetric.cryptology.random;

public class WolframGenerator extends RandomGenerator {
    private static final String GENERATOR_NAME = "Wolfram";
    private int seed;

    public WolframGenerator() {
        updateState();
    }

    @Override
    public void updateState() {
        seed = (int) System.nanoTime();
    }

    @Override
    public int generate() {
        int result = seed & 1;
        seed = circularLeftShift(seed, 1) ^ (seed | circularRightShift(seed, 1));
        return result;
    }

    @Override
    public byte generateRandomByte() {
        byte result = 0;
        for (int i = 0; i < Byte.SIZE - 1; i++) {
            result |= generate();
            result <<= 1;
        }
        result |= generate();
        return result;
    }

    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }

    private static int circularLeftShift(int value, int step) {
        return (value << step) | (value >>> (Integer.SIZE - step));
    }

    private static int circularRightShift(int value, int step) {
        return (value >>> step) | (value << (Integer.SIZE - step));
    }
}
