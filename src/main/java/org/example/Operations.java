package org.example;

import java.util.TreeMap;

public class Operations {

    public static Polynom addPoly(Polynom p1, Polynom p2) {
        Polynom result =  new Polynom();
        for(Integer pow = 0; pow < 50; pow++) {
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
        for(Integer pow = 0; pow < 50; pow++) {
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

    public static String dividePoly(Polynom p, Polynom q) {

        Polynom quotient = new Polynom();
        Polynom remainder = new Polynom();

        TreeMap<Integer, Double> polyP = new TreeMap<>();
        System.out.println(p.polynomList);
        polyP.putAll(p.polynomList);
        TreeMap<Integer, Double> polyQ = new TreeMap<>();
        polyQ.putAll(q.polynomList);

        System.out.println(polyP);
        System.out.println(polyQ);
        while (polyP.lastKey() >= polyQ.lastKey()) {

            Integer key = Integer.parseInt(polyP.lastKey().toString()) - Integer.parseInt(polyQ.lastKey().toString());
            Double coefficient = Double.parseDouble(polyP.get(polyP.lastKey()).toString()) /
                    Double.parseDouble(polyQ.get(polyQ.lastKey()).toString());
            Polynom monomial = new Polynom();
            monomial.polynomList.put(key, coefficient);
            quotient.polynomList.put(key, coefficient);

            remainder = Operations.multiplyPoly(monomial, q);
            monomial.polynomList.clear();
            remainder = Operations.substractPoly(p, remainder);

            p = remainder;
            polyP.clear();
            polyP.putAll(p.polynomList);
            System.out.println(p);
        }

        return "quotient is: " + quotient + " ; remainder is: " + remainder;

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
