package ua.asymetric.cryptology;

import ua.asymetric.cryptology.random.*;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        RandomGenerator generator = new LahmerLowGenerator();
        System.out.println(Integer.toBinaryString(generator.generate()));

        RandomGenerator generator1 = new LahmerHighGenerator();
        System.out.println(Integer.toBinaryString(generator1.generate()));

        RandomGenerator generator2 = new L20Generator();
        System.out.println(generator2.generate());

        RandomGenerator generator3 = new L89Generator();
        System.out.println(generator3.generate());

        RandomGenerator generator4 = new GeffeGenerator();
        System.out.println(generator4.generate());

    }
}
