package ua.asymetric.cryptology.random;

public interface RandomGenerator {
    void updateState();
    int generate();
}
