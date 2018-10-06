package ua.asymetric.cryptology.random;

import java.math.BigInteger;

public class BBSBitGenerator extends BBSGenerator {
    private static final String GENERATOR_NAME = "BBSBit";
    private BigInteger seed;

    @Override
    public void updateState() {
        seed = BigInteger.valueOf(System.nanoTime() + 2);
    }

    @Override
    public int generate() {
        seed = seed.modPow(BigInteger.valueOf(2), N);
        return seed.mod(BigInteger.valueOf(2)).intValue();
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
}