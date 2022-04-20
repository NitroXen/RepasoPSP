/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Pizarra extends JFrame implements Runnable {

    private int x, y, dx = 1, dy = 1, radio = 10;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;

    private Thread t;
    
    public Pizarra() {
        this.setTitle("Animacion");
        this.setSize(WIDTH, HEIGHT);
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void inicio() {
        if (t == null) {
            t = new Thread(this, "Animacion");
            t.start();
        }
    }

    public void fin() {
        try {
            t.join();
        } catch (InterruptedException ex) {
        }

    }

    void mover() {
        x += dx;
        y += dy;
        if (x >= (WIDTH - radio) || x <= radio) {
            dx *= -1;
        }
        if (y >= (HEIGHT - radio) || y <= radio) {
            dy *= -1;
        }
        repaint();      //llama a update
    }

    public void paint(Graphics g) {
        super.paint(g);
        
        g.setColor(Color.yellow);
        g.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
    }

    @Override
    public void run() {
        while (true) {
            mover();
        }
    }

    public static void main(String[] args) {
        Pizarra p = new Pizarra();
        p.inicio();
    }

}
