package ua.asymetric.cryptology.random;

public class WolframGenerator implements RandomGenerator {
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
        return (byte) generate();
    }

    private int circularLeftShift(int value, int step) {
        return (value << step) | (value >>> (Integer.SIZE - step));
    }

    private int circularRightShift(int value, int step) {
        return (value >>> step) | (value << (Integer.SIZE - step));
    }
}
