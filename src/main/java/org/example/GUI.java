package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI extends JPanel implements ActionListener {

    JTextField tf1, tf2, tf3;
    JButton b1, b2, b3, b4, b5, b6;
    public GUI() {
        JFrame frame = new JFrame ("Calculator polinomial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel4 = new JPanel();
        JLabel l1 = new JLabel ("Polinom 1");
        JLabel l2 = new JLabel ("Polinom 2");
        JLabel l3 = new JLabel ("Rezultat");
        tf1 = new JTextField();
        tf1.setColumns(20);
        tf2 = new JTextField();
        tf2.setColumns(20);
        tf3 = new JTextField();
        tf3.setColumns(20);
        panel1.add(l1);
        panel1.add(tf1);
        panel2.add(l2);
        panel2.add(tf2);
        panel4.add(l3);
        panel4.add(tf3);
        JPanel panel3 = new JPanel();
        b1 = new JButton("Adunare");
        b1.addActionListener(this);
        b2 = new JButton("Scadere");
        b2.addActionListener(this);
        b3 = new JButton("Inmultire");
        b3.addActionListener(this);
        b4 = new JButton("Impartire");
        b4.addActionListener(this);
        b5 = new JButton("Derivata");
        b5.addActionListener(this);b6 = new JButton("Integrala");
        b6.addActionListener(this);
        // if source == button 1 -> se face o anumita operatie
        panel3.add(b1);
        panel3.add(b2);
        panel3.add(b3);
        panel3.add(b4);
        panel3.add(b5);
        panel3.add(b6);
        panel3.setLayout(new GridLayout(3,2));
        JPanel p = new JPanel();
        p.add(panel1);
        p.add(panel2);
        p.add(panel4);
        p.add(panel3);
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        frame.setContentPane(p);
        frame.setVisible(true);

        tf1.setText("2x^2+4x^3");
        tf2.setText("5x^6+7x");
        setMapFromRegex(tf1);
        setMapFromRegex(tf2);
    }

    public org.example.Polynom setMapFromRegex(JTextField tf) {
        org.example.Polynom poly = null;
        String stringPoly = tf.getText();
        String polyPattern = "([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))";
        Pattern pattern = Pattern.compile(polyPattern);
        Matcher matcher = pattern.matcher(stringPoly);
        poly = new org.example.Polynom();
        int x=0;
        while (matcher.find()) {
            // coefAndPower[1] = power -> key
            // coefAndPower[0] = coefficient -> value
            String[] coefAndPower = new String[2];
            try {
                // matcher.group(1) - a group like 4x^2
                coefAndPower = matcher.group(1).split("x\\^?", 2);
                if(coefAndPower[1] == "")
                    coefAndPower[1] = "1";
                System.out.println(coefAndPower[0]);
                poly.polynomList.put(Integer.parseInt(coefAndPower[1]), Double.parseDouble(coefAndPower[0]));
            }
            catch (ArrayIndexOutOfBoundsException e) {
                poly.polynomList.put(Integer.parseInt("0"), Double.parseDouble(coefAndPower[0]));
            }
        }
        System.out.println("Polynom is: ");
        poly.printPoly();

        return poly;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Polynom poly1 = new Polynom();
        Polynom poly2 = new Polynom();

        poly1 = this.setMapFromRegex(tf1);
        poly2 = this.setMapFromRegex(tf2);

        Object source = e.getSource();

        if(source == b1) {
            String result = org.example.Operations.addPoly(poly1, poly2).toString();
            tf3.setText(result);
        }

        if(source == b2) {
            String result = org.example.Operations.substractPoly(poly1, poly2).toString();
            tf3.setText(result);
        }

        if(source == b3) {
            String result = org.example.Operations.multiplyPoly(poly1, poly2).toString();
            tf3.setText(result);
        }

        if(source == b4) {
            String result = org.example.Operations.dividePoly(poly1, poly2).toString();
            tf3.setText(result);
        }

        if(source == b5) {
            String result = org.example.Operations.derivativePoly(poly1).toString();
            tf3.setText(result);
        }

        if(source == b6) {
            String result = org.example.Operations.integratePoly(poly1).toString();
            tf3.setText(result);
        }
    }
}