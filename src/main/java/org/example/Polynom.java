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
        String coef = null;
        String power = null;
        String result = null;
        for (Integer pow : this.polynomList.keySet()) {
            //if(coef) coef = coef + "+";
            //res = this.polynomList.get(pow) + "x^" + pow;
            power = pow.toString();
            coef = this.polynomList.get(pow).toString();
            if(result != null && this.polynomList.get(pow) > 0)
                result =  result + "+";
            if(pow == 0) {
                result = result + coef;
            }
            else if (pow == 1) {
                result = result + coef + "x";
            }
            else {
                result = result + coef + "x^" + pow;
            }
        }

        return result.substring(4, result.length());
    }

}
