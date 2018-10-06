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

    public static void main( String[] args )
    {
        RandomGenerator[] generators = new RandomGenerator[NUM_OF_GENS];
        generators[0] = new BBSBitGenerator();
        generators[1] = new BMBitGenerator();
        generators[2] = new EmbeddedRandomGenerator();
        generators[3] = new GeffeGenerator();
        generators[4] = new L20Generator();
        generators[5] = new L89Generator();
        generators[6] = new LahmerHighGenerator();
        generators[7] = new LahmerLowGenerator();
        generators[8] = new LibrarianGenerator();
        generators[9] = new WolframGenerator();
        generators[10] = new BBSByteGenerator();
        generators[11] = new BBSByteGenerator();

        for (RandomGenerator generator: generators) {
            generator.generateRandomSequence(NUM_OF_BYTES);
        }

        for (RandomGenerator generator: generators) {
            generator.writeRandomSequenceAndTimeInFile("src/statistics/" + generator.getGeneratorName() + ".txt");
        }

        for (RandomGenerator generator : generators) {
            TestUtil.testCriterion(generator, new EquiprobableSignsCriterion(generator));
        }
        TestUtil.printResults(TEST_1);


        for (RandomGenerator generator : generators) {
            TestUtil.testCriterion(generator, new IndependenceSignsCriterion(generator));
        }
        TestUtil.printResults(TEST_2);

        for (RandomGenerator generator : generators) {
            TestUtil.testCriterion(generator, new UniformitySignsCriterion(generator));
        }
        TestUtil.printResults(TEST_3);

    }
}


