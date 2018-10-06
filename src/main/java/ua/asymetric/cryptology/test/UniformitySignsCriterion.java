package ua.asymetric.cryptology.test;

import ua.asymetric.cryptology.random.RandomGenerator;

public class UniformitySignsCriterion extends AbstractCriterion{

    private static final int NUM_OF_BYTES = 262_144;
    private static final int NUM_OF_DIFFERENT_BYTES = 256;

    private int[][] statisticData;
    private byte[] randomSequence;
    private RandomGenerator generator;
    private static final int R = 32;
    private static final int M = NUM_OF_BYTES/R;
    private static final int N = M*R;

    private double chiSqr = 0;

    public UniformitySignsCriterion(RandomGenerator generator) {
        this.generator = generator;
        this.statisticData = new int[R][NUM_OF_DIFFERENT_BYTES];
        this.randomSequence = new byte[NUM_OF_BYTES];
    }

    public UniformitySignsCriterion(byte[] randomSequence, RandomGenerator generator) {
        this.randomSequence = randomSequence;
        this.generator = generator;
        this.statisticData = new int[NUM_OF_DIFFERENT_BYTES][NUM_OF_DIFFERENT_BYTES];
    }

    public void generateRandomSequence() {
        for (int i=0; i<NUM_OF_BYTES; i++) {
            randomSequence[i] = generator.generateRandomByte();
        }
    }

    public void countStatisticData(byte[] randomSequence) {
        for (int j=0; j<R; j++) {
            for (int i=M*j; i<M*j + M; i++) {
                statisticData[j][randomSequence[i]+128]++;
            }
        }
    }


    public void calculateChiSqr() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < NUM_OF_DIFFERENT_BYTES; j++) {
                int denominator = sumColumn(statisticData, i) *  M;
                if (denominator!=0) {
                    chiSqr += statisticData[i][j]*statisticData[i][j]*1.0/(denominator);
                }
            }
        }
        chiSqr--;
        chiSqr *= N;
    }

    private int sumColumn(int[][] array, int columnIndex) {
        int result = 0;
        for (int i=0;i<array.length; i++) {
            result += array[i][columnIndex];
        }
        return result;
    }

    public double calculateThresholdValue(double quantile) {
        long l = (NUM_OF_DIFFERENT_BYTES-1)*(R-1);
        return Math.sqrt(2*l)*quantile + l;
    }


    public boolean test(double quantile) {
        return (chiSqr - calculateThresholdValue(quantile))<0;
    }

    public double getChiSqr() {
        return chiSqr;
    }

    public void printStatisticData() {
        for (int i=0; i<NUM_OF_DIFFERENT_BYTES; i++) {
            for (int j=0; j<NUM_OF_DIFFERENT_BYTES; j++) {
                System.out.print(statisticData[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printRandomSequence() {
        for (int i=0; i<NUM_OF_BYTES; i++) {
            System.out.println(randomSequence[i]);
        }
    }
}
