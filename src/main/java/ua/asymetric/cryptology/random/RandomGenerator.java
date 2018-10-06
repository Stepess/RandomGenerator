package ua.asymetric.cryptology.random;

public abstract class RandomGenerator {

    private byte[] randomSequence;

    public abstract void updateState();

    public abstract int generate();

    public abstract byte generateRandomByte();

    public abstract String getGeneratorName();

    public void generateRandomSequence(int numOfBytes) {
        randomSequence = new byte[numOfBytes];
        for (int i=0; i<numOfBytes; i++) {
            randomSequence[i] = generateRandomByte();
        }
    }

    public byte[] getRandomSequence() {
        return randomSequence;
    }
}
