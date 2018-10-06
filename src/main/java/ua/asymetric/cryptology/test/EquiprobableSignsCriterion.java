package ua.asymetric.cryptology.test;

import ua.asymetric.cryptology.random.RandomGenerator;

public class EquiprobableSignsCriterion extends AbstractCriterion {

    private static final int NUM_OF_BYTES = 262_144;
    private static final int NUM_OF_DIFFERENT_BYTES = 256;

    private int[] statisticData;
    private byte[] randomSequence;
    private RandomGenerator generator;
    private double expectedNumberOfByte;
    private double chiSqr;

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

    public void countStatisticData(byte[] randomSequence) {
        for (int i=0; i<NUM_OF_BYTES; i++) {
            statisticData[randomSequence[i]+128]++;
        }
    }

    public void calculateChiSqr() {
        for (int i=0; i<NUM_OF_DIFFERENT_BYTES; i++) {
            chiSqr += Math.pow(statisticData[i] - expectedNumberOfByte, 2)*1.0/expectedNumberOfByte;
        }
    }

    public double calculateThresholdValue(double quantile) {
        return Math.sqrt(2*(NUM_OF_DIFFERENT_BYTES-1))*quantile + NUM_OF_DIFFERENT_BYTES-1;
    }

    public boolean test(double quantile) {
        return (chiSqr - calculateThresholdValue(quantile))<0;
    }

    public double getChiSqr() {
        return chiSqr;
    }

    public int[] getStatisticData() {
        return statisticData;
    }

    public byte[] getRandomSequence() {
        return randomSequence;
    }
}
