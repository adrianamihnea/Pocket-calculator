package org.example;
import java.awt.*;
import java.util.concurrent.Flow;
import javax.swing.*;
import javax.swing.border.Border;

public class GUI extends JPanel {

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
        JTextField tf1 = new JTextField();
        tf1.setColumns(20);
        JTextField tf2 = new JTextField();
        tf2.setColumns(20);
        JTextField tf3 = new JTextField();
        tf3.setColumns(20);
        panel1.add(l1);
        panel1.add(tf1);
        panel2.add(l2);
        panel2.add(tf2);
        panel4.add(l3);
        panel4.add(tf3);
        JPanel panel3 = new JPanel();
        JButton b1 = new JButton("Adunare");
        JButton b2 = new JButton("Scadere");
        JButton b3 = new JButton("Inmultire");
        JButton b4 = new JButton("Impartire");
        JButton b5 = new JButton("Derivata");
        JButton b6 = new JButton("Integrala");
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
    }


}