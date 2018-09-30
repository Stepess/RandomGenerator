package ua.asymetric.cryptology.random;

import org.junit.Test;
import ua.asymetric.cryptology.util.TestUtil;

import static org.junit.Assert.*;

public class LahmerHighGeneratorTest {

    @Test
    public void eqiprobableSignsTest() {
        RandomGenerator LahmerHighGenerator = new LahmerHighGenerator();
        TestUtil.testEqiprobableSignsCriteria(LahmerHighGenerator, "LAHMER HIGH EQIPROBABLE SIGNS TEST");
    }

}