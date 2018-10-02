package ua.asymetric.cryptology.random;

public interface RandomGenerator {
    void updateState();

    int generate();

    byte generateRandomByte();

    String getGeneratorName();
}
