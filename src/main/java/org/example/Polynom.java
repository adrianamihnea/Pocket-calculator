package org.example;
import java.util.*;


public class Polynom implements List<T> {

    public Map<Integer, Double> polynomList;

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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
