package ua.asymetric.cryptology.random;

import java.math.BigInteger;

public abstract class BBSGenerator extends RandomGenerator{

    private static final BigInteger P = new BigInteger("D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
    private static final BigInteger Q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
    protected static final BigInteger N = P.multiply(Q);


    public BBSGenerator() {
        updateState();
    }

    public abstract void updateState();


}
