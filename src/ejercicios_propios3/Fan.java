/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios3;

/**
 *
 * @author Admin
 */
public class Fan {
    
    boolean firmado;
    String nomFirma;
    
    public Fan(){
        firmado = false;
    }
    
    public void preparado(Artista a){
        nomFirma = a.getName();
        firmado = true;
    }
    
    @Override
    public String toString(){
        if(firmado){
            return nomFirma +" me ha firmado el disco";
        }else{
            return "no me dio tiempo";
        }
    }
    
}
