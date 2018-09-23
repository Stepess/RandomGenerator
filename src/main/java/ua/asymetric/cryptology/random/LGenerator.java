package ua.asymetric.cryptology.random;

import ua.asymetric.cryptology.LSR;

public abstract class LGenerator implements RandomGenerator {
    private LSR lsr;

    LGenerator(LSR lsr) {
        this.lsr = lsr;
    }

    @Override
    public void updateState() {
        lsr.setCondition(System.nanoTime());
    }

    @Override
    public int generate() {
        return lsr.tact();
    }
}
