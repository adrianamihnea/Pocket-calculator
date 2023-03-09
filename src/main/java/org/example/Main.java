package org.example;

public class Main {
    public static void main(String[] args) {

        org.example.Polynom poly1 = new org.example.Polynom();
        poly1.polynomList.put(1, 5);
        poly1.polynomList.put(2, 3);
        poly1.polynomList.put(3, 4);

        org.example.Polynom poly2 = new org.example.Polynom();
        poly2.polynomList.put(1, 1);
        poly2.polynomList.put(2, 2);
        poly2.polynomList.put(3, 3);

        org.example.Polynom res = new org.example.Polynom();
        res = org.example.Operations.substractPoly(poly1, poly2);

//        for (Integer pow : res.polynomList.keySet()) {
//            System.out.println(res.polynomList.get(pow));
//        }

        GUI interf = new GUI();

    }
}