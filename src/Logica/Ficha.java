/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author AndresFWilT
 */
public abstract class Ficha {

    Peon p;
    Alfil a;
    Caballo c;
    Torre t;
    Reina q;
    Rey k;
    boolean Analisischeck;
    private static String FichaMovida;
    private static int xIni, yIni, ContadorBOprimido, i = 0, j = 0, ctt,x,y;
    private static int xA, yA;
    private static boolean[][] FJ, FE;
    private static boolean[][] LAF= new boolean[8][8], LATot= new boolean[8][8], LineaCheck= new boolean[8][8];
    private static boolean[][] PosiblesMov;
    private boolean[] PeonesJ1, PeonesJ2, P1, P2;
    private static boolean validacion2,validacionCP,validacionCHECKMate;
    private static String[][] FichasJ, FichasE;
    static String[][] FICHAS;
    private ArrayList<Integer> PosiblesMovimientos = new ArrayList(); //Array list que recibira coordenadas X y Y (toca descomponerlos para poder meter en la matriz de boolean FJ)

    Ficha(int x, int y, boolean[][] f_j, boolean[][] f_e, String[][] fj, String[][] fe, int c) {       //Constructor de la clase abstracta Ficha
        this.xIni = x;
        this.yIni = y;
        this.FJ = f_j;
        this.FE = f_e;
        this.FichasJ = fj;
        this.FichasE = fe;
        this.FICHAS = fj;
        this.ContadorBOprimido = c;
        this.ctt = c;
    }

    void RecibirInfoPeones(boolean[] pj1, boolean[] pj2) { //Metodo que recibe los peones (si se han movido por primera vez, asi pueden realizar 2 o 1 movimiento)
        this.PeonesJ1 = pj1;
        this.PeonesJ2 = pj2;
        this.P2 = pj1;
        this.P1 = pj2;
    }

