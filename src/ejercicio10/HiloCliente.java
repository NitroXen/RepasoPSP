/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.io.*;
import java.net.*;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class HiloCliente extends Thread {

    private Socket s;
    private Servidor ser;
    private boolean salir = false;
    DataInputStream in;
    DataOutputStream out;

    public HiloCliente(Socket s, Servidor ser) {
        this.s = s;
        this.ser = ser;
        try {
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
        }
    }

    public String fraseEasterEgg() {
        String[] loco = {"Si la locura es felicidad, ¡me declaro loco!",
            "No estoy loco, sólo que mi realidad es distinta a la tuya.", "Nunca pierdas tu muchosidad.",
            "Esto es imposible. Sombrerero loco: _Sólo si tú crees que lo es.", "En un mundo de locos, tener sentido no tiene sentido.",
            "Si conocieras al Tiempo tan bien como lo conozco yo, no hablarías de matarlo. ¡El Tiempo es todo un personaje!"};

        return loco[new Random().nextInt(loco.length)];
    }

    @Override
    public void run() {
        System.out.println("Usuario " + s.getInetAddress() + ": Conectado");
        try {
            while (!salir) {
                String texto = in.readUTF();
                switch (texto) {
                    case Config.CMD_SHUTDOWN:
                        ser.shutdown();
                        out.writeUTF("Servidor Apagado");
                        break;
                    case Config.CMD_FIN:
                        out.writeUTF(s.getInetAddress() + " Desconectado");
                        this.apagado();
                        break;
                    case Config.CMD_EASTEREGG:
                        out.writeUTF(this.fraseEasterEgg());
                        break;
                    default:
                        out.writeUTF(texto);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error en los mensajes: no tengo idea?!!?");
        }
    }

    public void apagado() throws IOException {
        salir = true;
        s.close();
        in.close();
        out.close();
    }

}
