package personnumbervalidator;

import static org.junit.Assert.*;

public class SwedishPersonNumberWithLineBetweenValidatorTest {

    @org.junit.Test
    public void isNull() {
        SwedishPersonNumberWithLineBetweenValidator p1 = new SwedishPersonNumberWithLineBetweenValidator("");
        SwedishPersonNumberWithLineBetweenValidator p2 = new SwedishPersonNumberWithLineBetweenValidator(null);
        SwedishPersonNumberWithLineBetweenValidator p3 = new SwedishPersonNumberWithLineBetweenValidator("19780202-2389");


        assertTrue(p1.isNull());
        assertTrue(p2.isNull());
        assertFalse(p3.isNull());
    }

    @org.junit.Test
    public void isCorrectPersonNumber() {
        SwedishPersonNumberWithLineBetweenValidator p1 = new SwedishPersonNumberWithLineBetweenValidator("19780202-2389"); // correct
        SwedishPersonNumberWithLineBetweenValidator p2 = new SwedishPersonNumberWithLineBetweenValidator("29780202-2389"); // wrong year
        SwedishPersonNumberWithLineBetweenValidator p3 = new SwedishPersonNumberWithLineBetweenValidator("19782202-2389"); // wrong month
        SwedishPersonNumberWithLineBetweenValidator p4 = new SwedishPersonNumberWithLineBetweenValidator("19780242-2389"); // wrong day
        SwedishPersonNumberWithLineBetweenValidator p5 = new SwedishPersonNumberWithLineBetweenValidator("19780202-2u89"); // wrong last numbers
        SwedishPersonNumberWithLineBetweenValidator p6 = new SwedishPersonNumberWithLineBetweenValidator("197802023-2389");// too long
        SwedishPersonNumberWithLineBetweenValidator p7 = new SwedishPersonNumberWithLineBetweenValidator("1978020-2389");  // too short
        SwedishPersonNumberWithLineBetweenValidator p8 = new SwedishPersonNumberWithLineBetweenValidator("19780202-2387"); // last not mach the sume


        assertTrue(p1.isCorrectPersonNumber());
        assertFalse(p2.isCorrectPersonNumber());
        assertFalse(p3.isCorrectPersonNumber());
        assertFalse(p4.isCorrectPersonNumber());
        assertFalse(p5.isCorrectPersonNumber());
        assertFalse(p6.isCorrectPersonNumber());
        assertFalse(p7.isCorrectPersonNumber());
        assertFalse(p8.isCorrectPersonNumber());
    }
}