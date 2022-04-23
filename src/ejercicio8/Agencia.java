/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Agencia {
    private static Agencia instancia = null;
    private final ArrayList<Meteorito> listaMeteoritos;
    
    //el constructor es privado para instanciarlo con un metodo estatico
    private Agencia(){listaMeteoritos = new ArrayList<>();}
    
    //declaracion de instancia estatico para inicializar la clase Agencia
    public static Agencia getInstancia(){
        if(instancia == null) instancia= new Agencia();
        return instancia;
    }
    
    //la agencia añade meteoritos a su base de datos tras la llegada a la tierra
    public void addMeteorito(Meteorito m){
        listaMeteoritos.add(m);
    }
    
    //Se comprueba que haya meteoritos
    public boolean hayMeteoritos(){
        return !listaMeteoritos.isEmpty();
    }
    
    //La agencia taladra meteoritos
    public void taladrar(){
        Meteorito m;
        synchronized(listaMeteoritos){
            if(listaMeteoritos.isEmpty())return;
            int posMeteorito = new Random().nextInt(listaMeteoritos.size());
            m = listaMeteoritos.get(posMeteorito);
        }
        m.taladrar();
    }
    
    //la agencia explota meteoritos
    public void BOOM(){
        synchronized(listaMeteoritos){
            if(listaMeteoritos.isEmpty())return;
            int posMeteorito = new Random().nextInt(listaMeteoritos.size());
            Meteorito m = listaMeteoritos.get(posMeteorito);
            if(m.boom()) listaMeteoritos.remove(m);
        }
    }
    
}
