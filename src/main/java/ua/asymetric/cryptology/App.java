package ua.asymetric.cryptology;

import ua.asymetric.cryptology.random.*;
import ua.asymetric.cryptology.test.EquiprobableSignsCriterion;
import ua.asymetric.cryptology.test.IndependenceSignsCriterion;
import ua.asymetric.cryptology.test.UniformitySignsCriterion;
import ua.asymetric.cryptology.util.TestUtil;

public class
App
{

    private static final int NUM_OF_BYTES = 262_144;


    public static void main( String[] args )
    {
        /*RandomGenerator generator = new LahmerLowGenerator();
        System.out.println(Integer.toBinaryString(generator.generate()));

        RandomGenerator generator1 = new LahmerHighGenerator();
        System.out.println(Integer.toBinaryString(generator1.generate()));

        RandomGenerator generator2 = new L20Generator();
        System.out.println(generator2.generate());

        RandomGenerator generator3 = new L89Generator();
        System.out.println(generator3.generate());

        RandomGenerator generator4 = new GeffeGenerator();
        System.out.println(generator4.generate());

        RandomGenerator generator5 = new WolframGenerator();
        System.out.println(generator5.generate());

        RandomGenerator generator6 = new BMBitGenerator();
        System.out.println(generator6.generate());

        RandomGenerator generator7 = new LibrarianGenerator();
        System.out.println(generator7.generate());

        try {
            ((LibrarianGenerator) generator7).getStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(generator8.generate());

        //System.out.println(String.format("%8s", Integer.toBinaryString(generator8.generateRandomByte() & 0xFF)).replace(' ', '0'));

        byte[] randomSequence = new byte[NUM_OF_BYTES];
        int[] statistic = new int[NUM_OF_DIFFERENT_BYTES];
        for (int i=0; i<NUM_OF_BYTES; i++) {
            randomSequence[i] = generator8.generateRandomByte();
            statistic[randomSequence[i]+128]++;
        }

*/

        /*RandomGenerator LahmerLowGenerator = new LahmerLowGenerator();
        TestUtil.testEqiprobableSignsCriteria(LahmerLowGenerator, "LAHMER LOW EQIPROBABLE SIGNS TEST");

        *//*RandomGenerator LahmerHighGenerator = new LahmerHighGenerator();
        TestUtil.testEqiprobableSignsCriteria(LahmerHighGenerator, "LAHMER HIGH EQIPROBABLE SIGNS TEST");*//*

        *//*RandomGenerator L20Generator = new L20Generator();
        TestUtil.testEqiprobableSignsCriteria(L20Generator, "L20 EQIPROBABLE SIGNS TEST");*//*

        RandomGenerator L89Generator = new L89Generator();
        TestUtil.testEqiprobableSignsCriteria(L89Generator, "L89 EQIPROBABLE SIGNS TEST");

        *//*RandomGenerator GeffeGenerator = new GeffeGenerator();
        TestUtil.testEqiprobableSignsCriteria(GeffeGenerator, "GEFFE EQIPROBABLE SIGNS TEST");*//*

        RandomGenerator WolframGenerator = new WolframGenerator();
        TestUtil.testEqiprobableSignsCriteria(WolframGenerator, "WOLFRAM EQIPROBABLE SIGNS TEST");

        *//*RandomGenerator BMBitGenerator = new BMBitGenerator();
        TestUtil.testEqiprobableSignsCriteria(BMBitGenerator, "BM EQIPROBABLE SIGNS TEST");*//*

        RandomGenerator LibrarianGenerator = new LibrarianGenerator();
        TestUtil.testEqiprobableSignsCriteria(LibrarianGenerator, "Librarian EQIPROBABLE SIGNS TEST");

        *//*RandomGenerator BBSBitGenerator = new BBSBitGenerator();
        TestUtil.testEqiprobableSignsCriteria(BBSBitGenerator, "BBS EQIPROBABLE SIGNS TEST");*//*
*/

        int numOfGens = 11;
        RandomGenerator[] generators = new RandomGenerator[numOfGens];
        generators[0] = new BBSBitGenerator();
        //generators[0] = new GeffeGenerator();
        generators[1] = new BMBitGenerator();
        //generators[1] = new GeffeGenerator();
        generators[2] = new EmbeddedRandomGenerator();
        generators[3] = new GeffeGenerator();
        generators[4] = new L20Generator();
        generators[5] = new L89Generator();
        generators[6] = new LahmerHighGenerator();
        generators[7] = new LahmerLowGenerator();
        generators[8] = new LibrarianGenerator();
        generators[9] = new WolframGenerator();
        generators[10] = new BBSByteGenerator();

        for (RandomGenerator generator: generators) {
            generator.generateRandomSequence(NUM_OF_BYTES);
        }

        for (RandomGenerator generator : generators) {
            TestUtil.testCriterion(generator, new EquiprobableSignsCriterion(generator));
        }
        TestUtil.printResults("Equiprobable Signs Criterion");


        for (RandomGenerator generator : generators) {
            TestUtil.testCriterion(generator, new IndependenceSignsCriterion(generator));
        }

        TestUtil.printResults("Independence Signs Criterion");

        for (RandomGenerator generator : generators) {
            TestUtil.testCriterion(generator, new UniformitySignsCriterion(generator));
        }

        TestUtil.printResults("Uniformity Signs Criterion");

       /* TestUtil.testCriterion(generators[4], new UniformitySignsCriterion(generators[4]));

        TestUtil.printResults();*/

        /*RandomGenerator generator = new LahmerLowGenerator();

        TestUtil.testIndependenceSignsCriteriaForRandomGenerator(generator);

        TestUtil.printResults();*/



    }



}


