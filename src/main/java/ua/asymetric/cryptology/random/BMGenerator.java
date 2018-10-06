package ua.asymetric.cryptology.random;

import java.math.BigInteger;

public abstract class BMGenerator extends RandomGenerator {
    private static final String P_VALUE = "CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3";
    protected static final BigInteger P =
            new BigInteger(P_VALUE, 16);
    protected static final BigInteger A =
            new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
    protected static final BigInteger Q =
            new BigInteger("675215CC3E227D3216C056CFA8F8822BB486F788641E85E0DE77097E1DB049F1", 16);
    protected static final BigInteger Threashold = new BigInteger(P_VALUE, 16).subtract(BigInteger.ONE).divide(BigInteger.valueOf(2));

}
