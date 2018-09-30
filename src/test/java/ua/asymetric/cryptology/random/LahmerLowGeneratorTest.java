package ua.asymetric.cryptology.random;

import org.junit.Test;
import ua.asymetric.cryptology.util.TestUtil;

import static org.junit.Assert.*;

public class LahmerLowGeneratorTest {

    @Test
    public void eqiprobableSignsTest() {
        RandomGenerator LahmerLowGenerator = new LahmerLowGenerator();
        TestUtil.testEqiprobableSignsCriteria(LahmerLowGenerator, "LAHMER LOW EQIPROBABLE SIGNS TEST");
    }

}