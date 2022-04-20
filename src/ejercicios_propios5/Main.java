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
public class Main {
    public static void main(String[] args) {
        Usuario[] user = new Usuario[5];
        
        for(int i =0;i<user.length;i++){
           user[i] = new Usuario("User"+i);
           user[i].start();
        }
        
    }
}
