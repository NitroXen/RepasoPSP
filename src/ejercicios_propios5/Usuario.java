/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios5;

/**
 *
 * @author Admin
 */
public class Usuario extends Personaje {

    boolean salir;

    public Usuario(String name) {
        super(name);
        salir = false;
    }

    @Override
    public void accion() {
        int i = 0;
        while (!salir) {
            System.out.println("Soy una persona lista en este programa: " + getName());
            
            i++;
            if (i > 2) {
                salir = true;
            }
            try{Thread.sleep(1000);}catch(InterruptedException ex){}
        }
        
    }

}
