package ua.asymetric.cryptology.random;

import ua.asymetric.cryptology.LSR;

public class L20Generator extends LGenerator {
    private static final String GENERATOR_NAME = "L20";
    private final static int PERIOD = 20;
    private final static int[] RECURRENCE = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0};

    public L20Generator() {
        super(new LSR(PERIOD, RECURRENCE));
        super.updateState();
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
