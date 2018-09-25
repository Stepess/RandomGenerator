package ua.asymetric.cryptology.random;

import java.math.BigInteger;
import java.util.Random;

public class BMGenerator implements RandomGenerator {


    private static final String P_VALUE = "CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3";
    private static final BigInteger P =
            new BigInteger(P_VALUE, 16);
    private static final BigInteger A =
            new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
    private static final BigInteger Q =
            new BigInteger("675215CC3E227D3216C056CFA8F8822BB486F788641E85E0DE77097E1DB049F1", 16);
    private BigInteger Threashold;
    private BigInteger seed;

    public BMGenerator() {
        Threashold = new BigInteger(P_VALUE, 16);
        Threashold = Threashold.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2));
        updateState();
    }

    public BMGenerator(BigInteger seed) {
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
