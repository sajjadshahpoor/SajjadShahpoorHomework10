import org.junit.Test;

import static org.junit.Assert.*;

public class FractionalUnitTest {
    @Test
    public void testGetValue() {
        assertEquals(((double) 6 /1), new Fractional(6,1).getValue(), 0.0001);
        assertEquals(((double) 2)/26, new Fractional(2, 26).getValue(), 0.0001);
        assertEquals(((double) 1)/13, new Fractional(2,26).getValue(), 0.0001);
        assertEquals(((double) 16)/32, new Fractional(16, 32).getValue(), 0.0001);
        assertEquals(((double) 1)/2, new Fractional(16,32).getValue(), 0.0001);
        assertEquals(((double) 32)/16, new Fractional(32, 16).getValue(), 0.0001);
        assertEquals(((double) 2), new Fractional(32,16).getValue(), 0.0001);
        assertEquals(((double) 0), new Fractional(0, 16).getValue(), 0.0001);
        assertEquals(Double.NaN, new Fractional(0,0).getValue(),0.000001);
        assertEquals(Double.POSITIVE_INFINITY, new Fractional(5,0).getValue(), 0.000001);
        assertEquals(Double.NEGATIVE_INFINITY, new Fractional(-5,0).getValue(), 0.000001);
    }

    @Test
    public void isNANTest() {
        assertEquals(true, new Fractional(0,0).isNaN());
        assertEquals(false, new Fractional(5,0).isNaN());
        assertEquals(false, new Fractional(0,5).isNaN());
        assertEquals(Fractional.NotANumber, new Fractional(0,0).toString());

    }

    @Test
    public void isINFINITYTest() {
        //true -> Infinity
        //false -> Not infinity
        assertEquals(true , new Fractional(5, 0).isInfinity());
        assertEquals(false, new Fractional(0,0).isInfinity());
        assertEquals(false, new Fractional(0,5).isInfinity());
        assertEquals(false, new Fractional(5, 5).isInfinity());
    }

    @Test
    public void signTest() { //Test for Sign
        //0 means positive
        //1 means negative
        assertThrows(ArithmeticException.class, () -> {new Fractional(0, 0).sign(); });
        assertEquals(0, new Fractional(0,10).sign());
        assertEquals(1, new Fractional(0, -10).sign());
        assertEquals(0, new Fractional(10,0).sign());
        assertEquals(1, new Fractional(-10,0).sign());
        assertEquals(0, new Fractional(5,6).sign());
        assertEquals(0, new Fractional(-10,-20).sign());
        assertEquals(1, new Fractional(-10,30).sign());
        assertEquals(1, new Fractional(20, -50).sign());
    }

    @Test
    public void ToStringTest() { //Test for To string
        assertEquals(Fractional.NotANumber, new Fractional(0,0).toString());
        assertEquals(Fractional.PositiveInfinity, new Fractional(5,0).toString());
        assertEquals(Fractional.NegativeInfinity, new Fractional(-5,0).toString());
        assertEquals("6", new Fractional(6,1).toString());
        assertEquals("2/26", new Fractional(2, 26).toString());
        assertEquals("0", new Fractional(0, 16).toString());

    }

    @Test
    public void ToSimplifyTest() {  // Test for both Simplify and GCD
        assertEquals(Double.NaN, new Fractional(0,0).simplify().getValue(), 0.000001);
        assertEquals(new Fractional(2, 0), new Fractional(5,0).simplify());
        assertEquals(new Fractional(-63, 0), new Fractional(-5,0).simplify());
        assertEquals(new Fractional(6, 1), new Fractional(6,1).simplify());
        assertEquals(new Fractional(1, 13), new Fractional(2, 26).simplify());
        assertEquals(new Fractional(1,2), new Fractional(16, 32).simplify());
    }

    @Test
    public void ToequalTest() {
        assertEquals(false, new Fractional(0,0).equals(new Fractional(0, 0)));
        assertEquals(true, new Fractional(5,6).equals(new Fractional(5,6)));
        assertEquals(true, new Fractional(10,12).equals(new Fractional(5,6)));
        assertEquals(false, new Fractional(7,9).equals(new Fractional(2,5)));
        assertEquals(false, new Fractional(5,9).equals(new Integer(0)));
        assertEquals(true, new Fractional(15, -3).equals(new Integer(-5)));
        assertEquals(false, new Fractional(3,8).equals(new Integer(99)));
        assertEquals(true, new Fractional(5,10).equals(new Double(((double) 5/10))));
        assertEquals(false, new Fractional(22,62).equals(new Double(5.2)));
    }

    @Test
    public void staticsignTest() {
        //0 means positive
        //1 means negative
        assertThrows(ArithmeticException.class, () -> {Fractional.sign(0, 0) ;});
        assertEquals(0, Fractional.sign(0,10));
        assertEquals(1, Fractional.sign(0, -10));
        assertEquals(0, Fractional.sign(10,0));
        assertEquals(1, Fractional.sign(-10,0));
        assertEquals(0, Fractional.sign(5,6));
        assertEquals(0, Fractional.sign(-10,-20));
        assertEquals(1, Fractional.sign(-10,30));
        assertEquals(1, Fractional.sign(20, -50));
    }
}
