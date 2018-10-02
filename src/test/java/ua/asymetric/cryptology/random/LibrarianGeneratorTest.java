package ua.asymetric.cryptology.random;

import org.junit.Test;
import ua.asymetric.cryptology.util.TestUtil;

import static org.junit.Assert.*;

public class LibrarianGeneratorTest {

    @Test
    public void eqiprobableSignsTest() {
        RandomGenerator generator = new LibrarianGenerator();
        TestUtil.testEqiprobableSignsCriteria(generator, "LIBRARIAN EQIPROBABLE SIGNS TEST");
    }

}