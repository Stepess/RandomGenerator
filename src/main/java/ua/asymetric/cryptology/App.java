package ua.asymetric.cryptology;

import ua.asymetric.cryptology.random.*;

import java.io.IOException;
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

        RandomGenerator generator5 = new WolframGenerator();
        System.out.println(generator5.generate());

        RandomGenerator generator6 = new BMGenerator();
        System.out.println(generator6.generate());

        RandomGenerator generator7 = new LibrarianGenerator();
        for (int i=0;i<100;i++) {
            System.out.println(generator7.generate());
        }
        try {
            ((LibrarianGenerator) generator7).getStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
