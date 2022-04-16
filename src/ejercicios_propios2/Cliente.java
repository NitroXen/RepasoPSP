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
    
    public Cliente(String num,R r){
        super(num);
        this.r = r;
        
        rand = new Random();
    }
    
    @Override
    public void run(){
        int num = rand.nextInt(5)+1;
        
        for(int i =0; i<num;i++){
            System.out.print(getName()+"--");
            r.put();
        }
        try{Thread.sleep(500);}catch(InterruptedException ex){}
        for(int i =0; i<num;i++){
            System.out.print(getName()+"--");
            r.get();
        }
    }
    
}
