package org.example;
public class Operations {

    static Polynom addPoly(Polynom p1, Polynom p2) {
        Polynom result =  new Polynom();
        for(Integer pow = 1; pow < 50; pow++) {
            Integer coef1 = p1.polynomList.get(pow);
            coef1 = (coef1 == null ? 0 : coef1);
            Integer coef2 = p2.polynomList.get(pow);
            coef2 = (coef2 == null ? 0 : coef2);
            if(coef1 + coef2 != 0)
                result.polynomList.put(pow, coef1 + coef2);
        }
        return result;
    }

    static Polynom substractPoly(Polynom p1, Polynom p2) {
        Polynom result =  new Polynom();
        for(Integer pow = 1; pow < 50; pow++) {
            Integer coef1 = p1.polynomList.get(pow);
            coef1 = (coef1 == null ? 0 : coef1);
            Integer coef2 = p2.polynomList.get(pow);
            coef2 = (coef2 == null ? 0 : coef2);
            if(coef1 - coef2 != 0)
                result.polynomList.put(pow, coef1 - coef2);
        }
        return result;
    }

    static Polynom multiplyPoly(Polynom p1, Polynom p2) {
        Polynom result =  new Polynom();
        for(Integer pow1 : p1.polynomList.keySet()) {
            for(Integer pow2 : p2.polynomList.keySet()) {

                Integer coef1 = p1.polynomList.get(pow1);
                coef1 = (coef1 == null ? 0 : coef1);
                Integer coef2 = p2.polynomList.get(pow2);
                coef2 = (coef2 == null ? 0 : coef2);

                if (coef1 * coef2 != 0) {
                    try {
                        result.polynomList.put(pow1 + pow2, (Integer)result.polynomList.get(pow1 + pow2) + coef1 * coef2);
                    }
                    catch (NullPointerException e) {
                        result.polynomList.put(pow1 + pow2, coef1 * coef2);
                    }
                }
            }
        }
        return result;
    }

    static Polynom dividePoly(Polynom p1, Polynom p2) {
        Polynom q = new Polynom();
        if (p2.polynomList != null) {
            q.polynomList.put(0, 0);
            Polynom r = new Polynom();
            r = p1;
            Polynom t = new Polynom();

            Integer degR = r.polynomList.size();
            Integer degP2 = p2.polynomList.size();
            Integer coefR = r.polynomList.get(degR);
            Integer coefP2 = r.polynomList.get(degP2);

            // to do : resolve null pointe rexception here
            while (r.polynomList != null && r.polynomList.get(degR) > p2.polynomList.get(degP2)){
                t.polynomList.put(0, coefR / coefP2);
                q = Operations.addPoly(q, t);
                r = Operations.substractPoly(r, Operations.multiplyPoly(t, p2));
            }
        }
        return q;
    }

    static Polynom derivativePoly (Polynom p) {
        Polynom result =  new Polynom();
        for(Integer pow : p.polynomList.keySet()) {
            if(pow == 0) {
                result.polynomList.remove(pow);
            }
            else {
                result.polynomList.put(pow-1, p.polynomList.get(pow));
            }
        }
        return result;
    }

    static Polynom integratePoly (Polynom p) {
        Polynom result =  new Polynom();
        for(Integer pow : p.polynomList.keySet()) {
            // to do : list {numitor, numarator} + supraincarca metoda toString in this case
            Integer coef = p.polynomList.get(pow) / pow;
            result.polynomList.put(pow+1, coef);
        }
        return result;
    }

}
