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
public class NaveBS extends Nave {
    
    //constructor sobrecargado de Nave
    public NaveBS(String name){
        super(name);
    }

    //funcion abstracta sobrecargada para Nave de Detonacion Clase BS
    @Override
    public void aPorEl() {
        Agencia.getInstancia().BOOM();
    }
    
    //Nombre de Nave de Detonacion Clase BS
    @Override
    public String toString(){
        return "NaveBS{"+ getName()+"}";
    }
    
}
