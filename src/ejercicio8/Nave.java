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
    
    //el constructor que sobrecarga el construtor de Thread para ponerle un nombre
    public Nave(String name){
        super(name);
    }
    
    //la funcion abstracta para Run()
    public abstract void aPorEl();
    
    
    //la funcion Sobrecargada Run() declarando por Agencia si hay meteoritos entonces ejecutar la funcion abstracta
    @Override
    public void run(){
        System.out.println(this + ": Despegando");
        while(Agencia.getInstancia().hayMeteoritos()){
            aPorEl();
        }
        System.out.println(this + ": Aterrizando");
    }
    
}
