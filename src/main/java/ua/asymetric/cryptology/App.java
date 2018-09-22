package ua.asymetric.cryptology;

import ua.asymetric.cryptology.random.LahmerHighGenerator;
import ua.asymetric.cryptology.random.LahmerLowGenerator;
import ua.asymetric.cryptology.random.RandomGenerator;

public class App 
{
    public static void main( String[] args )
    {
        RandomGenerator generator = new LahmerLowGenerator();

            System.out.println(Integer.toBinaryString(generator.generate()));
        RandomGenerator generator1 = new LahmerHighGenerator();
        System.out.println(Integer.toBinaryString(generator1.generate()));
    }
}
