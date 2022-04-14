/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author Admin
 */
public class Oficina {
    
    //este atributo nos dice si llego el jefe
    private boolean llegada = false;
    
    
    //los saludos de los empleados (si no ha llegado el jefe se ponen a dormir, si no se despiertan)
    public synchronized void saludoEmpleado(Persona p){
        System.out.println(p.getNombre()+" Ha llegado");
        if(!llegada){
            System.out.println("ZZZZZZZZZZZZZZZZZZ");
            try{wait();}catch(InterruptedException ex){}
            System.out.println("Eh, A Trabajar");
        }else{
            System.out.println(p.getNombre()+": ya me pongo a trabajar");
        }
        
    }
    
    //cuando llega el jefe los saluda a todos
    public synchronized void saludoJefe(Persona p){
        System.out.println(p.getNombre()+" Ha llegado");
        llegada = true;
        notifyAll();
    }
    
}
