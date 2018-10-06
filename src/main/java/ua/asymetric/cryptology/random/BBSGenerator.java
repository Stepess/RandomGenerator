package ua.asymetric.cryptology.random;

import java.math.BigInteger;

public class BBSGenerator extends RandomGenerator {
    private static final String GENERATOR_NAME = "BBS";
    private static final BigInteger P = new BigInteger("D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
    private static final BigInteger Q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
    private BigInteger n;
    private BigInteger seed;

    public BBSGenerator() {
        n = P.multiply(Q);
        updateState();
    }

    @Override
    public void updateState() {
        seed = BigInteger.valueOf(System.nanoTime() + 2);
    }

    @Override
    public int generate() {
        seed = seed.modPow(BigInteger.valueOf(2), n);
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