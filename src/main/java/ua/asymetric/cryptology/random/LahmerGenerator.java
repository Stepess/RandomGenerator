package ua.asymetric.cryptology.random;

public abstract class LahmerGenerator implements RandomGenerator {
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

    protected long generateIntermediateValue(){
        long previous = seed;
        long current = 0;
        for (int i = 0; i < 32; i++) {
            current = (a * previous + c) % m;
            previous = current;
        }
        seed = current;
        return current;
    }

    public long getSeed() {
        return seed;
    }
}
