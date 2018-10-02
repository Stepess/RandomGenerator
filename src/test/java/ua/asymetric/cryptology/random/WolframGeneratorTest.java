package ua.asymetric.cryptology.random;

import org.junit.Test;
import ua.asymetric.cryptology.util.TestUtil;

import static org.junit.Assert.*;

public class WolframGeneratorTest {
    //TODO can't pass this test
    @Test
    public void eqiprobableSignsTest() {
        RandomGenerator WolframGenerator = new WolframGenerator();
        TestUtil.testEqiprobableSignsCriteria(WolframGenerator, "WOLFRAM EQIPROBABLE SIGNS TEST");
    }

}