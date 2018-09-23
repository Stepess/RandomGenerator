package ua.asymetric.cryptology;

import ua.asymetric.cryptology.random.L20Generator;
import ua.asymetric.cryptology.random.LahmerHighGenerator;
import ua.asymetric.cryptology.random.LahmerLowGenerator;
import ua.asymetric.cryptology.random.RandomGenerator;

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

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<89; i++){
            if (i==0 || i == 51) {
                sb.append("1, ");
            } else {
                sb.append("0, ");
            }
        }

        System.out.println(sb.toString());

    }
}
