import org.example.Operations;
import org.example.Polynom;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationsTest {

    static Polynom p1;
    static Polynom p2;
    @BeforeClass
    public static void initialisePolynomials() {
        p1 = new Polynom();
        p1.polynomList.put(2, 2.0);
        p1.polynomList.put(3, 4.0);

        p2 = new Polynom();
        p2.polynomList.put(6, 5.0);
        p2.polynomList.put(1, 7.0);
    }

    @Test
    public void testAddition() {
        Polynom res = new Polynom();
        res.polynomList.put(1, 7.0);
        res.polynomList.put(2, 2.0);
        res.polynomList.put(3, 4.0);
        res.polynomList.put(6, 5.0);

        assertEquals(Operations.addPoly(p1,p2).toString(), res.toString());
    }

    @Test
    public void testSubstraction() {
        Polynom res = new Polynom();
        res.polynomList.put(1, -7.0);
        res.polynomList.put(2, 2.0);
        res.polynomList.put(3, 4.0);
        res.polynomList.put(6, -5.0);

        assertEquals(Operations.substractPoly(p1,p2).toString(), res.toString());
    }

    @Test
    public void testMultiply() {
        Polynom res = new Polynom();
        res.polynomList.put(3, 14.0);
        res.polynomList.put(4, 28.0);
        res.polynomList.put(8, 10.0);
        res.polynomList.put(9, 20.0);

        assertEquals(Operations.multiplyPoly(p1,p2).toString(), res.toString());

    }

    @Test
    public void testDivision() {

    }

    @Test
    public void testDerivative() {
        Polynom res = new Polynom();
        res.polynomList.put(1, 4.0);
        res.polynomList.put(2, 12.0);

        assertEquals(Operations.derivativePoly(p1).toString(), res.toString());
    }

    @Test
    public void testIntegrate() {
        Polynom res = new Polynom();
        res.polynomList.put(3, 0.7);
        res.polynomList.put(4, 1.0);

        assertEquals(Operations.integratePoly(p1).toString(), res.toString());

    }
}
