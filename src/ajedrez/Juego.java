/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import Interfaz.Usuario;
import Interfaz.Vista;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author AndresFWilT
 */
public class Juego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario iniciar = new Usuario();
        iniciar.setVisible(true);
        iniciar.setResizable(false);
    }

    public boolean Ganador() {

        return true;
    }

    public void SiguienteJugador() {

    }
}
