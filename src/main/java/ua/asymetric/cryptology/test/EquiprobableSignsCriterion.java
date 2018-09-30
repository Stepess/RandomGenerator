package ua.asymetric.cryptology.test;

import ua.asymetric.cryptology.random.RandomGenerator;

import java.util.Arrays;

public class EquiprobableSignsCriterion {

    private static final int NUM_OF_BYTES = 262_144;
    private static final int NUM_OF_DIFFERENT_BYTES = 256;

    private int[] statisticData;
    private byte[] randomSequence;
    private RandomGenerator generator;
    private double expectedNumberOfByte;
    private double hiSqr;

    public EquiprobableSignsCriterion(RandomGenerator generator) {
        this.generator = generator;
        statisticData = new int[NUM_OF_DIFFERENT_BYTES];
        randomSequence = new byte[NUM_OF_BYTES];
        expectedNumberOfByte = NUM_OF_BYTES*1.0/NUM_OF_DIFFERENT_BYTES;
    }

    public void generateRandomSequence() {
        for (int i=0; i<NUM_OF_BYTES; i++) {
            randomSequence[i] = generator.generateRandomByte();
        }
    }

    public void countStatisticData() {
        for (int i=0; i<NUM_OF_BYTES; i++) {
            statisticData[randomSequence[i]+128]++;
        }
    }

    public void calculateHiSqr() {
        for (int i=0; i<NUM_OF_DIFFERENT_BYTES; i++) {
            hiSqr += Math.pow(statisticData[i] - expectedNumberOfByte, 2)/expectedNumberOfByte;
        }
    }

    public boolean test(double quantile) {
        double threshold = Math.sqrt(2*(NUM_OF_DIFFERENT_BYTES-1))*quantile + NUM_OF_DIFFERENT_BYTES-1;
        System.out.println("Test threashold - " + threshold);
        return (hiSqr - threshold)<0;
    }

    public double getHiSqr() {
        return hiSqr;
    }
}
