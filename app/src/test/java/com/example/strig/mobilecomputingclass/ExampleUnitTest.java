package com.example.strig.mobilecomputingclass;

import org.junit.Test;

import static com.example.strig.mobilecomputingclass.le180313_Testing.TestingActivity.areValid;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void validNames_True() {
        assertTrue(areValid("Valid", "Name"));
    }

    @Test
    public void invalidNames_False() {
        assertFalse(areValid("lowercase", "Name"));
        assertFalse(areValid("Lowercase", "surname"));
        assertFalse(areValid("lowercase", "fullname"));
        assertFalse(areValid("UPPercaSe", "InsIdE"));
        assertFalse(areValid("Нелатинские", "Данные"));
    }
}