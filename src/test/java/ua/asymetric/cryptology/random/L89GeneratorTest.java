package ua.asymetric.cryptology.random;

import org.junit.Test;
import ua.asymetric.cryptology.util.TestUtil;

import static org.junit.Assert.*;

public class L89GeneratorTest {

    @Test
    public void eqiprobableSignsTest() {
        RandomGenerator L89Generator = new L89Generator();
        TestUtil.testEqiprobableSignsCriteria(L89Generator, "L89 EQIPROBABLE SIGNS TEST");
    }


}