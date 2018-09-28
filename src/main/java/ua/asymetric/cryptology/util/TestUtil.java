package ua.asymetric.cryptology.util;

import ua.asymetric.cryptology.random.RandomGenerator;
import ua.asymetric.cryptology.test.EquiprobableSignsCriterion;

public class TestUtil {

    private static final double QUANTILE_LEVEL_0_01 = 2.35;
    private static final double QUANTILE_LEVEL_0_05 = 1.65;
    private static final double QUANTILE_LEVEL_0_1 = 1.3;

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

}
