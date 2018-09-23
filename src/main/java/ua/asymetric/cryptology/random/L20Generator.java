package ua.asymetric.cryptology.random;

import ua.asymetric.cryptology.LSR;

public class L20Generator extends LGenerator implements RandomGenerator {
    private final static int PERIOD = 20;
    private final static int[] RECURRENCE = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0};

    public L20Generator() {
        super(new LSR(PERIOD, RECURRENCE));
        super.updateState();
    }
}
