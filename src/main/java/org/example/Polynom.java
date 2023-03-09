package org.example;
import java.util.HashMap;
import java.util.Map;


public class Polynom {

    Map<Integer, Integer> polynomList;

    public Polynom() {
        // add string as parameter and use regex to split up the string into the map
        polynomList = new HashMap<>();
    }

    public void printPoly() {
        for (Integer pow : this.polynomList.keySet()) {
            System.out.println(pow + ";" + this.polynomList.get(pow));
        }
    }
    public String toString() {
        // not ok yet
        String res = null;
        for (Integer pow : this.polynomList.keySet()) {
            if(res) res = res + "+"
            res = this.polynomList.get(pow) + "x^" + pow;
        }
    }

}
