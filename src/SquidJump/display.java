package SquidJump;

import SquidJump.SquidJump;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class display{

    public display() {
        JFrame w = new JFrame("Squid Jump");
        w.setResizable(false);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setLayout(new BorderLayout());

        w.add(new SquidJump(), BorderLayout.SOUTH);
        w.pack();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
        
    }
    public static void main(String[] args) {
        new display();
    }
}