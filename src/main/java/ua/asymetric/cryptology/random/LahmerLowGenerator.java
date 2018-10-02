package ua.asymetric.cryptology.random;

public class LahmerLowGenerator extends LahmerGenerator implements RandomGenerator {
    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }

    private static final String GENERATOR_NAME = "LahmerLow";
    @Override
    public int generate() {
        return (int) super.generateIntermediateValue() & 0xFF;
    }

    @Override
    public byte generateRandomByte() {
        return (byte) generate();
    }
}
