/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

/**
 *
 * @author Admin
 */
public class Integrante {

    private int sinFirmar;
    private static int num = 0;
    private int nombre;
    private final int maxFirmas;
    private int firmas;
    private Fans fan;
    
    public Integrante(int maxFirmas) {
        this.maxFirmas = maxFirmas;
        nombre= num++;
        firmas = 0;
        sinFirmar = 0;

    }
    
    public void inFan(Fans f){
        fan = f;
        System.out.println(f+">>"+this);
        if(firmas<maxFirmas){firmas++;
        System.out.println("Aqui tienes tu firma");
        }
        else{
            sinFirmar++;
            System.out.println("no puedo firmar mas");
        }
    }
    
    public void outFan(){
        System.out.println(this+">>"+fan+"\nAdios!!");
        fan = null;
    }
    
    public int getSinFirma(){
        return sinFirmar;
    }

    public Fans getFan(){
        return fan;
    }
    
    public int getFirma(){
        return firmas;
    }
    
    public boolean isDisponible(){
        return fan == null;
    }
    
    @Override
    public String toString(){
        return "Integrante "+ nombre;
    }
    
}
