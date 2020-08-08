/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.Controlador.aux;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author AndresFWilT
 */
public class Rey extends Ficha {

    int cantidad = 1;
    String img;
    ImageIcon Ficha;
    private int ancho = 80, alto = 80;
    private static int xIni, yIni, ContadorBoprimido;
    private static boolean [] Enroque = new boolean [2];
    private static boolean[][] FJ, FE, PosiblesMov, LA, aux, LineaAtaque;
    private String[][] FichasJ, FichasE, auxs;

    public Rey(int x, int y, boolean[][] f_j, boolean[][] f_e, String[][] fj, String[][] fe, int c, boolean[][] la) {
        super(x, y, f_j, f_e, fj, fe, c);
        this.xIni = x;
        this.yIni = y;
        this.FJ = f_j;
        this.FE = f_e;
        this.FichasJ = fj;
        this.FichasE = fe;
        this.ContadorBoprimido = c;
        this.LA = la;
    }

    public void AnalizarFicha() {
        ImpresionFJ();
        ImpresionLA();
        MovimientoSuperior();
        MovimientoSuperiorDerecho();
        MovimientoSuperiorIzquierdo();
        MovimientoDerecho();
        MovimientoIzquierdo();
        MovimientoInferior();
        MovimientoInferiorDerecho();
        MovimientoInferiorIzquierdo();
        ImpresionP();
    }

    private void MovimientoSuperior() {
        System.out.println("entro a Movimiento superior");
        if (xIni == 0 || LA[xIni - 1][yIni] == true) {
            System.out.println("no puedo mover arriba");
        } else {
            if (FJ[xIni - 1][yIni] == true) {
                System.out.println("no puedo mover arriba, pero cubro compañero");
                LineaAtaque[xIni - 1][yIni] = true;
            } else {
                PosiblesMov[xIni - 1][yIni] = true;
                LineaAtaque[xIni - 1][yIni] = true;
            }
        }
    }

    private void MovimientoSuperiorDerecho() {
        System.out.println("entro a Movimiento superior derecho");
        if (xIni == 0 || yIni == 7 || LA[xIni - 1][yIni + 1] == true) {
        } else {
            if (FJ[xIni - 1][yIni + 1] == true) {
                System.out.println("No puedo mover arriba a la derecha, pero cubro compañero");
                LineaAtaque[xIni - 1][yIni + 1] = true;
            } else {
                PosiblesMov[xIni - 1][yIni + 1] = true;
                LineaAtaque[xIni - 1][yIni + 1] = true;
            }
        }
    }

    private void MovimientoSuperiorIzquierdo() {
        System.out.println("entro a Movimiento superior izquierdo");
        if (xIni == 0 || yIni == 0 || LA[xIni - 1][yIni - 1] == true) {
            System.out.println("No puedo mover arriba a la derecha");
        } else {
            if (FJ[xIni - 1][yIni - 1] == true) {
                System.out.println("No puedo mover arriba a la derecha, pero cubro compañero");
                LineaAtaque[xIni - 1][yIni - 1] = true;
            } else {
                PosiblesMov[xIni - 1][yIni - 1] = true;
                LineaAtaque[xIni - 1][yIni - 1] = true;
            }
        }
    }

    private void MovimientoDerecho() {
        System.out.println("entro a Movimiento Derecho");
        if (yIni == 7 || LA[xIni][yIni + 1] == true) {
            System.out.println("No puedo mover a la derecha");
        } else {
            if (FJ[xIni][yIni + 1] == true) {
                System.out.println("No puedo mover a la derecha, pero cubro compañero");
                LineaAtaque[xIni][yIni + 1] = true;
            } else {
                PosiblesMov[xIni][yIni + 1] = true;
                LineaAtaque[xIni][yIni + 1] = true;
            }
        }
    }

