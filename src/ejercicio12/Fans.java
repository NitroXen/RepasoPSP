/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

/**
 *
 * @author Admin
 */
public class Fans extends Thread {
    
    
    private static int cuenta =0;
    private int num;
    private Recinto recinto;
    
    public Fans( Recinto r){
        num = cuenta++;
        recinto = r;
    }
    
    @Override
    public void run(){
        recinto.fanIn(this);
        try{Thread.sleep(100);}catch(InterruptedException e){}
        recinto.fanOut(this);
    }
    
    
    
    @Override
    public String toString(){
        return "FAN "+num;
    }
    
}
