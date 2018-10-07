package ua.asymetric.cryptology.random;

import java.math.BigInteger;

public class BBSByteGenerator extends BBSGenerator {
    private static final String GENERATOR_NAME = "BBSByte";
    private BigInteger seed;

    @Override
    public void updateState() {
        seed = BigInteger.valueOf(System.nanoTime() + 2);
    }

    @Override
    public int generate() {
        seed = seed.modPow(BigInteger.valueOf(2), N);
        return seed.mod(BigInteger.valueOf(256)).intValue();
    }

    @Override
    public byte generateRandomByte() {
        return (byte) generate();
    }

    @Override
    public BigInteger getSeed() {
        return seed;
    }

    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }
}
