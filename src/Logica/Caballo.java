/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author AndresFWilT
 */
public class Caballo extends Ficha {

    int cantidad = 2;
    String img;
    ImageIcon Ficha;
    int ancho = 80, alto = 80;

    private static int xIni, yIni, ContadorBoprimido;
    private static boolean[][] FJ, FE, PosiblesMov, LineaAtaque;
    private String[][] FichasJ, FichasE;

    public Caballo(int x, int y, boolean[][] f_j, boolean[][] f_e, String[][] fj, String[][] fe, int c) {
        super(x, y, f_j, f_e, fj, fe, c);
        this.xIni = x;
        this.yIni = y;
        this.FJ = f_j;
        this.FE = f_e;
        this.FichasJ = fj;
        this.FichasE = fe;
        this.ContadorBoprimido = c;
    }

    public void AnalizarFicha() {
        PosiblesMovLDUP();
        PosiblesMovLDUPDER();
        PosiblesMovLDDNDER();
        PosiblesMovLDDN();
        PosiblesMovLIUP();
        PosiblesMovLIUPIZQ();
        PosiblesMovLIDNIZQ();
        PosiblesMovLIDN();
    }

    private void PosiblesMovLDUP() {
        System.out.println("Entro a movimiento L DERECHA Arriba");
        if (xIni == 0 || xIni == 1 || yIni == 7) {
            System.out.println("No puede hacer este movimiento");
        } else if (FJ[xIni - 2][yIni + 1] == true) {
            System.out.println("No puede hacer movimiento, pero cubro a mi compañero");
            LineaAtaque[xIni - 2][yIni + 1] = true;
        } else {
            PosiblesMov[xIni - 2][yIni + 1] = true;
        }
    }

    private void PosiblesMovLDUPDER() {
        System.out.println("Entro a movimiento L DERECHA Arriba derecha");
        if (yIni == 7 || yIni == 6 || xIni == 0) {
            System.out.println("No puede hacer este movimiento");
        } else if (FJ[xIni - 1][yIni + 2] == true) {
            System.out.println("No puede hacer movimiento, pero cubro a mi compañero");
            LineaAtaque[xIni - 1][yIni + 2] = true;
        } else {
            PosiblesMov[xIni - 1][yIni + 2] = true;
            LineaAtaque[xIni - 1][yIni + 2] = true;
        }
    }

    private void PosiblesMovLDDNDER() {
        System.out.println("Entro a movimiento L DERECHA abajo derecha");
        if (xIni == 6 || xIni == 7 || yIni == 7) {
            System.out.println("No puede hacer este movimiento");
        } else if (FJ[xIni + 2][yIni + 1] == true) {
            System.out.println("No puede hacer movimiento, pero cubro a mi compañero");
            LineaAtaque[xIni + 2][yIni + 1] = true;
        } else {
            PosiblesMov[xIni + 2][yIni + 1] = true;
            LineaAtaque[xIni + 2][yIni + 1] = true;
        }
    }

    private void PosiblesMovLDDN() {
        System.out.println("Entro a movimiento L DERECHA abajo");
        if (yIni == 6 || yIni == 7 || xIni == 7) {
            System.out.println("No puede hacer este movimiento");
        } else if (FJ[xIni + 1][yIni + 2] == true) {
            System.out.println("No puede hacer movimiento, pero cubro a mi compañero");
            LineaAtaque[xIni + 1][yIni + 1] = true;
        } else {
            PosiblesMov[xIni + 1][yIni + 2] = true;
            LineaAtaque[xIni + 1][yIni + 1] = true;
        }
    }

    private void PosiblesMovLIUP() {
        System.out.println("Entro a movimiento L IZQUIERDA Arriba");
        if (xIni == 0 || xIni == 1 || yIni == 0) {
            System.out.println("No puede hacer este movimiento");
        } else if (FJ[xIni - 2][yIni - 1] == true) {
            System.out.println("No puede hacer movimiento, pero cubro a mi compañero");
            LineaAtaque[xIni - 2][yIni - 1] = true;
        } else {
            PosiblesMov[xIni - 2][yIni - 1] = true;
            LineaAtaque[xIni - 2][yIni - 1] = true;
        }
    }

    private void PosiblesMovLIUPIZQ() {
        System.out.println("Entro a movimiento L IZQUIERDA Arriba izquierda");
        if (xIni == 0 || yIni == 1 || yIni == 0) {
            System.out.println("No puede hacer este movimiento");
        } else if (FJ[xIni - 1][yIni - 2] == true) {
            System.out.println("No puede hacer movimiento, pero cubro a mi compañero");
            LineaAtaque[xIni - 1][yIni - 2] = true;
        } else {
            PosiblesMov[xIni - 1][yIni - 2] = true;
            LineaAtaque[xIni - 1][yIni - 2] = true;
        }
    }

    private void PosiblesMovLIDNIZQ() {
        System.out.println("Entro a movimiento L IZQUIERDA abajo izquierda");
        if (yIni == 0 || yIni == 1 || xIni == 7) {
            System.out.println("No puede hacer este movimiento");
        } else if (FJ[xIni + 1][yIni - 2] == true) {
            System.out.println("No puede hacer movimiento, pero cubro a mi compañero");
            LineaAtaque[xIni + 1][yIni - 2] = true;
        } else {
            PosiblesMov[xIni + 1][yIni - 2] = true;
            LineaAtaque[xIni + 1][yIni - 2] = true;
        }
    }

    private void PosiblesMovLIDN() {
        System.out.println("Entro a movimiento L IZQUIERDA abajo");
        if (xIni == 6 || xIni == 7 || yIni == 0) {
            System.out.println("No puede hacer este movimiento");
        } else if (FJ[xIni + 2][yIni - 1] == true) {
            System.out.println("No puede hacer movimiento, pero cubro a mi compañero");
            LineaAtaque[xIni + 2][yIni - 1] = true;
        } else {
            PosiblesMov[xIni + 2][yIni - 1] = true;
            LineaAtaque[xIni + 2][yIni - 1] = true;
        }
    }

    public void InicializarPosiblesMov() {
        PosiblesMov = new boolean[8][8];
        LineaAtaque = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                PosiblesMov[i][j] = false;
                LineaAtaque[i][j] = false;
            }
        }
    }

    public boolean[][] RetornarPosiblesMov() {
        return PosiblesMov;
    }

    public boolean[][] RetornarLineaAtaque() {
        return LineaAtaque;
    }

    public ImageIcon ImagenFichaB() {
        img = "/imagenes/CB.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    public ImageIcon ImagenFichaN() {
        img = "/imagenes/CN.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

}
