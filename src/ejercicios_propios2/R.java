/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios2;

/**
 *
 * @author Admin
 */
public class R {

    private int num;

    public R(int num) {

        this.num = num;
    }

    public synchronized void put() {
        notifyAll();
        num++;
        System.out.println(num);
    }
    
    public synchronized void get(){
        while(num<0){
            try{wait();}catch(InterruptedException ex){}
        }
        num--;
        System.out.println(num);
    }

}
