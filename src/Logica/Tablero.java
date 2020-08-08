/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.Controlador.FE;

/**
 *
 * @author AndresFWilT
 */
public class Tablero {

    Ficha ficha;
    boolean[][] PosiblesMov;
    public static String PosicionB, FichaMovida;   //String que recibe las coordenadas del boton clickeado
    boolean[][] FJ;     //Matriz boolean que determinara que plazas del tablero estan ocupadas por el jugador
    String[][] FichasJ; // Matriz de String que determinara todas las fichas que hay en el tablero para el jugador (Cuando se muera una se pondra como null)
    String[][] FichasE; // Matriz de String que determinara todas las fichas que hay en el tablero para el jugador enemigo(Cuando se muera una se pondra como null)
    boolean[][] FE; //Matriz boolean que determinara que plazas del tablero estan ocupadas por el enemigo
    static int xIni, yIni, ContadorBoprimido, xA, yA;//int que recibiran la coordenada x y 'y' del boton clickeado y el contador que se usara en algunas fichas
    boolean[] PeonesJ1, PeonesJ2;
    Object getXact;

    public Tablero(String N, boolean[][] fj, boolean[][] fe, String[][] fichasj, String[][] fichase, boolean[] pj1, boolean[] pj2, int c) {
        this.PosicionB = N;
        this.FJ = fj;
        this.FE = fe;
        this.FichasJ = fichasj;
        this.FichasE = fichase;
        this.PeonesJ1 = pj1;
        this.PeonesJ2 = pj2;
        this.ContadorBoprimido = c;
        AsignacionCoord();      //Metodo para asignarle a cada variable int su coordenada x y 'y' respectivamente
    }

    private void AsignacionCoord() {//Metodo para asignar coordenadas X y Y del boton presionado
        xIni = Integer.parseInt(String.valueOf(PosicionB.charAt(0)));
        yIni = Integer.parseInt(String.valueOf(PosicionB.charAt(1)));
        ficha = new Ficha(xIni, yIni, FJ, FE, FichasJ, FichasE, ContadorBoprimido) {
        };
        ficha.RecibirInfoPeones(PeonesJ1, PeonesJ2);
    }

    void AnalisisMovimiento() {
        PosiblesMovimientos();
    }

    private void PosiblesMovimientos() {        //Metodo que envia los datos del tablero actual al a clase ficha para poder analizar movimientos
        ficha = new Ficha(xIni, yIni, FJ, FE, FichasJ, FichasE, ContadorBoprimido) {
        };
        ficha.RecibirInfoPeones(PeonesJ1, PeonesJ2);
        ficha.AnalisisFicha(xIni, yIni, FJ, FE, FichasJ, FichasE, ContadorBoprimido);
    }

    public boolean PrimeraRevision() {          //Metodo que retorna un false/true dependiendo del analisis que se haga en la clase ficha (Si escogio funa ficha suya el jugador)
        if (ficha.PrimeraRevision() == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean SegundaRevision() {         //Metodo que retorna un false/true dependiendo del analisis que se haga en la clase ficha (Si la ficha puede mover)
        if (ficha.SegundaRevision() == true) {
            return true;
        } else {
            return false;
        }
    }

    boolean[][] RetornarPosiblesMovimientos() {
        PosiblesMov = ficha.retornarPosiblesMovimientos();
        return PosiblesMov;
    }

    void ResetBoolP() {
        ficha.ResetBoolP();
    }

    void ActualizarMatricez(String n) {
        this.PosicionB = n;
        AsignacionCoord();
        ficha = new Ficha(xIni, yIni, FJ, FE, FichasJ, FichasE, ContadorBoprimido) {
        };
        ficha.RelizarCambioMov();
    }

    boolean[][] getFJ() {
        this.FJ = ficha.getFJ();
        return FJ;
    }

    boolean[][] getFE() {
        this.FE = ficha.getFE();
        return FE;
    }

    String[][] getFichasJ() {
        this.FichasJ = ficha.getFichasJ();
        return FichasJ;
    }

    String[][] getFichasE() {
        this.FichasE = ficha.getFichasE();
        return FichasE;
    }

    String getFichaMovida() {
        this.FichaMovida = ficha.getFichaMovida();
        return FichaMovida;
    }

    int getxA() {
        this.xA = ficha.getxA();
        return xA;
    }

    int getyA() {
        this.yA = ficha.getyA();
        return yA;
    }

    int getXact() {
        this.xIni = ficha.getXact();
        return xIni;
    }

    int getYact() {
        this.yIni = ficha.getYact();
        return yIni;
    }

    void ResetPosiblesMov() {
        ficha.ResetPosiblesMov();
    }

    boolean CoronaPeon() {
        ficha = new Ficha(xIni, yIni, FJ, FE, FichasJ, FichasE, ContadorBoprimido) {
        };
        return ficha.CoronaPeon();
    }

    boolean TerceraRevision(int xA, int yA, boolean[][] FE, boolean[][] FJ, String[][] FichasE, String[][] FichasJ, int ctdBoprimido) {
        if (ficha.TerceraRevision(xA, yA, FE, FJ, FichasE, FichasJ, ctdBoprimido) == true) {
            return true;
        } else {
            return false;
        }
    }

    void ResetearPosibleMov() {
        ficha.ResetPosiblesMov();
    }

    boolean[] retornarBooleanP1() {
        PeonesJ1 = ficha.retornarBooleanP1();
        return PeonesJ2;
    }

    boolean[] retornarBooleanP2() {
        PeonesJ1 = ficha.retornarBooleanP2();
        return PeonesJ2;
    }

    void setCoronaP() {
        ficha.SetCoronaP();
    }

    boolean retornarMate() {
        return ficha.retornarMate();
    }

}
