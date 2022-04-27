/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Hilo extends Thread {

    Contador c;

    public Hilo(Contador c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.incremento();
    }

}
