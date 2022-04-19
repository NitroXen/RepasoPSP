/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

/**
 *
 * @author Admin
 */
public class Meteorito {
    int num;
    private boolean taladrando = false;
    
    public Meteorito(int num){
        this.num = num;
    } 
    
    public synchronized void taladrar(){
        if(taladrando) return;
        taladrando = true;
        System.out.println("Taladrdando" + this);
        try{wait();}catch(InterruptedException ex){}
    }
    
    public synchronized boolean boom(){
        if(!taladrando)return false;
        System.out.println(this + " encontrando Taladrado. Listo para explosionar");
        notify();
        return true;
    }
    
    @Override
    public String toString(){
        return "Meteorito "+num;
    }
}
