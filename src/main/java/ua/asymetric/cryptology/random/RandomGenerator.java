package ua.asymetric.cryptology.random;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public abstract class RandomGenerator {

    private byte[] randomSequence;
    private long elapsedTime = 0;

    public abstract void updateState();

    public abstract int generate();

    public abstract byte generateRandomByte();

    public abstract String getGeneratorName();

    public void generateRandomSequence(int numOfBytes) {
        randomSequence = new byte[numOfBytes];
        long startTime = System.currentTimeMillis();
        for (int i=0; i<numOfBytes; i++) {
            randomSequence[i] = generateRandomByte();
        }
        long stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
    }

    public byte[] getRandomSequence() {
        return randomSequence;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public abstract Object getSeed();

    public void writeRandomSequenceAndTimeInFile(String filePath) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Seed: " +  getSeed());
            bw.write("\r\n");
            for (byte b: randomSequence) {
                bw.write(Integer.toBinaryString(b));
            }
            bw.write("\r\n");
            bw.write("Elapsed time: " + elapsedTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
