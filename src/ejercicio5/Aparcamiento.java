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
   
    //Creamos un numero definido por el Main para crear un grupo de Plazas
    private Plaza[] plazas;
    
    public Aparcamiento(int numPlazas){
        plazas = new Plaza[numPlazas];
        
        for(int i = 0; i<numPlazas;i++){
            plazas[i] = new Plaza();
        }
    }
    
    //Un paseo por el array para comprobar si hay alguna plaza libre
    public Plaza getPlaza(){
        for(Plaza p: plazas){
            if(p.estaLibre()){
                return p;
            }
        }
        return null;
    }
    
    //metodo sincronizado para que entre el coche
    public synchronized void entraCoche(Coche c){
        Plaza plazaLibre;
        while((plazaLibre = getPlaza())==null){
            try{wait();}catch(InterruptedException ex){}
        }
        plazaLibre.inCoche(c);
    }
    
    //metodo sincronizado para que salga el coche
    public synchronized void saleCoche(Coche c){
        notify();
        for(Plaza p:plazas){
            if(p.getCoche()==c){
                p.outCoche();
            }
        }
    }
    
    
    
}
