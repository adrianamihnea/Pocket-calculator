package org.example;

import java.util.Collections;

public class Operations {

    public static Polynom addPoly(Polynom p1, Polynom p2) {
        Polynom result =  new Polynom();
        for(Integer pow = 1; pow < 50; pow++) {
            Double coef1 = p1.polynomList.get(pow);
            coef1 = (coef1 == null ? 0 : coef1);
            Double coef2 = p2.polynomList.get(pow);
            coef2 = (coef2 == null ? 0 : coef2);
            if(coef1 + coef2 != 0)
                result.polynomList.put(pow, coef1 + coef2);
        }
        return result;
    }

    public static Polynom substractPoly(Polynom p1, Polynom p2) {
        Polynom result =  new Polynom();
        for(Integer pow = 1; pow < 50; pow++) {
            Double coef1 = p1.polynomList.get(pow);
            coef1 = (coef1 == null ? 0 : coef1);
            Double coef2 = p2.polynomList.get(pow);
            coef2 = (coef2 == null ? 0 : coef2);
            if(coef1 - coef2 != 0)
                result.polynomList.put(pow, coef1 - coef2);
        }
        return result;
    }

    public static Polynom multiplyPoly(Polynom p1, Polynom p2) {
        Polynom result =  new Polynom();
        for(Integer pow1 : p1.polynomList.keySet()) {
            for(Integer pow2 : p2.polynomList.keySet()) {

                Double coef1 = p1.polynomList.get(pow1);
                coef1 = (coef1 == null ? 0 : coef1);
                Double coef2 = p2.polynomList.get(pow2);
                coef2 = (coef2 == null ? 0 : coef2);

                if (coef1 * coef2 != 0) {
                    try {
                        result.polynomList.put(pow1 + pow2, (Double)result.polynomList.get(pow1 + pow2) + coef1 * coef2);
                    }
                    catch (NullPointerException e) {
                        result.polynomList.put(pow1 + pow2, coef1 * coef2);
                    }
                }
            }
        }
        return result;
    }

    static Polynom dividePoly(Polynom p, Polynom q) {

        Collections.sort(p.polynomList, Collections.reverseOrder());
        Collections.sort(q.polynomList, Collections.reverseOrder());


        for(Integer degree : p.polynomList.keySet().rever) {
            System.out.println(degree);
        }
        return p;

//        Polynom q = new Polynom();
//        Polynom t = new Polynom();
//        if (p2.polynomList != null) {
//            q.polynomList.put(0, (double) 0);
//            Polynom r = p1;
//            Integer degR = (Integer) p1.polynomList.keySet().toArray()[r.polynomList.size()-1];
//            Integer degP2 = (Integer) p2.polynomList.keySet().toArray()[p2.polynomList.size()-1];
//            //System.out.println(degR + " " + degP2);
//            Double coefR = r.polynomList.get(degR);
//            //if(coefR == null) coefR=0d;
//            Double coefP2 = p2.polynomList.get(degP2);
//            //if(coefP2 == null) coefP2=0d;
//            //System.out.println(coefR + " " + coefP2);
//
//            // to do : resolve null pointer exception here
//            while (r.polynomList.isEmpty() == false && degR >= degP2) {
//                Double term = coefR / coefP2;
//                t.polynomList.put(degR-degP2, term);
//                q = Operations.multiplyPoly(t, p2);
//                r = Operations.substractPoly(r, q);
//
//            }
//       }
//        return q;
    }

    public static Polynom derivativePoly(Polynom p) {
        Polynom result =  new Polynom();
        for(Integer pow : p.polynomList.keySet()) {
            if(pow == 0) {
                result.polynomList.remove(pow);
            }
            else {
                result.polynomList.put(pow-1, p.polynomList.get(pow) * pow);
            }
        }
        return result;
    }

    public static Polynom integratePoly(Polynom p) {
        Polynom result =  new Polynom();
        for(Integer pow : p.polynomList.keySet()) {
            double coef = p.polynomList.get(pow) / (pow+1);
            coef = (double)Math.round(coef * 10d) / 10d;
            result.polynomList.put(pow + 1, coef);
        }
        return result;
    }

}
