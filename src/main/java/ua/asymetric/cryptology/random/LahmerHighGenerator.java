package ua.asymetric.cryptology.random;

public class LahmerHighGenerator extends LahmerGenerator implements RandomGenerator {
    @Override
    public int generate() {
        return (int) (super.generateIntermediateValue() >>> 24) & 0xFF ;
    }
}