    void AnalisisFicha(int xIni, int yIni, boolean[][] f_j, boolean[][] f_e, String[][] fj, String[][] fe, int cont) {            //Metodo que determina la ficha escogida y los posibles movimientos que puede realizar
        this.x = xIni;
        this.y = yIni;
        this.FJ = f_j;
        this.FE = f_e;
        this.FichasJ = fj;
        this.FichasE = fe;
        this.ContadorBOprimido = cont;
        this.ctt = cont;
        if (FichasJ[xIni][yIni] == "P") {
            FichaMovida = null;
            System.out.println("Ficha escogida: Peon");
            p = new Peon(x, y, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ContadorBOprimido);
            p.InicializarPosiblesMov(); //inicializa los posibles movimientos en false
            p.AnalizarFicha();        //Una vez ejecutado este metodo, se tienen los posibles movimientos para el Peon escogido
            PosiblesMov = p.RetornarPosiblesMov();  //Se retornan los posibles movimientos calculados
            validacion2 = setValidacion();                  //se valida si se puede mover
            LAF = p.RetornarLineaAtaque();
            if (validacion2 == true) {
                p.InicializarPosiblesMov(); //Borra los posibles movimientos para una proxima iteracion
                //Impresion();
                xA = xIni;
                yA = yIni;
                FichaMovida = "P";
                PeonesJ1 = p.RetornarbooleanP1();
                PeonesJ2 = p.RetornarbooleanP2();
            }else{
                p.ResetBoolP();
            }
            ctt = ContadorBOprimido;
        } else if (FichasJ[xIni][yIni] == "A") {
            FichaMovida = null;
            System.out.println("Ficha escogida: Alfil");
            Alfil a = new Alfil(x, y, FJ, FE, FichasJ, FichasE, ContadorBOprimido);
            a.InicializarPosiblesMov(); //Borra los posibles movimientos para una proxima iteracion
            a.AnalizarFicha();
            PosiblesMov = a.RetornarPosiblesMov();
            validacion2 = setValidacion();
            LAF = a.RetornarLineaAtaque();
            if (validacion2 == true) {
                a.InicializarPosiblesMov(); //Borra los posibles movimientos para una proxima iteracion
                //Impresion();
                xA = xIni;
                yA = yIni;
                FichaMovida = "A";
            }
            ctt = ContadorBOprimido;
        } else if (FichasJ[xIni][yIni] == "C") {
            FichaMovida = null;
            System.out.println("Ficha escogida: Caballo");
            Caballo c = new Caballo(x, y, FJ, FE, FichasJ, FichasE, ContadorBOprimido);
            c.InicializarPosiblesMov(); //Borra los posibles movimientos para una proxima iteracion
            c.AnalizarFicha();
            PosiblesMov = c.RetornarPosiblesMov();
            validacion2 = setValidacion();
            LAF = c.RetornarLineaAtaque();
            //Impresion();
            if (validacion2 == true) {
                c.InicializarPosiblesMov(); //Borra los posibles movimientos para una proxima iteracion
                //Impresion();
                xA = xIni;
                yA = yIni;
                FichaMovida = "C";
            }
            ctt = ContadorBOprimido;
        } else if (FichasJ[xIni][yIni] == "T") {
            FichaMovida = null;
            System.out.println("Ficha escogida: Torre");
            Torre t = new Torre(x, y, FJ, FE, FichasJ, FichasE, ContadorBOprimido);
            t.InicializarPosiblesMov(); //Borra los posibles movimientos para una proxima iteracion
            t.AnalizarFicha();
            PosiblesMov = t.RetornarPosiblesMov();
            validacion2 = setValidacion();
            LAF = t.RetornarLineaAtaque();
            if (validacion2 == true) {
                FichaMovida = "T";
                t.InicializarPosiblesMov(); //Borra los posibles movimientos para una proxima iteracion
                //Impresion();
                xA = xIni;
                yA = yIni;
            }
            ctt = ContadorBOprimido;
        } else if (FichasJ[xIni][yIni] == "Q") {
            FichaMovida = null;
            System.out.println("Ficha escogida: Reina");
            Reina q = new Reina(x, y, FJ, FE, FichasJ, FichasE, ContadorBOprimido);
            q.InicializarPosiblesMov(); //Borra los posibles movimientos para una proxima iteracion
            q.AnalizarFicha();
            PosiblesMov = q.RetornarPosiblesMov();
            //Impresion();
            validacion2 = setValidacion();
            LAF = q.RetornarLineaAtaque();
            if (validacion2 == true) {
                q.InicializarPosiblesMov(); //Borra los posibles movimientos para una proxima iteracion
                //Impresion();
                xA = xIni;
                yA = yIni;
                FichaMovida = "Q";
            }
            ctt = ContadorBOprimido;
        } else if (FichasJ[xIni][yIni] == "K") {
            resetLATot();
            FichaMovida = null;
            System.out.println("Ficha escogida: Rey");
            RetornarLineasAtaqueEnemigo(FE, FJ, FichasE, FichasJ,ctt);
            LATot = RetornarLineaAtaqueF();
            ImpresionLATot();
            x = xIni;y = yIni;
            System.out.println("Coordenadas del momento: "+x +" "+ y);
            Rey k = new Rey(x,y,FE,FJ,FichasE,FichasJ,ContadorBOprimido,LATot);
            k.InicializarPosiblesMov();
            k.AnalizarFicha();
            PosiblesMov = k.RetornarPosiblesMov();
            validacion2 = setValidacion();
            resetLATot();
            if (validacion2 == true) {
                //Impresion();
                xA = xIni;
                yA = yIni;
                FichaMovida = "K";
            }
            ctt = ContadorBOprimido;
        } else if (FichasE[xIni][yIni] == "P" || FichasE[xIni][yIni] == "T" || FichasE[xIni][yIni] == "C" || FichasE[xIni][yIni] == "A" || FichasE[xIni][yIni] == "r" || FichasE[xIni][yIni] == "R") {
            System.out.println("Ficha escogida: Enemiga");
        }
    }

    boolean PrimeraRevision() {         //Boolean que determina si el jugador en turno esogio una ficha suya
        if (FJ[xIni][yIni] == false) {
            return false;
        } else {
            return true;
        }
    }

