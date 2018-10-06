package ua.asymetric.cryptology.random;

import java.math.BigInteger;
import java.util.Random;

public class BMByteGenerator extends BMGenerator {
    private static final String GENERATOR_NAME = "BMByte";
    private static final BigInteger Z = P.subtract(BigInteger.valueOf(1)).divide(BigInteger.valueOf(256));
    private BigInteger seed;

    public BMByteGenerator() {
        updateState();
    }

    public BMByteGenerator(BigInteger seed) {
        this.seed = seed;
    }

    @Override
    public void updateState() {
        seed = new BigInteger(P.bitLength(), new Random());
    }

    @Override
    public int generate() {
        seed = seed.modPow(A, P);
        return 0;
    }

    @Override
    public byte generateRandomByte() {
        generate();
        int j=0;
        for (; j< 256; j++) {
            if (Z.multiply(BigInteger.valueOf(j)).compareTo(seed) == -1 && Z.multiply(BigInteger.valueOf(j+1)).compareTo(seed) == 1){
                break;
            }
        }
        return (byte) j;
    }

    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }
}
