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
    
    private Partido[] part;
    
    public Votante(Partido[] part){
        this.part = part;
    }
    
    @Override
    public void run(){
        part[new Random().nextInt(part.length)].incremento();
    }
    
    
    
}
