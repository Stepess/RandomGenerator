package ua.asymetric.cryptology.test;

import ua.asymetric.cryptology.random.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class IndependenceSignsCriterion extends AbstractCriterion{

    private static final int NUM_OF_BYTES = 262_144;
    private static final int NUM_OF_DIFFERENT_BYTES = 256;

    private int[][] statisticData;
    private byte[] randomSequence;
    private RandomGenerator generator;

    private double chiSqr = 0;

    public IndependenceSignsCriterion(RandomGenerator generator) {
        this.generator = generator;
        this.statisticData = new int[NUM_OF_DIFFERENT_BYTES][NUM_OF_DIFFERENT_BYTES];
        this.randomSequence = new byte[NUM_OF_BYTES];
    }

    public IndependenceSignsCriterion(byte[] randomSequence, RandomGenerator generator) {
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
        for (int i=0; i<NUM_OF_BYTES/2; i++) {
            statisticData[randomSequence[2*i]+128][randomSequence[2*i+1]+128]++;
        }
    }

    public void calculateChiSqr() {
        for (int i = 0; i < NUM_OF_DIFFERENT_BYTES; i++) {
            for (int j = 0; j < NUM_OF_DIFFERENT_BYTES; j++) {
                int denominator = sumLine(statisticData, i) *  sumColumn(statisticData, j);
                if (denominator!=0) {
                    chiSqr += statisticData[i][j]*statisticData[i][j]*1.0/(denominator);
                }
            }
        }
        chiSqr--;
        chiSqr *= NUM_OF_BYTES/2;

    }

    private int sumLine(int[][] array, int lineIndex) {
        int result = 0;
        for (int i=0;i<array[lineIndex].length; i++) {
            result += array[lineIndex][i];
        }
        return result;
    }

    private int sumColumn(int[][] array, int columnIndex) {
        int result = 0;
        for (int i=0;i<array[columnIndex].length; i++) {
            result += array[i][columnIndex];
        }
        return result;
    }

    public double calculateThresholdValue(double quantile) {
        long l = NUM_OF_DIFFERENT_BYTES*NUM_OF_DIFFERENT_BYTES;
        return Math.sqrt(2*l)*quantile + l;
    }

    public boolean test(double quantile) {
        double threshold = calculateThresholdValue(quantile);
        //System.out.println(Arrays.toString(randomSequence));
        //System.out.println(Arrays.toString(statisticData));
        //System.out.println("Test threashold - " + threshold);
        return (chiSqr - threshold)<0;
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
        /*Stream.of(randomSequence).forEach(System.out::println);*/
        for (int i=0; i<NUM_OF_BYTES; i++) {
            System.out.println(randomSequence[i]);
        }
    }
}