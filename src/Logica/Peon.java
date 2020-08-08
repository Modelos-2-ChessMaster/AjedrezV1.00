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
public class Peon extends Ficha {

    int cantidad = 8;
    String img;
    ImageIcon Ficha;
    int ancho = 80, alto = 80;

    private static int xIni, yIni, ContadorBoprimido;
    private boolean[][] FJ, FE, PosiblesMov, LineaAtaque;
    private String[][] FichasJ, FichasE;
    private boolean[] PeonesJ1 = new boolean [8],PeonesJ2 = new boolean [8] ;

    public Peon(int x, int y, boolean[][] f_j, boolean[][] f_e, String[][] fj, String[][] fe, boolean[] pj1, boolean[] pj2, int c) {
        super(x, y, f_j, f_e, fj, fe, c);
        this.xIni = x;
        this.yIni = y;
        this.FJ = f_j;
        this.FE = f_e;
        this.FichasJ = fj;
        this.FichasE = fe;
        this.PeonesJ1 = pj1;
        this.PeonesJ2 = pj2;
        this.ContadorBoprimido = c;
        System.out.println(ContadorBoprimido);
    }

    public void AnalizarFicha() { //Metodo que determina cual jugador movio peon
        System.out.println(xIni + "" + yIni);
        if (ContadorBoprimido == 1 || (ContadorBoprimido - 1) % 4 == 0) { //Para primer jugador
            System.out.println("Entro a PEON primer jugador");
            if (yIni + 1 == 8) {        //Determina si Peon esta en borde derecho
                if (PeonesJ1[yIni] == true) {
                    PeonesJ1[yIni] = false;
                    System.out.println("Entro a EL METODO Casos especiales der");
                    CalcularMovimientosEspecialDerJ1();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO der simple");
                    CalcularMovimientosDerJ1();
                    ImpresionArreglos();
                }
            } else if (yIni - 1 == -1) {        //Determina si Peon esta en borde Izquierdo
                if (PeonesJ1[yIni] == true) {
                    PeonesJ1[yIni] = false;
                    System.out.println("Entro a EL METODO Casos especiales izq");
                    CalcularMovimientosEspecialIzqJ1();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO izq simple");
                    CalcularMovimientosIzqJ1();
                    ImpresionArreglos();
                }
            } else {
                if (PeonesJ1[yIni] == true) {
                    PeonesJ1[yIni] = false;
                    System.out.println("Entro a EL METODO Casos especiales simple");
                    CalcularMovimientosEspecialJ1();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO Casos simple");
                    CalcularMovimientosJ1();
                    ImpresionArreglos();
                }
            }
        } else {    //Para segundo jugador
            System.out.println("Entro a PEON segundo jugador");
            if (yIni + 1 == 8) {        //Determina si Peon esta en borde derecho
                if (PeonesJ2[yIni] == true) {
                    PeonesJ2[yIni] = false;
                    System.out.println("Entro a EL METODO Casos especiales Der");
                    CalcularMovimientosEspecialDerJ2();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO Casos sencillos Der");
                    CalcularMovimientosDerJ2();
                    ImpresionArreglos();
                }
            } else if (yIni - 1 == -1) {        //Determina si Peon esta en borde Izquierdo
                if (PeonesJ2[yIni] == true) {
                    PeonesJ2[yIni] = false;
                    System.out.println("Entro a EL METODO Casos especiales Izq");
                    CalcularMovimientosEspecialIzqJ2();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO Casos sencillos Izq");
                    CalcularMovimientosIzqJ2();
                    ImpresionArreglos();
                }
            } else {
                if (PeonesJ2[yIni] == true) {
                    PeonesJ2[yIni] = false;
                    System.out.println("Entro a EL METODO Casos especiales simple");
                    CalcularMovimientosEspecialJ2();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO Casos simple");
                    CalcularMovimientosJ2();
                    ImpresionArreglos();
                }
            }
        }
    }
    
