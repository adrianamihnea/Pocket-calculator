package org.example;
import java.util.*;


public class Polynom {

    public Map<Integer, Double> polynomList;

    public Polynom() {
        polynomList = new HashMap<>();
    }

    public void printPoly() {
        for (Integer pow : this.polynomList.keySet()) {
            System.out.println(pow + ";" + this.polynomList.get(pow));
        }
    }
    public String toString() {
        String coef = null;
        String power = null;
        String result = null;
        for (Integer pow : this.polynomList.keySet()) {
            power = pow.toString();
            coef = this.polynomList.get(pow).toString();
            if(coef.substring(coef.length()-2,coef.length()).equals(".0")) {
                coef = coef.substring(0, coef.length()-2);
            }
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
