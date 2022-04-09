/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

/**
 *
 * @author Admin
 */
public class Plaza {
    static int countPlazas = 0;
    
    private int numPlaza;
    Coche cocheAparcado = null;
    
    public Plaza(){
        numPlaza = ++countPlazas;
    }
    
    public Coche getCoche(){
        return cocheAparcado;
    }
    
    public void aparcarCoche(Coche c){
        cocheAparcado = c;
        System.out.println(c + " > "+this);
    }
    
    public void adiosCoche(){
        System.out.println(this+" Libre > "+cocheAparcado);
        cocheAparcado = null;
    }
    
    public boolean estaLibre(){
        return cocheAparcado == null;
    }
    
    @Override
    public String toString(){
        return "P"+numPlaza;
    }
    
}
