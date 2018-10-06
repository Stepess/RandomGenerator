package ua.asymetric.cryptology.random;

public abstract class LahmerGenerator extends RandomGenerator {
    private long m = 4294967296L; //2^32
    private long a = 65537L; //2^16 + 1
    private long c = 119L;
    private long seed;

    public LahmerGenerator() {
        updateState();
    }

    @Override
    public void updateState() {
        this.seed = System.nanoTime();
    }

    protected long generateIntermediateValue() {
        seed = (a * seed + c) % m;
        return seed;
    }

    public long getSeed() {
        return seed;
    }
}
