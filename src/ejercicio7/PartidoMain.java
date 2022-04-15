/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PartidoMain {
    
    static final int NUM_EMPLEADOS = 3;
    
    public static void main(String[] args) {
        Bote b = new Bote();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        
        for(int i =0;i<NUM_EMPLEADOS;i++)listaEmpleados.add(new Empleado("E"+i, b));
        
        for(Empleado e: listaEmpleados)e.start();
        
        for(Empleado e: listaEmpleados)
            try{e.join();} catch(InterruptedException ex){}
        
        
        String resultadoPartido = Bote.getFormatoApuesta();
        System.out.println("Resultado Partido: "+resultadoPartido);
        
        ApuestaResultado apuestaGanadoras = b.getApuesta(resultadoPartido);
        int importeApuestaGanadoras = apuestaGanadoras.importe;
        int numApuestasGanadoras=apuestaGanadoras.numApuestas;
        System.out.printf("%d € a repartir entre %d apuestas\n",
                importeApuestaGanadoras,numApuestasGanadoras);
        System.out.println(b);
        System.out.println("total a repartir: "+b.getRecaudacion()+"€");
        System.out.println("Ganadores: ");
        for(Empleado e: listaEmpleados){
            ApuestaResultado apuestaGanadora = e.getApuestaGanadora(resultadoPartido);
            if(apuestaGanadora!=null){
                int apuestaDelEmpleado = apuestaGanadora.importe;
                int numApuestaDelEmpleado = apuestaGanadora.numApuestas;
                float porcentajeGananciaEmpleado = (float)apuestaDelEmpleado/importeApuestaGanadoras;
                float gananciaDelEmpleado = b.getRecaudacion()*porcentajeGananciaEmpleado;
                System.out.printf("%s aposto %d€ en %d apusta/s y gano %.2f€\n",
                        e.getName(),apuestaDelEmpleado,
                        numApuestaDelEmpleado,gananciaDelEmpleado);
            }
        }
        
    }
}