    public void AnalizarFichas(boolean [] p1, boolean [] p2) { //Metodo que determina cual jugador movio peon
        boolean [] P1 =p1;
        boolean [] P2 = p2;
        System.out.println(xIni + "" + yIni);
        if (ContadorBoprimido == 1 || (ContadorBoprimido - 1) % 4 == 0) { //Para primer jugador
            System.out.println("Entro a PEON primer jugador");
            if (yIni + 1 == 8) {        //Determina si Peon esta en borde derecho
                if (p1[yIni] == true) {
                    System.out.println("Entro a EL METODO Casos especiales der");
                    CalcularMovimientosEspecialDerJ1();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO der simple");
                    CalcularMovimientosDerJ1();
                    ImpresionArreglos();
                }
            } else if (yIni - 1 == -1) {        //Determina si Peon esta en borde Izquierdo
                if (p1[yIni] == true) {
                    System.out.println("Entro a EL METODO Casos especiales izq");
                    CalcularMovimientosEspecialIzqJ1();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO izq simple");
                    CalcularMovimientosIzqJ1();
                    ImpresionArreglos();
                }
            } else {
                if (p1[yIni] == true) {
                    System.out.println("Entro a EL METODO Casos especiales simple");
                    CalcularMovimientosEspecialJ1();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO Casos simple");
                    CalcularMovimientosJ1();
                    ImpresionArreglos();
                }
            }
        } else {    //Para segundo jugador
            System.out.println("Entro a PEON segundo jugador");
            if (yIni + 1 == 8) {        //Determina si Peon esta en borde derecho
                if (p2[yIni] == true) {
                    System.out.println("Entro a EL METODO Casos especiales Der");
                    CalcularMovimientosEspecialDerJ2();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO Casos sencillos Der");
                    CalcularMovimientosDerJ2();
                    ImpresionArreglos();
                }
            } else if (yIni - 1 == -1) {        //Determina si Peon esta en borde Izquierdo
                if (p2[yIni] == true) {
                    System.out.println("Entro a EL METODO Casos especiales Izq");
                    CalcularMovimientosEspecialIzqJ2();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO Casos sencillos Izq");
                    CalcularMovimientosIzqJ2();
                    ImpresionArreglos();
                }
            } else {
                if (p2[yIni] == true) {
                    System.out.println("Entro a EL METODO Casos especiales simple");
                    CalcularMovimientosEspecialJ2();
                    ImpresionArreglos();
                } else {
                    System.out.println("Entro a EL METODO Casos simple");
                    CalcularMovimientosJ2();
                    ImpresionArreglos();
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

    private void CalcularMovimientosEspecialJ1() {  //Casos especiales J1, (nunca ha movido el peon)
        if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == true
                && ((FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true)) == false && ((FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == false)) { //caso E1, puede mover a los 4 lugares
            System.out.println("Entro a casos especiales simples 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente 
            PosiblesMov[xIni - 2][yIni] = true;          //sete pos 2 enfrete ]
            if (FJ[xIni - 1][yIni - 1] == false) {
                LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
            } else {
                LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
            }
            if (FJ[xIni - 1][yIni + 1] == false) {
                LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho linea Ataque
            } else {
                LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho linea Ataque
            }
        } else if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == true
                && ((FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true)) == false && ((FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == true)) { //caso E2, 2 enfrente ocupado
            System.out.println("Entro a casos especiales simples 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente 
            PosiblesMov[xIni - 2][yIni] = false;          //sete pos 2 enfrete 
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == false
                && ((FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == false) { //caso E3, lateral derecho ocupado
            System.out.println("Entro a casos especiales simples 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente 
            PosiblesMov[xIni - 2][yIni] = true;          //sete pos 2 enfrete 
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == true
                && ((FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == false) {//caso E4, lateral izquierdo ocupado
            System.out.println("Entro a casos especiales simples 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente 
            PosiblesMov[xIni - 2][yIni] = true;          //sete pos 2 enfrete 
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == false
                && ((FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) && ((FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == false)) {//caso E5, laterales ocupados ahora pasan casos comunes
            System.out.println("Entro a casos especiales simples 5");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente 
            PosiblesMov[xIni - 2][yIni] = true;          //sete pos 2 enfrete 
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso 1, puede mover a los 3 lugares
            System.out.println("Entro a casos simples 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso 2, puede mover a 2 lugares, al frente y derecha
            System.out.println("Entro a casos simples 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso 3, puede mover a 2 lugares, laterales
            System.out.println("Entro a casos simples 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso 4, puede mover a 2 lugares, al frente y izquierda
            System.out.println("Entro a casos simples 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso 5, puede mover al frente
            System.out.println("Entro a casos simples 5");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso 6, puede mover derecha
            System.out.println("Entro a casos simples 6");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso 7, puede mover izquierda
            System.out.println("Entro a casos simples 7");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso 8, No puede mover
            System.out.println("Entro a casos simples 8");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        }
    }

    private void CalcularMovimientosJ1() { //caso jugador parte inferior
        if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso 1, puede mover a los 3 lugares
            System.out.println("Entro a casos simples 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso 2, puede mover a 2 lugares, al frente y derecha
            System.out.println("Entro a casos simples 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso 3, puede mover a 2 lugares, laterales
            System.out.println("Entro a casos simples 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso 4, puede mover a 2 lugares, al frente y izquierda
            System.out.println("Entro a casos simples 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso 5, puede mover al frente
            System.out.println("Entro a casos simples 5");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso 6, puede mover derecha
            System.out.println("Entro a casos simples 6");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == true && FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso 7, puede mover izquierda
            System.out.println("Entro a casos simples 7");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        } else if (FE[xIni - 1][yIni - 1] == false && FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso 8, No puede mover
            System.out.println("Entro a casos simples 8");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos enfrente
            LineaAtaque[xIni - 1][yIni - 1] = true;
            LineaAtaque[xIni - 1][yIni + 1] = true;
        }
    }

    private void CalcularMovimientosEspecialIzqJ1() {
        if (FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false
                && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == false) { //caso ED1, puede mover a los 3 lugares
            System.out.println("Entro a casos Especiales iz1 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni - 2][yIni] = true;         //setea pos 2 abajo
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false
                && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == false) { //caso ED2, puede mover 2 alfrente y alfrente
            System.out.println("Entro a casos Especiales izq 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni - 2][yIni] = true;         //setea pos 2 abajo
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false
                && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == true) { //caso ED3, puede mover izq y alfrente
            System.out.println("Entro a casos Especiales izq 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni - 2][yIni] = false;         //setea pos 2 abajo
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false
                && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == true) { //caso ED4, puede mover al frente
            System.out.println("Entro a casos Especiales izq 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni - 2][yIni] = false;         //setea pos 2 abajo
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso D1, Puede mover a los dos lados
            System.out.println("Entro a casos simples izq 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso D2, Puede mover alfrente
            System.out.println("Entro a casos simples izq 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso D3, Puede mover a izquierda
            System.out.println("Entro a casos simples izq 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso D4, No puede mover
            System.out.println("Entro a casos simples izq 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        }
    }

    private void CalcularMovimientosIzqJ1() {
        if (FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso D1, Puede mover a los dos lados
            System.out.println("Entro a casos simples izq 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso D2, Puede mover alfrente
            System.out.println("Entro a casos simples izq 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso D3, Puede mover a izquierda
            System.out.println("Entro a casos simples izq 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        } else if (FE[xIni - 1][yIni + 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso D4, No puede mover
            System.out.println("Entro a casos simples izq 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni + 1] = false;     //setea lateral derecho 
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni + 1] = true;     //setea lateral derecho 
        }
    }

    private void CalcularMovimientosEspecialDerJ1() { //Movimientos para el peon que inica en el lado derecho para el J1
        if (FE[xIni - 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false
                && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == false) { //caso ED1, puede mover a los 3 lugares
            System.out.println("Entro a casos Especiales DER 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni - 2][yIni] = true;         //setea pos 2 abajo
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false
                && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == false) { //caso ED2, puede mover 2 alfrente y alfrente
            System.out.println("Entro a casos Especiales DER 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni - 2][yIni] = true;         //setea pos 2 abajo
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false
                && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == true) { //caso ED3, puede mover izq y alfrente
            System.out.println("Entro a casos Especiales DER 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni - 2][yIni] = false;         //setea pos 2 abajo
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false
                && (FE[xIni - 2][yIni] == true || FJ[xIni - 2][yIni] == true) == true) { //caso ED4, puede mover al frente
            System.out.println("Entro a casos Especiales DER 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni - 2][yIni] = false;         //setea pos 2 abajo
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso D1, Puede mover a los dos lados
            System.out.println("Entro a casos simples DER 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso D2, Puede mover alfrente
            System.out.println("Entro a casos simples DER 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso D3, Puede mover a izquierda
            System.out.println("Entro a casos simples DER 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos abajo
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso D4, No puede mover
            System.out.println("Entro a casos simples DER 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        }
    }

    private void CalcularMovimientosDerJ1() { //Movimientos para el peon que este en el lado derecho para el J1
        if (FE[xIni - 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso D1, Puede mover a los dos lados
            System.out.println("Entro a casos simples DER 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == false) { //caso D2, Puede mover alfrente
            System.out.println("Entro a casos simples DER 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso D3, Puede mover a izquierda
            System.out.println("Entro a casos simples DER 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos abajo
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        } else if (FE[xIni - 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni - 1][yIni] == true) == true) { //caso D4, No puede mover
            System.out.println("Entro a casos simples DER 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni - 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni - 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni - 1][yIni - 1] = true;     //setea lateral izquierda linea ataque
        }
    }

    private void CalcularMovimientosEspecialJ2() {
        if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == true
                && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == false) { //caso E1, puede mover a los 4 lugares
            System.out.println("Entro a casos especiales simples 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = true;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == true
                && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == true) { //caso E2,  2 abajo bloq
            System.out.println("Entro a casos especiales simples 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = false;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == false
                && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == false) { //caso E3,derecha bloq
            System.out.println("Entro a casos especiales simples 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = true;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == true
                && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == false) { //caso E4, izq bloq
            System.out.println("Entro a casos especiales simples 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = true;          //sete pos 2 abajo
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == false
                && (FE[xIni + 1][yIni] == true | FJ[xIni + 1][yIni] == true) == false && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == false) { //caso E5, laterales bloq
            System.out.println("Entro a casos especiales simples 5");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = true;          //sete pos 2 abajo
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso 1, puede mover a los 3 lugares
            System.out.println("Entro a casos simples 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso 2, puede mover a 2 lugares, abajo y derecha
            System.out.println("Entro a casos simples 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso 3, puede mover a 2 lugares, laterales
            System.out.println("Entro a casos simples 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso 4, puede mover a 2 lugares, abajo y izquierda
            System.out.println("Entro a casos simples 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso 5, puede mover abajo
            System.out.println("Entro a casos simples 5");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso 6, puede mover derecha
            System.out.println("Entro a casos simples 6");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso 7, puede mover izquierda
            System.out.println("Entro a casos simples 7");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso 8, No puede mover
            System.out.println("Entro a casos simples 8");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        }
    }

    private void CalcularMovimientosJ2() { //Caso jugador parte superior
        if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso 1, puede mover a los 3 lugares
            System.out.println("Entro a casos simples 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso 2, puede mover a 2 lugares, abajo y derecha
            System.out.println("Entro a casos simples 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso 3, puede mover a 2 lugares, laterales
            System.out.println("Entro a casos simples 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso 4, puede mover a 2 lugares, abajo y izquierda
            System.out.println("Entro a casos simples 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso 5, puede mover abajo
            System.out.println("Entro a casos simples 5");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso 6, puede mover derecha
            System.out.println("Entro a casos simples 6");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso 7, puede mover izquierda
            System.out.println("Entro a casos simples 7");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso 8, No puede mover
            System.out.println("Entro a casos simples 8");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral derecho
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo Ataque
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral derecho Ataque
        }
    }

    private void CalcularMovimientosEspecialDerJ2() { //Calcula movimientos para peon inicial en el lado derecho J2
        if (FE[xIni + 1][yIni - 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false
                && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == false) { //caso ED1, puede mover a los 3 lugares
            System.out.println("Entro a casos especiales Der 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = true;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false
                && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == true) {//caso E2,  2 abajo bloq
            System.out.println("Entro a casos especiales Der 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = false;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false
                && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == false) {//caso E3,izq bloq
            System.out.println("Entro a casos especiales Der 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = true;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false
                && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == true) { //caso E4, izq bloq y 2 alfrente
            System.out.println("Entro a casos especiales Der 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = false;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso D1, Puede mover a los dos lados
            System.out.println("Entro a casos simples DER 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso D2, Puede mover alfrente
            System.out.println("Entro a casos simples DER 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso D3, Puede mover a izquierda
            System.out.println("Entro a casos simples DER 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso D4, No puede mover
            System.out.println("Entro a casos simples DER 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo linea Ataque
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        }
    }

    private void CalcularMovimientosDerJ2() {
        if (FE[xIni + 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso D1, Puede mover a los dos lados
            System.out.println("Entro a casos simples DER 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso D2, Puede mover alfrente
            System.out.println("Entro a casos simples DER 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == true && (FE[xIni - 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso D3, Puede mover a izquierda
            System.out.println("Entro a casos simples DER 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        } else if (FE[xIni + 1][yIni - 1] == false && (FE[xIni - 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso D4, No puede mover
            System.out.println("Entro a casos simples DER 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni - 1] = false;     //setea lateral izquierdo linea Ataque
            LineaAtaque[xIni + 1][yIni - 1] = true;     //setea lateral izquierdo linea Ataque
        }
    }

    private void CalcularMovimientosEspecialIzqJ2() {
        if (FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false
                && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == false) { //caso ED1, puede mover a los 3 lugares
            System.out.println("Entro a casos especiales Izq 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = true;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false
                && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == true) {//caso E2,  2 abajo bloq
            System.out.println("Entro a casos especiales Izq 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = false;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false
                && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == false) {//caso E3,derecha bloq
            System.out.println("Entro a casos especiales Izq 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = true;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false
                && (FE[xIni + 2][yIni] == true || FJ[xIni + 2][yIni] == true) == true) { //caso E4, derecha bloq y 2 alfrente
            System.out.println("Entro a casos especiales Izq 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            PosiblesMov[xIni + 2][yIni] = false;          //sete pos 2 abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso D1, Puede mover a los dos lados
            System.out.println("Entro a casos simples Izq 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso D2, Puede mover alfrente
            System.out.println("Entro a casos simples Izq 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso D3, Puede mover a derecha
            System.out.println("Entro a casos simples Izq 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso D4, No puede mover
            System.out.println("Entro a casos simples Izq 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        }
    }

    private void CalcularMovimientosIzqJ2() {
        if (FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso D1, Puede mover a los dos lados
            System.out.println("Entro a casos simples Izq 1");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == false) { //caso D2, Puede mover alfrente
            System.out.println("Entro a casos simples Izq 2");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = true;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == true && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso D3, Puede mover a derecha
            System.out.println("Entro a casos simples Izq 3");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = true;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        } else if (FE[xIni + 1][yIni + 1] == false && (FE[xIni + 1][yIni] == true || FJ[xIni + 1][yIni] == true) == true) { //caso D4, No puede mover
            System.out.println("Entro a casos simples Izq 4");
            PosiblesMov[xIni][yIni] = false;            //setea boton actual 
            PosiblesMov[xIni + 1][yIni + 1] = false;     //setea lateral izquierdo 
            PosiblesMov[xIni + 1][yIni] = false;         //setea pos abajo 
            LineaAtaque[xIni + 1][yIni + 1] = true;     //setea lateral Derecho Ataque 
        }
    }

    public ImageIcon ImagenFichaB() {
        img = "/imagenes/PB.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    public ImageIcon ImagenFichaN() {
        img = "/imagenes/PN.png";
        Ficha = new ImageIcon(getClass().getResource(img));
        ImageIcon icono = new ImageIcon(Ficha.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    void ResetearBooleanP() {
        if (ContadorBoprimido == 1 || (ContadorBoprimido - 1) % 4 == 0) { //Para primer jugador
            PeonesJ1[yIni] = true;
        } else {    //Para segundo jugador
            PeonesJ2[yIni] = true;
        }
    }

    boolean[][] RetornarPosiblesMov() {
        return PosiblesMov;
    }

    boolean[][] RetornarLineaAtaque() {
        return LineaAtaque;
    }
    
    boolean[]RetornarbooleanP1() {
        return PeonesJ1;
    }

    boolean[]RetornarbooleanP2() {
        return PeonesJ2;
    }

    private void ImpresionArreglos() {
        System.out.println(" Boolean FJ ");
        //Boolean FJ
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(FJ[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(" Boolean FE ");
        //Boolean FE
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(FE[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(" Boolean FichasJ ");
        //String FJ
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(FichasJ[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(" Boolean FichasE ");
        //String  FE
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(FichasE[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" Boolean Linea Ataque ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(LineaAtaque[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("Posibles Movimientos");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(PosiblesMov[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}
