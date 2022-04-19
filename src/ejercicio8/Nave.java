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
public abstract class Nave extends Thread {
    
    public Nave(String name){
        super(name);
    }
    
    public abstract void aPorEl();
    
    @Override
    public void run(){
        System.out.println(this + ": Despegando");
        while(Agencia.getInstancia().hayMeteoritos()){
            aPorEl();
        }
        System.out.println(this + ": Aterrizando");
    }
    
}
