package ua.asymetric.cryptology.util;

import org.apache.commons.lang3.StringUtils;
import ua.asymetric.cryptology.random.RandomGenerator;
import ua.asymetric.cryptology.test.AbstractCriterion;

import java.util.HashMap;
import java.util.Map;

public class TestUtil {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static final double QUANTILE_LEVEL_0_01 = 2.35;
    private static final double QUANTILE_LEVEL_0_05 = 1.65;
    private static final double QUANTILE_LEVEL_0_1 = 1.3;

    private static final Map<String, double[]> thresholds = new HashMap<>();
    private static final Map<String, boolean[]> testResults = new HashMap<>();
    private static final Map<String, Double> chiSquares = new HashMap<>();

    public static void testCriterion(RandomGenerator generator, AbstractCriterion criterion) {
        criterion.countStatisticData(generator.getRandomSequence());
        criterion.calculateChiSqr();

        double[] thresholdsValues = new double[3];

        thresholdsValues[0] = criterion.calculateThresholdValue(QUANTILE_LEVEL_0_01);
        thresholdsValues[1] = criterion.calculateThresholdValue(QUANTILE_LEVEL_0_05);
        thresholdsValues[2] = criterion.calculateThresholdValue(QUANTILE_LEVEL_0_1);

        thresholds.put(generator.getGeneratorName(), thresholdsValues);

        chiSquares.put(generator.getGeneratorName(), criterion.getChiSqr());

        boolean[] resultsValues = new boolean[3];

        resultsValues[0] = criterion.test(QUANTILE_LEVEL_0_01);
        resultsValues[1] = criterion.test(QUANTILE_LEVEL_0_05);
        resultsValues[2] = criterion.test(QUANTILE_LEVEL_0_1);

        testResults.put(generator.getGeneratorName(), resultsValues);
    }

    public static void printResults(String criterionName) {
        double[] criterionPowers = {0.01, 0.05, 0.1};
        System.out.println();
        System.out.println(StringUtils.leftPad(criterionName, 70));
        for (int i=0; i<3; i++) {
            System.out.print(StringUtils.leftPad(String.valueOf(criterionPowers[i]), 35));
        }
        System.out.println();
        for (String name: thresholds.keySet()) {
            System.out.printf("|%10s", name);
            for (int i=0; i<3; i++) {
                String color = testResults.get(name)[i]?ANSI_GREEN:ANSI_RED;
                System.out.printf("|%5s\t(%-12.2f , %-12.2f)",StringUtils.leftPad( color + String.valueOf(testResults.get(name)[i] + ANSI_RESET ), 5),
                        thresholds.get(name)[i], chiSquares.get(name));
            }
            System.out.println();
        }
    }
}
