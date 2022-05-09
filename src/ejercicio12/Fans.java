/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Fans extends Thread {
    
    
    private static int cuenta =0;
    private int num;
    private Recinto recinto;
    private Integrante[] banda;
    
    public Fans(Recinto r){
        num = cuenta++;
        recinto = r;
    }
    
    public Fans(Integrante[] banda){
        this.banda = banda;
    }
    
    @Override
    public void run(){
        int i = new Random().nextInt(banda.length);
        banda[i].firma(this);
    }

    @Override
    public String toString(){
        return "FAN "+num;
    }
    
}
