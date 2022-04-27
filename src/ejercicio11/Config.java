/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

/**
 *
 * @author Admin
 */
public class Config {
    static final int PUERTO = 4999;
    static final String CMD_SALIR = "fin";
    static final String CMD_APAGAR = "shutdown";
    
    enum AutorizarConexion{ok,CredencialesIncorrectas,UsuarioYaConectado;}
}
