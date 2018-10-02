package ua.asymetric.cryptology.util;

import org.apache.commons.lang3.StringUtils;
import ua.asymetric.cryptology.random.RandomGenerator;
import ua.asymetric.cryptology.test.EquiprobableSignsCriterion;

import java.util.HashMap;
import java.util.Map;

public class TestUtil {

    private static final double QUANTILE_LEVEL_0_01 = 2.35;
    private static final double QUANTILE_LEVEL_0_05 = 1.65;
    private static final double QUANTILE_LEVEL_0_1 = 1.3;

    private static final Map<String, double[]> thresholds = new HashMap<>();
    private static final Map<String, boolean[]> testResults = new HashMap<>();
    private static final Map<String, Double> chiSquares = new HashMap<>();


    private static final String DECOR = "=====";

    public static void testEqiprobableSignsCriteria(RandomGenerator generator, String titleOfTest) {
        System.out.println(DECOR + titleOfTest + DECOR);

        EquiprobableSignsCriterion TestEqiprobSigns = new EquiprobableSignsCriterion(generator);

        TestEqiprobSigns.generateRandomSequence();
        TestEqiprobSigns.countStatisticData();
        TestEqiprobSigns.calculateHiSqr();

        System.out.println("HiSqr = " + TestEqiprobSigns.getHiSqr());

        System.out.println("Level 0.01 - " + TestEqiprobSigns.test(QUANTILE_LEVEL_0_01));
        System.out.println("Level 0.05 - " + TestEqiprobSigns.test(QUANTILE_LEVEL_0_05));
        System.out.println("Level 0.1 - " + TestEqiprobSigns.test(QUANTILE_LEVEL_0_1));
    }

   // public static void testEqiprobableSignsCriteriaForRandomGenerator(RandomGenerator generator, Map<String, double[]> thresholds, Map<String, Double> chiSquares, Map<String, boolean[]> testResults) {
     public static void testEqiprobableSignsCriteriaForRandomGenerator(RandomGenerator generator) {
        EquiprobableSignsCriterion criterion = new EquiprobableSignsCriterion(generator);
        criterion.generateRandomSequence();
        criterion.countStatisticData();
        criterion.calculateHiSqr();

        double[] thresholdsValues = new double[3];

        thresholdsValues[0] = criterion.calculateThresholdValue(QUANTILE_LEVEL_0_01);
        thresholdsValues[1] = criterion.calculateThresholdValue(QUANTILE_LEVEL_0_05);
        thresholdsValues[2] = criterion.calculateThresholdValue(QUANTILE_LEVEL_0_1);

        thresholds.put(generator.getGeneratorName(), thresholdsValues);

        chiSquares.put(generator.getGeneratorName(), criterion.getHiSqr());

        boolean[] resultsValues = new boolean[3];

        resultsValues[0] = criterion.test(QUANTILE_LEVEL_0_01);
        resultsValues[1] = criterion.test(QUANTILE_LEVEL_0_05);
        resultsValues[2] = criterion.test(QUANTILE_LEVEL_0_1);

        testResults.put(generator.getGeneratorName(), resultsValues);
    }

    public static void printResults() {
        double[] criterionPowers = {0.01, 0.05, 0.1};
        System.out.println();
        System.out.println(StringUtils.leftPad("EqiProbableSignsCriteria", 70));
        for (int i=0; i<3; i++) {
            System.out.print(StringUtils.leftPad(String.valueOf(criterionPowers[i]), 30));
        }
        System.out.println();
        for (String name: thresholds.keySet()) {
            System.out.printf("|%10s", name);
            for (int i=0; i<3; i++) {
                System.out.printf("|%5s (%-10.2f , %-10.2f)", StringUtils.leftPad(String.valueOf(testResults.get(name)[i]), 5),
                        thresholds.get(name)[i], chiSquares.get(name));

            }
            System.out.println();
            //System.out.printf ("%-30s", StringUtils.leftPad(name, 30));
        }


    }

}
