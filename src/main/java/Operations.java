package org.example;
public class Operations {

    static Polynom addPoly(Polynom p1, Polynom p2) {
        Polynom result =  new Polynom();
        for(Integer pow : p1.polynomList.keySet()) {
            Integer coef1 = p1.polynomList.get(pow);
            //coef1 = (coef1 == null ? 0 : coef1);
            Integer coef2 = p2.polynomList.get(pow);
            //coef2 = (coef2 == null ? 0 : coef2);
            result.polynomList.put(pow, coef1 + coef2);
        }
        return result;
    }

    static Polynom substractPoly(Polynom p1, Polynom p2) {
        Polynom result =  new Polynom();
        for(Integer pow : p1.polynomList.keySet()) {
            Integer coef1 = p1.polynomList.get(pow);
            //coef1 = (coef1 == null ? 0 : coef1);
            Integer coef2 = p2.polynomList.get(pow);
            //coef2 = (coef2 == null ? 0 : coef2);
            result.polynomList.put(pow, coef1 - coef2);
        }
        return result;
    }
}
