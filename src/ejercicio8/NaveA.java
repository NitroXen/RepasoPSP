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
public class NaveA extends Nave {

    //constructor sobrecargado de Nave
    public NaveA(String name){
        super(name);
    }
    
    //funcion abstracta sobrecargada para Nave de Taladrado Clase A
    @Override
    public void aPorEl() {
        Agencia.getInstancia().taladrar();
    }
    
    // el nombre de la nave de taladrado Clase A
    @Override
    public String toString(){
        return "Nave A{" +getName()+ "}";
    }
}
