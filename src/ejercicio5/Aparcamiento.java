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
public class Aparcamiento {
    private final int NUM_PLAZAS;
    
    private Plaza[] plazas;
    
    public Aparcamiento(int numPlazas){
        this.NUM_PLAZAS= numPlazas;
        plazas = new Plaza[numPlazas];
        for(int i = 0; i<plazas.length; i++){
            plazas[i] = new Plaza();
        }
    }
    
    public Plaza getPlazaLibre(){
        for(Plaza p: plazas){
            if(p.estaLibre()){
                return p;
            }
        }
        return null;
    }
    
    public synchronized void aparcar(Coche c){
        Plaza plazaLibre;
        while((plazaLibre = getPlazaLibre())==null){
            try{wait();}catch(InterruptedException ex){}
        }
        plazaLibre.aparcarCoche(c);
    }
    
    public synchronized void salir(Coche c){
        for(Plaza p : plazas){
            if(p.getCoche()== c){
                p.adiosCoche();
                break;
            }
        }
        notifyAll();
    }
    
    
}
