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
public class Empleado extends Persona {

    private Oficina off;
    
    public Empleado(String nombre, Oficina off){
        super(nombre);
        this.off = off;
    }
    

    @Override
    public void aCurrar() {
        off.saludoEmpleado(this);
    }
    
}