    private void MovimientoIzquierdo() {
        System.out.println("entro a Movimiento Izquierdo");
        if (yIni == 0 || LA[xIni][yIni - 1] == true) {
            System.out.println("No puedo mover a la izquierda");
        } else {
            if (FJ[xIni][yIni - 1] == true) {
                System.out.println("No puedo mover a la izquierda, pero cubro compañero");
                LineaAtaque[xIni][yIni - 1] = true;
            } else {
                PosiblesMov[xIni][yIni - 1] = true;
                LineaAtaque[xIni][yIni - 1] = true;
            }
        }
    }

    private void MovimientoInferior() {
        System.out.println("entro a Movimiento Inferior");
        if (xIni == 7 || LA[xIni + 1][yIni] == true) {
            System.out.println("No puedo mover a la izquierda");
        } else {
            if (FJ[xIni + 1][yIni] == true) {
                System.out.println("No puedo mover abajo, pero cubro compañero");
                LineaAtaque[xIni + 1][yIni] = true;
            } else {
                PosiblesMov[xIni + 1][yIni] = true;
                LineaAtaque[xIni + 1][yIni] = true;
            }
        }
        if (xIni == 7 || yIni == 0 || LA[xIni + 1][yIni - 1] == true) {
            System.out.println("No puedo mover a la izquierda");
        } else {
            if (FJ[xIni + 1][yIni - 1] == true) {
                System.out.println("No puedo mover abajo, pero cubro compañero");
                LineaAtaque[xIni + 1][yIni - 1] = true;
            } else {
                PosiblesMov[xIni + 1][yIni - 1] = true;
                LineaAtaque[xIni + 1][yIni - 1] = true;
            }
        }
    }

    private void MovimientoInferiorDerecho() {
        System.out.println("entro a Movimiento inferior derecho");
        if (xIni == 7 || yIni == 0 || LA[xIni + 1][yIni - 1] == true) {
            System.out.println("No puedo mover a la izquierda");
        } else {
            if (FJ[xIni + 1][yIni - 1] == true) {
                System.out.println("No puedo mover abajo, pero cubro compañero");
                LineaAtaque[xIni + 1][yIni - 1] = true;
            } else {
                PosiblesMov[xIni + 1][yIni - 1] = true;
                LineaAtaque[xIni + 1][yIni - 1] = true;
            }
        }
    }

    private void MovimientoInferiorIzquierdo() {
        System.out.println("entro a Movimiento inferior izquierdo");
        if (xIni == 0 || yIni == 0 || LA[xIni - 1][yIni - 1] == true) {
            System.out.println("No puedo mover a la izquierda");
        } else {
            if (FJ[xIni - 1][yIni - 1] == true) {
                System.out.println("No puedo mover abajo, pero cubro compañero");
                LineaAtaque[xIni - 1][yIni - 1] = true;
            } else {
                PosiblesMov[xIni - 1][yIni - 1] = true;
                LineaAtaque[xIni - 1][yIni - 1] = true;
            }
        }
    }

    public boolean[][] RetornarPosiblesMov() {
        return PosiblesMov;
    }

    public boolean[][] RetornarLineaAtaque() {
        return LineaAtaque;
    }

    public void InicializarPosiblesMov() {
        LineaAtaque = new boolean[8][8];
        PosiblesMov = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                PosiblesMov[i][j] = false;
            }
        }
    }

    public ImageIcon ImagenFichaB() {
        img = "/imagenes/KB.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    public ImageIcon ImagenFichaN() {
        img = "/imagenes/KN.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    private void ImpresionLA() {
        System.out.println("Lineas de ataque enemigo en la clase rey: ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(LA[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private void ImpresionFJ() {
        System.out.println("Fichas JUGADOR EN LA CLASE REY: ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(FJ[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private void ImpresionP() {
        System.out.println("Posibles movimientos para el rey EN CLASE REY: ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(PosiblesMov[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void ReiniciarJugador() {
        aux = FJ;
        FJ = FE;
        FE = aux;
        auxs = FichasJ;
        FichasJ = FichasE;
        FichasE = auxs;
    }
}