    boolean setValidacion() {  //Boolean que determina si la ficha peude mover
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (PosiblesMov[i][j] == true) {
                    return true;
                } else {
                    validacion2 = false;
                }
            }
        }
        return validacion2;
    }

    public boolean[][] retornarPosiblesMovimientos() {
        return PosiblesMov;
    }

    boolean SegundaRevision() {
        return validacion2;
    }

    void ResetBoolP() {
        p = new Peon(i, j, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ContadorBOprimido);
        p.ResetearBooleanP();
    }

    void RelizarCambioMov() {
        if (FE[xIni][yIni] == true) {
            System.out.println("COMIO FICHA");
            FE[xIni][yIni] = false;
            FichasE[xIni][yIni] = null;
        }
        FJ[xA][yA] = false;
        FJ[xIni][yIni] = true;
        FichasJ[xA][yA] = null;
        FichasJ[xIni][yIni] = FichaMovida;
    }

    public void ResetPosiblesMov() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                PosiblesMov[i][j] = false;
            }
        }
    }

    boolean CoronaPeon() {
        if (FichaMovida.equals("P")) {
            if (xIni == 0 || xIni == 7) {
                validacionCP = true;
                return validacionCP;
            }
        }
        return false;
    }

    boolean TerceraRevision(int xA, int yA,boolean [][] FE,boolean [][] FJ,String[][] FichasE,String [][] FichasJ,int ctdBoprimido) {       //Revision si entra en CHECK
        System.out.println("Entro a revision CHECK");
        ctdBoprimido = ContadorBOprimido;
        if (ctdBoprimido == 2||(ctdBoprimido-2) % 4 ==0 ){ctdBoprimido=1;System.out.println("Era el turno del jugador 1");}else if(ctdBoprimido%4==0){ctdBoprimido=3;System.out.println("Era el turno del jugador 2");}
        RetornarLineasAtaqueJugador(xA, yA,FJ,FE,FichasJ,FichasE,ctdBoprimido);
        System.out.println("Contador del boton: "+ctdBoprimido);
        ImpresionLATot();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (FichasJ[i][j] == "K"){
                    System.out.println("Encontre al rey en la posicion: "+i+" "+j);
                    ImpresionLATot();
                    if(LATot[i][j]==true){
                        System.out.println("Esta en CHECK");
                        Rey ini = new Rey(i, j, FJ, FE, FichasJ, FichasE, ctdBoprimido, LATot);
                        ini.InicializarPosiblesMov();
                        ini.AnalizarFicha();
                        ResetPosiblesMov();
                        PosiblesMov =ini.RetornarPosiblesMov();
                        ImpresionP();
                        System.out.println(" DESPUES DE ESTO SE IMPRIME EL MATE ");
                        if(ValidacionMate()==true){System.out.println("Jacke mate");validacionCHECKMate = true;}
                        resetLATot();
                        return true;
                    }
                }
            }
        }
        resetLATot();
        resetLineaCheck();
        return false;
    }
    
    public boolean retornarMate(){
        return validacionCHECKMate;
    }
    
    public void RetornarLineasAtaqueJugador(int xIni, int yIni, boolean[][] FJ, boolean[][] FE, String[][] FichasJ, String[][] FichasE, int ctdBOprimido) {
        System.out.println("Contador del boton: "+ctdBOprimido);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (FichasE[i][j] == "P") {
                    System.out.println("Encontre peones en: "+i + " "+ j);
                    Peon ini = new Peon(i, j, FJ, FE, FichasJ, FichasE, P1, P2, ctdBOprimido);
                    ini.InicializarPosiblesMov();
                    ini.AnalizarFichas(P1,P2);
                    LAF = ini.RetornarLineaAtaque();
                    System.out.println("Impresion Linea ataque de la ficha actual en la posicion: "+i+""+j);
                    ImpresionLAF();
                    for (int w = 0; w < 8; w++) {
                        for (int s = 0; s < 8; s++) {
                            if (LAF[w][s]==true){
                                LATot[w][s]=true;
                            }  
                        }
                    }
                    ini.InicializarPosiblesMov();
                } else if (FichasE[i][j] == "K") {
                    System.out.println("Al rey enemigo en: "+i + " "+ j);
                    Rey ono = new Rey(i, j, FJ, FE, FichasJ, FichasE, ctdBOprimido, LAF);
                    ono.InicializarPosiblesMov();
                    ono.AnalizarFicha();
                    LAF = ono.RetornarLineaAtaque();
                    for (int w = 0; w < 8; w++) {
                        for (int s = 0; s < 8; s++) {
                            if (LAF[w][s]==true){
                                LATot[w][s]=true;
                            }  
                        }
                    }
                    ono.InicializarPosiblesMov();
                } else if (FichasE[i][j]!=(null)) {
                    System.out.println("Encontre las demas fichas en: "+i + " "+ j);
                    AnalisisFicha(i, j, FE, FJ, FichasE, FichasJ, ctdBOprimido);
                    LAF = RetornarLineaAtaque();
                    ImpresionLAF();
                    for (int w = 0; w < 8; w++) {
                        for (int s = 0; s < 8; s++) {
                            if (LAF[w][s]==true){
                                LATot[w][s]=true;
                            }  
                        }
                    }
                }
            }
        }
    }
    
    private void RetornarLineasAtaqueEnemigo(boolean[][] FJ, boolean[][] FE, String[][] FichasJ, String[][] FichasE, int ctdBoprimido) {
        System.out.println("Entro a revision ataque fichas enemigas");
        ctdBoprimido = ContadorBOprimido;
        if (ctdBoprimido == 1||(ctdBoprimido-1) % 4 ==0 ){ctdBoprimido=3;System.out.println("Analizo para el turno del jugador 2");}else if(ctdBoprimido == 3 || (ctdBoprimido-3)%4==0){ctdBoprimido=3;System.out.println("Analizo para el turno del jugador 1");}
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (FichasJ[i][j] == "P") {
                    System.out.println("Encontre peones en: "+i + " "+ j);
                    Peon ini = new Peon(i, j, FJ, FE, FichasJ, FichasE, P1, P2, ctdBoprimido);
                    ini.InicializarPosiblesMov();
                    ini.AnalizarFichas(P1,P2);
                    LAF = ini.RetornarLineaAtaque();
                    System.out.println("Impresion Linea ataque de la ficha actual en la posicion: "+i+""+j);
                    ImpresionLAF();
                    for (int w = 0; w < 8; w++) {
                        for (int s = 0; s < 8; s++) {
                            if (LAF[w][s]==true){
                                LATot[w][s]=true;
                            }  
                        }
                    }
                    ini.InicializarPosiblesMov();
                } else if (FichasJ[i][j] == "K") {
                    System.out.println("Al rey enemigo en: "+i + " "+ j);
                    Rey ono = new Rey(i, j, FJ, FE, FichasJ, FichasE, ctdBoprimido, LAF);
                    ono.InicializarPosiblesMov();
                    ono.AnalizarFicha();
                    LAF = ono.RetornarLineaAtaque();
                    for (int w = 0; w < 8; w++) {
                        for (int s = 0; s < 8; s++) {
                            if (LAF[w][s]==true){
                                LATot[w][s]=true;
                            }  
                        }
                    }
                    ono.InicializarPosiblesMov();
                } else if (FichasJ[i][j] == "A") {
                    System.out.println("Encontre Alfil en: "+i + " "+ j);
                    Alfil ini = new Alfil(i, j, FJ, FE, FichasJ, FichasE,ctdBoprimido);
                    ini.InicializarPosiblesMov();
                    ini.AnalizarFicha();
                    LAF = ini.RetornarLineaAtaque();
                    System.out.println("Impresion Linea ataque de la ficha actual en la posicion: "+i+""+j);
                    ImpresionLAF();
                    for (int w = 0; w < 8; w++) {
                        for (int s = 0; s < 8; s++) {
                            if (LAF[w][s]==true){
                                LATot[w][s]=true;
                            }  
                        }
                    }
                    ini.InicializarPosiblesMov();
                } else if (FichasJ[i][j] == "T") {
                    System.out.println("Encontre Torre en: "+i + " "+ j);
                    Torre ini = new Torre (i, j, FJ, FE, FichasJ, FichasE,ctdBoprimido);
                    ini.InicializarPosiblesMov();
                    ini.AnalizarFicha();
                    LAF = ini.RetornarLineaAtaque();
                    System.out.println("Impresion Linea ataque de la ficha actual en la posicion: "+i+""+j);
                    ImpresionLAF();
                    for (int w = 0; w < 8; w++) {
                        for (int s = 0; s < 8; s++) {
                            if (LAF[w][s]==true){
                                LATot[w][s]=true;
                            }  
                        }
                    }
                    ini.InicializarPosiblesMov();
                } else if (FichasJ[i][j] == "C") {
                    System.out.println("Encontre Caballo en: "+i + " "+ j);
                    Caballo ini = new Caballo (i, j, FJ, FE, FichasJ, FichasE,ctdBoprimido);
                    ini.InicializarPosiblesMov();
                    ini.AnalizarFicha();
                    LAF = ini.RetornarLineaAtaque();
                    System.out.println("Impresion Linea ataque de la ficha actual en la posicion: "+i+""+j);
                    ImpresionLAF();
                    for (int w = 0; w < 8; w++) {
                        for (int s = 0; s < 8; s++) {
                            if (LAF[w][s]==true){
                                LATot[w][s]=true;
                            }  
                        }
                    }
                    ini.InicializarPosiblesMov();
                } else if (FichasJ[i][j] == "Q") {
                    System.out.println("Encontre Reina en: "+i + " "+ j);
                    Reina ini = new Reina (i, j, FJ, FE, FichasJ, FichasE,ctdBoprimido);
                    ini.InicializarPosiblesMov();
                    ini.AnalizarFicha();
                    LAF = ini.RetornarLineaAtaque();
                    System.out.println("Impresion Linea ataque de la ficha actual en la posicion: "+i+""+j);
                    ImpresionLAF();
                    for (int w = 0; w < 8; w++) {
                        for (int s = 0; s < 8; s++) {
                            if (LAF[w][s]==true){
                                LATot[w][s]=true;
                            }  
                        }
                    }
                    ini.InicializarPosiblesMov();
                }
            }
        }
        
    }

    private void ImpresionLAF() {
        System.out.println("Linea ataque de la ficha actual: ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(LAF[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private void ImpresionLATot(){
        System.out.println("Lineas ataque de todas las fichas:  ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(LATot[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    private void resetLATot() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                LATot[i][j] = false;
            }
        }
    }
    
    public void resetLineaCheck(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                LineaCheck[i][j] = false;
            }
        }
    }
    
    public boolean[][] getFJ() {
        return FJ;
    }

    public boolean[][] getFE() {
        return FE;
    }

    public String[][] getFichasE() {
        return FichasE;
    }

    public String[][] getFichasJ() {
        return FichasJ;
    }

    public String getFichaMovida() {
        return FichaMovida;
    }

    public int getxA() {
        return xA;
    }

    public int getyA() {
        return yA;
    }

    int getXact() {
        return xIni;
    }

    int getYact() {
        return yIni;
    }

    public boolean[][] RetornarLineaAtaqueF() {
        return LATot;
    }
    
    public boolean[][] RetornarLineasCHECK() {
        return LineaCheck;
    }

    private boolean[][] RetornarLineaAtaque() {
        return LAF;
    }

    private void ImpresionP() {
        System.out.println("Posibles movimientos para el rey:  ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(PosiblesMov[i][j] + " ");
            }
            System.out.println("");
        }
    }

    boolean[] retornarBooleanP1() {
        Peon p = new Peon(x, y, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ContadorBOprimido);
        PeonesJ1 = p.RetornarbooleanP1();
        return PeonesJ1;
    }

    boolean[] retornarBooleanP2() {
        Peon p = new Peon(x, y, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ContadorBOprimido);
        PeonesJ2 = p.RetornarbooleanP2();
        return PeonesJ2;
    }
    
    void SetCoronaP(){
        validacionCP = false;
    }

    private boolean ValidacionMate() {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(PosiblesMov[i][j]==true){
                    System.out.println("No es mate");
                    return false;
                }
            }
        }
        System.out.println("Mate");
        return true;
    }
}
