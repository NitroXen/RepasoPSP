/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios2;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Cliente extends Thread {
    private R r;
    private Random rand;
    
    public Cliente(R r){
        this.r = r;
        
        rand = new Random();
    }
    
    @Override
    public void run(){
        for(int i =0; i<rand.nextInt(5)+1;i++){
            System.out.print(getName()+"--");
            r.put();
        }
        try{Thread.sleep(1000);}catch(InterruptedException ex){}
        for(int i =0; i<rand.nextInt(5)+1;i++){
            System.out.print(getName()+"--");
            r.get();
        }
    }
    
}
