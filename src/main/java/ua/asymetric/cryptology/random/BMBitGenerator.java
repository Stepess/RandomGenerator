package ua.asymetric.cryptology.random;

import java.math.BigInteger;
import java.util.Random;

public class BMBitGenerator extends BMGenerator {
    private static final String GENERATOR_NAME = "BMBit";
    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }

    private BigInteger seed;

    public BMBitGenerator() {
        updateState();
    }

    public BMBitGenerator(BigInteger seed) {
        this.seed = seed;
    }

    @Override
    public void updateState() {
        seed = new BigInteger(P.bitLength(), new Random());
    }

    @Override
    public int generate() {
        seed = seed.modPow(A, P);
        if (seed.compareTo(Threashold) == -1) {
            return 1;
        } else {
            return 0;
        }
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
}
