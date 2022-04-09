/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Votante extends Thread {
    
    private Random rand = new Random();
    
    private Partido[] part;
    
    public Votante(Partido[] part){
        this.part = part;
    }
    
    
    @Override
    public void run(){
        part[rand.nextInt(part.length)].incrementaVotos();
        try{Thread.sleep(rand.nextInt(100)+1);}catch(InterruptedException ex){}
    }
    
}
