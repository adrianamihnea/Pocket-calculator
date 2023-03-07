package org.example;

public class Main {
    public static void main(String[] args) {

        Polynom poly1 = new Polynom();
        poly1.polynomList.put(1, 5);
        poly1.polynomList.put(2, 3);
        poly1.polynomList.put(3, 4);

        Polynom poly2 = new Polynom();
        poly2.polynomList.put(1, 1);
        poly2.polynomList.put(2, 2);
        poly2.polynomList.put(3, 3);

        Polynom res = new Polynom();
        res = Operations.substractPoly(poly1, poly2);

        for (Integer pow : res.polynomList.keySet()) {
            System.out.println(res.polynomList.get(pow));
        }

        GUI interf = new GUI();

    }
}