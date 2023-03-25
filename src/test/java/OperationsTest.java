import org.example.Operations;
import org.example.Polynom;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OperationsTest {

    static Polynom p1;
    static Polynom p2;
    @BeforeClass
    public static void initialisePolynomials() {
        p1 = new Polynom();
        p2 = new Polynom();

        p1.polynomList.put(0, -5.0);
        p1.polynomList.put(2, -2.0);
        p1.polynomList.put(3, 1.0);

        p2.polynomList.put(0, -1.0);
        p2.polynomList.put(2, 1.0);
    }

    @Test
    public void testAddition() {
        Polynom res = new Polynom();
        res.polynomList.put(0, -6.0);
        res.polynomList.put(2, -1.0);
        res.polynomList.put(3, 1.0);

        assertEquals(Operations.addPoly(p1,p2).toString(), res.toString());
    }

    @Test
    public void testSubstraction() {
        Polynom res = new Polynom();
        res.polynomList.put(0, -4.0);
        res.polynomList.put(2, -3.0);
        res.polynomList.put(3, 1.0);

        assertEquals(Operations.substractPoly(p1,p2).toString(), res.toString());
    }

    @Test
    public void testMultiply() {
        Polynom res = new Polynom();
        res.polynomList.put(0, 5.0);
        res.polynomList.put(2, -3.0);
        res.polynomList.put(3, -1.0);
        res.polynomList.put(4, -2.0);
        res.polynomList.put(5, 1.0);

        assertEquals(Operations.multiplyPoly(p1,p2).toString(), res.toString());

    }

    @Test
    public void testDivision() {

        String res = Operations.dividePoly(p1, p2);
        assertTrue(res.equals("quotient is: -2+1x ; remainder is: -7+1x"));

    }

    @Test
    public void testDerivative() {
        Polynom res = new Polynom();
        res.polynomList.put(1, -4.0);
        res.polynomList.put(2, 3.0);

        assertEquals(Operations.derivativePoly(p1).toString(), res.toString());
    }

    @Test
    public void testIntegrate() {
        Polynom res = new Polynom();
        res.polynomList.put(1, -5.0);
        res.polynomList.put(3, -0.7);
        res.polynomList.put(4, 0.3);

        assertEquals(Operations.integratePoly(p1).toString(), res.toString());

    }

}
