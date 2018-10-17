package ua.asymetric.cryptology;

import ua.asymetric.cryptology.random.*;
import ua.asymetric.cryptology.test.EquiprobableSignsCriterion;
import ua.asymetric.cryptology.test.IndependenceSignsCriterion;
import ua.asymetric.cryptology.test.UniformitySignsCriterion;
import ua.asymetric.cryptology.util.TestUtil;

public class App
{
    private static final int NUM_OF_BYTES = 262_144;
    private static final int NUM_OF_GENS = 12;
    private static final String TEST_1 = "Equiprobable Signs Criterion";
    private static final String TEST_2 = "Independence Signs Criterion";
    private static final String TEST_3 = "Uniformity Signs Criterion";
    private static final String TEST_RESULTS_PATH = "src\\statistics\\";

    public static void main( String[] args )
    {
        long startTime = System.currentTimeMillis();

        RandomGenerator[] generators = new RandomGenerator[NUM_OF_GENS];
        generators[0] = new BBSBitGenerator();
        generators[1] = new EmbeddedRandomGenerator();
        generators[2] = new GeffeGenerator();
        generators[3] = new L20Generator();
        generators[4] = new L89Generator();
        generators[5] = new LahmerHighGenerator();
        generators[6] = new LahmerLowGenerator();
        generators[7] = new LibrarianGenerator();
        generators[8] = new WolframGenerator();
        generators[9] = new BBSByteGenerator();
        generators[10] = new BMBitGenerator();
        generators[11] = new BMByteGenerator();

        for (RandomGenerator generator: generators) {
            generator.generateRandomSequence(NUM_OF_BYTES);
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time: " + elapsedTime);

        for (RandomGenerator generator: generators) {
            generator.writeRandomSequenceAndTimeInFile("src/statistics/" + generator.getGeneratorName() + ".txt");
        }

        for (RandomGenerator generator : generators) {
            TestUtil.testCriterion(generator, new EquiprobableSignsCriterion(generator));
        }
        TestUtil.printResults(TEST_1);
        TestUtil.printResultsToFile(TEST_RESULTS_PATH, TEST_1);


        for (RandomGenerator generator : generators) {
            TestUtil.testCriterion(generator, new IndependenceSignsCriterion(generator));
        }
        TestUtil.printResults(TEST_2);
        TestUtil.printResultsToFile(TEST_RESULTS_PATH, TEST_2);

        for (RandomGenerator generator : generators) {
            TestUtil.testCriterion(generator, new UniformitySignsCriterion(generator));
        }
        TestUtil.printResults(TEST_3);
        TestUtil.printResultsToFile(TEST_RESULTS_PATH, TEST_3);

    }
}


