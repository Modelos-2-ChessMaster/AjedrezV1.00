/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Interfaz.Vista;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author AndresFWilT
 */
public class Alfil extends Ficha {

    String img;
    ImageIcon Ficha;
    int ancho = 80, alto = 80;
    private static int xIni, yIni, ContadorBoprimido;
    private static boolean[][] FJ, FE, PosiblesMov,LineaAtaque;
    private String[][] FichasJ, FichasE;
    private int i = 0, j = 0;

    public Alfil(int x, int y, boolean[][] f_j, boolean[][] f_e, String[][] fj, String[][] fe, int c) {
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
        i = xIni;
        j = yIni;
        PosiblesMovLatDerUP();
        PosiblesMovLatDerDN();
        PosiblesMovLatIzqUP();
        PosiblesMovLatIzqDN();
    }

    private void PosiblesMovLatDerUP() {
        System.out.println("Entro a posibles movimientos Lateral DERECHO ARRIBA");
        while ((i != 0) && (j != 7)) {
            if (xIni == 0) {
                System.out.println("Estoy arriba");
                break;
            } else if (yIni == 7) {
                System.out.println("Estoy a la derecha");
                break;
            } else {
                i--;
                j++;
                if (FJ[i][j] == true) {
                    System.out.println("Encontre ficha jugador lateral derecho arriba, la cubro");
                    LineaAtaque[i][j] = true;
                    break;
                } else {
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                }
                if (FE[i][j] == true) {
                    System.out.println("Encontre ficha enemiga lateral derecho arriba");
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                    break;
                } else {
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                }
            }
        }
    }

    private void PosiblesMovLatDerDN() {
        i = xIni;
        j = yIni;
        System.out.println("Entro a posibles movimientos Lateral DERECHO ABAJO");
        while ((i != 7) && (j != 7)) {
            if (xIni == 7) {
                System.out.println("Estoy abajo");
                break;
            } else if (yIni == 7) {
                System.out.println("Estoy a la derecha");
                break;
            } else {
                i++;
                j++;
                if (FJ[i][j] == true) {
                    System.out.println("Encontre ficha jugador lateral derecho arriba, la cubro");
                    LineaAtaque[i][j] = true;
                    break;
                } else {
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                }
                if (FE[i][j] == true) {
                    System.out.println("Encontre ficha enemiga lateral derecho arriba");
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                    break;
                } else {
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                }
            }
        }
    }

    private void PosiblesMovLatIzqUP() {
        i = xIni;
        j = yIni;
        System.out.println("Entro a posibles movimientos Lateral IZQUIERDO ARRIBA");
        while ((i != 0) && (j != 0)) {
            if (xIni == 0) {
                System.out.println("Estoy arriba");
                break;
            } else if (yIni == 0) {
                System.out.println("Estoy a la izquierda");
                break;
            } else {
                i--;
                j--;
                if (FJ[i][j] == true) {
                    System.out.println("Encontre ficha jugador lateral izquierdo arriba, la cubro");
                    LineaAtaque[i][j] = true;
                    break;
                } else {
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                }
                if (FE[i][j] == true) {
                    System.out.println("Encontre ficha enemiga lateral izquierdo arriba");
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                    break;
                } else {
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                }
            }
        }
    }

    private void PosiblesMovLatIzqDN() {
        i = xIni;
        j = yIni;
        System.out.println("Entro a posibles movimientos Lateral IZQUIERDO ABAJO");
        while ((i != 7) && (j != 0)) {
            if (xIni == 7) {
                System.out.println("Estoy abajo");
                break;
            } else if (yIni == 0) {
                System.out.println("Estoy a la izquierda");
                break;
            } else {
                i++;
                j--;
                if (FJ[i][j] == true) {
                    System.out.println("Encontre ficha jugador lateral izquierdp abajo, la cubro");
                    LineaAtaque[i][j] = true;
                    break;
                } else {
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                }
                if (FE[i][j] == true) {
                    System.out.println("Encontre ficha enemiga lateral izquierdo abajo");
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                    break;
                } else {
                    PosiblesMov[i][j] = true;
                    LineaAtaque[i][j] = true;
                }
            }
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
    
    public boolean[][] RetornarLineaAtaque(){
        return LineaAtaque;
    }

    public ImageIcon ImagenFichaB() {
        img = "/imagenes/AB.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    public ImageIcon ImagenFichaN() {
        img = "/imagenes/AN.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

}
