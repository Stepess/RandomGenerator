package ua.asymetric.cryptology;

import ua.asymetric.cryptology.random.*;
import ua.asymetric.cryptology.test.EquiprobableSignsCriterion;
import ua.asymetric.cryptology.util.TestUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class
App
{




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

        RandomGenerator generator6 = new BMGenerator();
        System.out.println(generator6.generate());

        RandomGenerator generator7 = new LibrarianGenerator();
        System.out.println(generator7.generate());

        try {
            ((LibrarianGenerator) generator7).getStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        //System.out.println(generator8.generate());

        //System.out.println(String.format("%8s", Integer.toBinaryString(generator8.generateRandomByte() & 0xFF)).replace(' ', '0'));

        /*byte[] randomSequence = new byte[NUM_OF_BYTES];
        int[] statistic = new int[NUM_OF_DIFFERENT_BYTES];
        for (int i=0; i<NUM_OF_BYTES; i++) {
            randomSequence[i] = generator8.generateRandomByte();
            statistic[randomSequence[i]+128]++;
        }*/



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

        *//*RandomGenerator BMGenerator = new BMGenerator();
        TestUtil.testEqiprobableSignsCriteria(BMGenerator, "BM EQIPROBABLE SIGNS TEST");*//*

        RandomGenerator LibrarianGenerator = new LibrarianGenerator();
        TestUtil.testEqiprobableSignsCriteria(LibrarianGenerator, "Librarian EQIPROBABLE SIGNS TEST");

        *//*RandomGenerator BBSGenerator = new BBSGenerator();
        TestUtil.testEqiprobableSignsCriteria(BBSGenerator, "BBS EQIPROBABLE SIGNS TEST");*//*
*/






        RandomGenerator GeffeGenerator = new GeffeGenerator();
        TestUtil.testEqiprobableSignsCriteriaForRandomGenerator(GeffeGenerator);

        RandomGenerator L20Generator = new L20Generator();
        TestUtil.testEqiprobableSignsCriteriaForRandomGenerator(L20Generator);

        TestUtil.printResults();



    }



}


