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
public class Reina extends Ficha {

    int cantidad = 1;
    String img;
    ImageIcon Ficha;
    int ancho = 80, alto = 80;

    private static int xIni, yIni, ContadorBoprimido;
    private boolean[][] FJ, FE, PosiblesMov, LineaAtaque;
    private String[][] FichasJ, FichasE;
    private int i, j;

    public Reina(int x, int y, boolean[][] f_j, boolean[][] f_e, String[][] fj, String[][] fe, int c) {
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
        System.out.println(i+ " "+ j);
        PosiblesMovArriba();
        PosiblesMovAbajo();
        PosiblesMovDer();
        PosiblesMovIzq();
        PosiblesMovLatDerUP();
        PosiblesMovLatDerDN();
        PosiblesMovLatIzqUP();
        PosiblesMovLatIzqDN();
        ImpresionLA();
    }

    private void PosiblesMovArriba() {
        System.out.println("Entro a posibles movimientos ARRIBA");
        while ((i != 0)) {
            if (xIni == 0) {
                System.out.println("Estoy arriba");
                break;
            } else {
                i--;
                if (FJ[i][yIni] == true) {
                    System.out.println("Encontre ficha jugador arriba, lo cubro");
                    LineaAtaque[i][yIni] = true;
                    break;
                } else {
                    PosiblesMov[i][yIni] = true;
                    LineaAtaque[i][yIni] = true;
                }
                if (FE[i][yIni] == true) {
                    System.out.println("Encontre ficha enemiga arriba");
                    PosiblesMov[i][yIni] = true;
                    LineaAtaque[i][yIni] = true;
                    break;
                } else {
                    PosiblesMov[i][yIni] = true;
                    LineaAtaque[i][yIni] = true;
                }
            }
        }
    }

    private void PosiblesMovDer() {
        i = xIni;
        j = yIni;
        System.out.println("Entro a posibles movimientos DERECHA");
        while ((j != 7)) {
            if (yIni == 7) {
                System.out.println("Estoy a la derecha");
                break;
            } else {
                j++;
                if (FJ[xIni][j] == true) {
                    System.out.println("Encontre ficha jugador derecha, lo cubro");
                    LineaAtaque[xIni][j] = true;
                    break;
                } else {
                    PosiblesMov[xIni][j] = true;
                    LineaAtaque[xIni][j] = true;
                }
                if (FE[xIni][j] == true) {
                    System.out.println("Encontre ficha enemiga derecha");
                    PosiblesMov[xIni][j] = true;
                    LineaAtaque[xIni][j] = true;
                    break;
                } else {
                    PosiblesMov[xIni][j] = true;
                    LineaAtaque[xIni][j] = true;
                }
            }
        }
    }

    private void PosiblesMovIzq() {
        i = xIni;
        j = yIni;
        System.out.println("Entro a posibles movimientos IZQUIERDA");
        while ((j != 0)) {
            if (yIni == 0) {
                System.out.println("Estoy a la izquierda");
                break;
            } else {
                j--;
                if (FJ[xIni][j] == true) {
                    System.out.println("Encontre ficha jugador izquierda, la cubro");
                    LineaAtaque[xIni][j] = true;
                    break;
                } else {
                    PosiblesMov[xIni][j] = true;
                    LineaAtaque[xIni][j] = true;
                }
                if (FE[xIni][j] == true) {
                    System.out.println("Encontre ficha enemiga izquierda");
                    PosiblesMov[xIni][j] = true;
                    LineaAtaque[xIni][j] = true;
                    break;
                } else {
                    PosiblesMov[xIni][j] = true;
                    LineaAtaque[xIni][j] = true;
                }
            }
        }
    }

    private void PosiblesMovAbajo() {
        i = xIni;
        j = yIni;
        System.out.println("Entro a posibles movimientos ABAJO");
        while ((i != 7)) {
            if (xIni == 7) {
                System.out.println("Estoy abajo");
                break;
            } else {
                i++;
                if (FJ[i][yIni] == true) {
                    System.out.println("Encontre ficha jugador abajo, la cubro");
                    LineaAtaque[i][yIni] = true;
                    break;
                } else {
                    PosiblesMov[i][yIni] = true;
                    LineaAtaque[i][yIni] = true;
                }
                if (FE[i][yIni] == true) {
                    System.out.println("Encontre ficha enemiga abajo");
                    PosiblesMov[i][yIni] = true;
                    LineaAtaque[i][yIni] = true;
                    break;
                } else {
                    PosiblesMov[i][yIni] = true;
                    LineaAtaque[i][yIni] = true;
                }
            }
        }
    }

    private void PosiblesMovLatDerUP() {
        i = xIni;
        j = yIni;
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
                    System.out.println(FJ[i][j]);
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

    public boolean[][] RetornarLineaAtaque() {
        return LineaAtaque;
    }

    public ImageIcon ImagenFichaB() {
        img = "/imagenes/QB.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    public ImageIcon ImagenFichaN() {
        img = "/imagenes/QN.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    private void ImpresionLA() {
        System.out.println("Linea de ataque en la clase Reina");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(LineaAtaque[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
