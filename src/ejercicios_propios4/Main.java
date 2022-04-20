/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios4;

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args) {
        final int NUM_LIBROS = 200;
        final int NUM_CLIENTES = 50;
        int numVentas = 0;
        
        Cliente[] clientes = new Cliente[NUM_CLIENTES];
        
        for(int i =0;i<NUM_LIBROS;i++)Libreria.getInstancia().addLibro(new Libro("L"+i));
        
        for(int i=0;i<NUM_CLIENTES;i++){
            clientes[i] = new Cliente("C"+i);
            clientes[i].start();
            numVentas++;
        }
        
        
        for(Cliente c: clientes)try{c.join();}catch(InterruptedException ex){}
        
        System.out.println("Num de Libros en total: "+ Libreria.getInstancia().numLibrosEnLibreria());
        System.out.println("Num de Ventas: " + numVentas);
        System.out.printf("Num de ganancias: %.2f €\n",Libreria.getInstancia().getGanancias());
    }
    
}
