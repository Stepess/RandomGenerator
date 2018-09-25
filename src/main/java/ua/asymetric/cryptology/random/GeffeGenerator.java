package ua.asymetric.cryptology.random;

import ua.asymetric.cryptology.LSR;

public class GeffeGenerator implements RandomGenerator {

    private LSR L11;
    private LSR L9;
    private LSR L10;

    private final static int PERIOD_L11 = 11;
    private final static int PERIOD_L9 = 9;
    private final static int PERIOD_L10 = 10;

    private final static int[] RECURRENCE_L11 = {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    private final static int[] RECURRENCE_L9 = {1, 1, 0, 1, 1, 0, 0, 0, 0};
    private final static int[] RECURRENCE_L10 = {1, 0, 0, 1, 0, 0, 0, 0, 0, 0};

    public GeffeGenerator() {
        L11 = new LSR(PERIOD_L11, RECURRENCE_L11);
        L9 = new LSR(PERIOD_L9, RECURRENCE_L9);
        L10 = new LSR(PERIOD_L10, RECURRENCE_L10);
        updateState();
    }

    @Override
    public void updateState() {
        L11.setCondition(System.nanoTime());
        L9.setCondition(System.nanoTime());
        L10.setCondition(System.nanoTime());
    }

    @Override
    public int generate() {
        int flag = L10.tact();
        return (flag & L11.tact()) ^ (1 ^ flag) & L9.tact();
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
