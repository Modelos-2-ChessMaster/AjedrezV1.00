/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Interfaz.Vista;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author AndresFWilT
 */
public class Controlador implements ActionListener {

    static boolean[][] FJ, FE, aux, FichasJCHECK;
    static String[][] FichasJ, FichasE, auxs;
    char posX, posY;
    static int xAct, yAct;
    private String NombreJ1, NombreJ2, ColorJ1, ColorJ2, FichaMovida, FichaCambiar;
    private static boolean[] PeonesJ1, PeonesJ2;
    ImageIcon Ficha;
    Vista v = new Vista();
    Color[][] CPlaza;
    Color CB, CN;
    Ficha f;
    Tablero T;
    Caballo c;
    Alfil a;
    Torre t;
    Rey k;
    Reina q;
    Peon p;
    int xA, yA, TotalMovimientos = 0, turnosJ1 = 0, turnosJ2 = 0, ctdBoprimido;
    JButton[][] MatrizBotones;
    private static JPanel I, Tab;
    private static JButton bCancelar;
    private static JLabel lInfoJ1, lInfoJ2, lJugadorTurno, lTurno, lTurnos, lTurnosJ1, lTurnosJ2, lImagenFicha, lInfoFichaEscogida;
    private static JComboBox ListaFichas;

    public Controlador(JPanel t, JPanel i, String j1, String j2, String c1, String c2) {
        this.Tab = t;
        this.I = i;
        this.NombreJ1 = j1;
        this.NombreJ2 = j2;
        this.ColorJ1 = c1;
        this.ColorJ2 = c2;
    }

    public void crearTablero() {
        CPlaza = new Color[8][8];
        DatosJuego();
        //Se crean los colores de las plazas    
        CB = new Color(247, 220, 111);
        CN = new Color(110, 44, 0);
        //Ancho y alto de cada casilla
        int ancho = 70;
        int alto = 70;
        //Objetos con las fichas
        //Se settea el tamaño de la matriz de botones
        MatrizBotones = new JButton[8][8];
        FichasJ = new String[8][8];
        FichasE = new String[8][8];
        //Metodo que llena de Strings una matriz de 8*8 tanto de fichas del jugador como del enemigo para poder identificar y asi mover
        LlenarStringFichas();
        FJ = new boolean[8][8];
        FE = new boolean[8][8];
        PeonesJ1 = new boolean[8];
        PeonesJ2 = new boolean[8];
        //Metodo que llena de Boolean una matriz de 8*8 de fichas del enemigo
        LlenarBooleanFichas();
        //Metodo que llena de Boolean una matriz de 8*8 de fichas del jugador
        //Ambos metodos nos serviran para determinar si se puede mover la ficha del jugador a la posicion escogida
        Caballo c = new Caballo(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Alfil a = new Alfil(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Torre t = new Torre(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Rey k = new Rey(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido, FJ);
        Reina q = new Reina(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Peon p = new Peon(posX, posY, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ctdBoprimido);
        //Se settea el tamaño de gridLayout de nuestro panel del tablero
        Tab.setLayout(new GridLayout(8, 8));
        //Se obtiene el tamaño de los botones acorde a su cantidad
        //Se declaran los contadores a utilizar
        int contadorX, contadorY;
        //Se recorre la dimension X desde 0 hasta DimensionX
        for (contadorX = 0; contadorX < 8; contadorX++) {
            //Se recorre la dimension Y desde 0 hasta DimensionY
            for (contadorY = 0; contadorY < 8; contadorY++) {
                //Se verifica cada plaza para colorearla y ademas llenar una matriz booleana que determinara la plaza ocupada
                if (contadorX % 2 != 0 && contadorY % 2 != 0) {
                    CPlaza[contadorX][contadorY] = CB;
                } else if (contadorX % 2 != 0 && contadorY % 2 == 0) {
                    CPlaza[contadorX][contadorY] = CN;
                } else if (contadorX % 2 == 0 && contadorY % 2 == 0) {
                    CPlaza[contadorX][contadorY] = CB;
                } else if (contadorX % 2 == 0 && contadorY % 2 != 0) {
                    CPlaza[contadorX][contadorY] = CN;
                }

                //Se crea un nuevo objeto de tipo JButton
                JButton btnNuevo = new JButton();
                //Se le asignan sus dimensiones (ancho, alto)
                btnNuevo.setSize(ancho, alto);
                //Se asigna un texto con la posición del botón en la matriz al botón, al tooltip del botón
                btnNuevo.setToolTipText(Integer.toString(contadorX) + "," + Integer.toString(contadorY));
                //Se personaliza el tablero
                //btnNuevo.setFocusable(false);
                //Se asigna el color a correspondiente a la plaza
                btnNuevo.setBackground(CPlaza[contadorX][contadorY]);
                //Se agrega a la matriz el botón recien creado
                MatrizBotones[contadorX][contadorY] = btnNuevo;
                //Se agrega un nuevo evento que maneje la acción clic sobre el botón creado

                //Dibujamos Piezas Negras
                if (contadorX == 0) {
                    if (contadorY == 0 || contadorY == 7) {
                        btnNuevo.setIcon(t.ImagenFichaN());
                    } else if (contadorY == 1 || contadorY == 6) {
                        btnNuevo.setIcon(c.ImagenFichaN());
                    } else if (contadorY == 2 || contadorY == 5) {
                        btnNuevo.setIcon(a.ImagenFichaN());
                    } else if (contadorY == 3) {
                        btnNuevo.setIcon(q.ImagenFichaN());
                    } else if (contadorY == 4) {
                        btnNuevo.setIcon(k.ImagenFichaN());
                    }
                }
                //Dibujamos piezas Blancas
                if (contadorX == 7) {
                    if (contadorY == 0 || contadorY == 7) {
                        btnNuevo.setIcon(t.ImagenFichaB());
                    } else if (contadorY == 1 || contadorY == 6) {
                        btnNuevo.setIcon(c.ImagenFichaB());
                    } else if (contadorY == 2 || contadorY == 5) {
                        btnNuevo.setIcon(a.ImagenFichaB());
                    } else if (contadorY == 3) {
                        btnNuevo.setIcon(k.ImagenFichaB());
                    } else if (contadorY == 4) {
                        btnNuevo.setIcon(q.ImagenFichaB());
                    }
                }
                //Dibujamos peones
                if (contadorX == 6) {
                    btnNuevo.setIcon(p.ImagenFichaB());
                } else if (contadorX == 1) {
                    btnNuevo.setIcon(p.ImagenFichaN());
                }
                //Se agrega al panel 
                Tab.add(MatrizBotones[contadorX][contadorY]);

            }//Fin For - Y
        }//Fin For - X
        ListaFichas = new javax.swing.JComboBox<>();
        ancho = 150;
        alto = 30;
        ListaFichas.setLocation(20, 500);
        ListaFichas.setSize(ancho, alto);
        ListaFichas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Reina", "Torre", "Alfil", "Caballo"}));
        I.add(ListaFichas);
        ListaFichas.setVisible(false);
        ancho = 70;
        alto = 70;
        lImagenFicha = new javax.swing.JLabel();
        lImagenFicha.setSize(alto, ancho);
        lImagenFicha.setLocation(45, 410);
        I.add(lImagenFicha);
        lImagenFicha.setVisible(false);
        ancho = 200;
        alto = 30;
        lInfoFichaEscogida = new javax.swing.JLabel();
        lInfoFichaEscogida.setForeground(new java.awt.Color(0, 0, 0));
        lInfoFichaEscogida.setSize(ancho, alto);
        lInfoFichaEscogida.setLocation(0, 390);
        lInfoFichaEscogida.setText("Ficha a escoger por cambio");
        I.add(lInfoFichaEscogida);
        lInfoFichaEscogida.setVisible(false);

    }

    private void LlenarStringFichas() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0) {
                    if (j == 0 || j == 7) {
                        FichasE[i][j] = "T";
                    }
                    if (j == 1 || j == 6) {
                        FichasE[i][j] = "C";
                    }
                    if (j == 2 || j == 5) {
                        FichasE[i][j] = "A";
                    }
                    if (j == 3) {
                        FichasE[i][j] = "Q";
                    }
                    if (j == 4) {
                        FichasE[i][j] = "K";
                    }
                } else if (i == 1) {
                    FichasE[i][j] = "P";
                } else if (i == 7) {
                    if (j == 0 || j == 7) {
                        FichasJ[i][j] = "T";
                    }
                    if (j == 1 || j == 6) {
                        FichasJ[i][j] = "C";
                    }
                    if (j == 2 || j == 5) {
                        FichasJ[i][j] = "A";
                    }
                    if (j == 3) {
                        FichasJ[i][j] = "K";
                    }
                    if (j == 4) {
                        FichasJ[i][j] = "Q";
                    }
                } else if (i == 6) {
                    FichasJ[i][j] = "P";
                } else {
                    FichasJ[i][j] = null;
                    FichasE[i][j] = null;
                }
            }

        }
    }

    private void LlenarBooleanFichas() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 || i == 1) {
                    FE[i][j] = true;
                } else {
                    FE[i][j] = false;
                }
                if (i == 6 || i == 7) {
                    FJ[i][j] = true;
                } else {
                    FJ[i][j] = false;
                }
                PeonesJ1[i] = true;
                PeonesJ2[i] = true;
            }
        }
    }

    public void addListeners() {    //Listeners botones
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final String Coordenadas = Integer.toString(i) + Integer.toString(j);        //Nombre por orden de cada boton
                MatrizBotones[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        AccionEjecutada(Coordenadas);
                    }
                });
            }
        }
    }

    private void AccionEjecutada(String Coordenadas) {
        ctdBoprimido++;

        //ImpresionArreglos();
        Tablero T = new Tablero(Coordenadas, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ctdBoprimido);

        if (ctdBoprimido % 2 == 0) { //Boton escogido por el jugador a mover
            if (CoronaPeon(Coordenadas)) {      //Corono peon
                T.setCoronaP();
                v.Avisos(3);
                QuitarPosiblesMovimientos();
                ActualizarMatricez(Coordenadas);
                this.FJ = T.getFJ();
                this.FE = T.getFE();
                this.FichasJ = T.getFichasJ();
                this.FichasE = T.getFichasE();
                this.FichaMovida = T.getFichaMovida();
                this.xA = T.getxA();
                this.yA = T.getyA();
                this.xAct = T.getXact();
                this.yAct = T.getYact();
                BloquearTablero();
                EscogerFicha(Coordenadas);
                T.ResetearPosibleMov();
                if (T.TerceraRevision(xA, yA, FE, FJ, FichasE, FichasJ, ctdBoprimido)) { //CHECK
                    v.Avisos(4);
                }
            } else {
                ImpresionArreglos();
                QuitarPosiblesMovimientos();
                ActualizarMatricez(Coordenadas);
                this.FJ = T.getFJ();
                this.FE = T.getFE();
                this.FichasJ = T.getFichasJ();
                this.FichasE = T.getFichasE();
                this.FichaMovida = T.getFichaMovida();
                this.xA = T.getxA();
                this.yA = T.getyA();
                this.xAct = T.getXact();
                this.yAct = T.getYact();
                System.out.println("Coordenadas antiguas: " + xA + " " + yA + " , coordenadas actuales: " + xAct + " " + yAct);
                ActualizacionComponentesInfo();     //Metodo que actualiza el turno de cada jugador
                AnalasisMovimiento(Coordenadas);
                ImpresionArreglos();
                T.ResetearPosibleMov();
                if (T.TerceraRevision(xAct, yAct, FE, FJ, FichasE, FichasJ, ctdBoprimido)) { //CHECK
                    if (T.retornarMate()) {
                        v.Avisos(5);
                        BloquearTablero();
                    } else {
                        v.Avisos(4);
                        ImpresionArreglos();
                    }
                }
            }
        } else {    //Ficha escogida
            if (T.PrimeraRevision() == true) {      //Booleano que verifica si el usuario escogio una ficha suya
                ImpresionArreglos();
                Movimiento(Coordenadas);                 //Metodo que analiza que ficha fue escogida y en que posicion ponerla
                if (T.SegundaRevision() == true) {
                    aux = T.RetornarPosiblesMovimientos();
                    PeonesJ1 = T.retornarBooleanP1();
                    PeonesJ2 = T.retornarBooleanP2();
                    MostrarPosiblesMovimientos();
                } else {
                    v.Avisos(2);
                    ctdBoprimido--;
                    T.ResetBoolP();
                }

            } else {
                v.Avisos(1);
                ctdBoprimido--;
            }

        }

    }

    private void AnalasisMovimiento(String N) {//Controlador botones movimientos
        MovimientoPantalla();
        ActualizacionJugador();
        BloquearBotonesJEntrante();
        ActivarBotonesJEntrante();
    }

    private void ActualizacionComponentesInfo() {
        if (ctdBoprimido % 2 == 0) {
            TotalMovimientos++;
            lTurnos.setText("Movimientos tot: " + TotalMovimientos);
        }
        if (ctdBoprimido % 4 == 0) {
            turnosJ2++;
            lJugadorTurno.setForeground(new java.awt.Color(255, 255, 255));
            lTurno.setForeground(new java.awt.Color(255, 255, 255));
            lJugadorTurno.setText(NombreJ1);
            lTurnosJ2.setText(String.valueOf(turnosJ2));
        }
        if (((ctdBoprimido - 2) % 4 == 0) || ctdBoprimido == 2) {
            turnosJ1++;
            lJugadorTurno.setForeground(new java.awt.Color(0, 0, 0));
            lTurno.setForeground(new java.awt.Color(0, 0, 0));
            lJugadorTurno.setText(NombreJ2);
            lTurnosJ1.setText(String.valueOf(turnosJ1));
        }
    }

    public void bCancelarListener() {
        bCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Si sirvo");
            }
        });
    }

    private void Movimiento(String Coordenada) {
        Tablero T = new Tablero(Coordenada, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ctdBoprimido);
        T.AnalisisMovimiento();
    }

    private void BloquearBotonesJEntrante() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (FE[i][j] == true) {
                    MatrizBotones[i][j].setEnabled(false);
                }
            }
        }
    }

    private void ActivarBotonesJEntrante() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (FJ[i][j] == true) {
                    MatrizBotones[i][j].setEnabled(true);
                }
            }
        }
    }

    private void MostrarPosiblesMovimientos() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (aux[i][j] == true) {
                    MatrizBotones[i][j].setEnabled(true);
                } else {
                    MatrizBotones[i][j].setEnabled(false);
                }
            }
        }
    }

    private void QuitarPosiblesMovimientos() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (aux[i][j] == true) {
                    MatrizBotones[i][j].setEnabled(false);
                } else {
                    MatrizBotones[i][j].setEnabled(false);
                }
            }
        }
    }

    private void ActualizacionJugador() { //Metodo que cambia los boolean y las fichas del jugador actual al otro jugador
        aux = FJ;
        FJ = FE;
        FE = aux;
        auxs = FichasJ;
        FichasJ = FichasE;
        FichasE = auxs;
    }

    public void DatosJuego() {
        I.setLayout(null);
        bCancelar = new javax.swing.JButton();
        bCancelar.setBackground(new java.awt.Color(95, 106, 106));
        bCancelar.setForeground(new java.awt.Color(255, 255, 255));
        bCancelar.setSize(100, 30);
        bCancelar.setLocation(30, 550);
        bCancelar.setText("Cancelar");
        bCancelarListener();
        I.add(bCancelar);

        lJugadorTurno = new javax.swing.JLabel();
        lJugadorTurno.setBackground(new java.awt.Color(95, 106, 106));
        lJugadorTurno.setForeground(new java.awt.Color(255, 255, 255));
        lJugadorTurno.setSize(110, 30);
        lJugadorTurno.setLocation(55, 20);
        I.add(lJugadorTurno);
        lJugadorTurno.setText(NombreJ1);

        lTurno = new javax.swing.JLabel();
        lTurno.setBackground(new java.awt.Color(95, 106, 106));
        lTurno.setForeground(new java.awt.Color(255, 255, 255));
        lTurno.setSize(110, 30);
        lTurno.setLocation(0, 0);
        I.add(lTurno);
        lTurno.setText("Turno de: ");

        lTurnos = new javax.swing.JLabel();
        lTurnos.setBackground(new java.awt.Color(95, 106, 106));
        lTurnos.setForeground(new java.awt.Color(255, 255, 255));
        lTurnos.setSize(110, 30);
        lTurnos.setLocation(20, 100);
        I.add(lTurnos);
        lTurnos.setText("Movimientos tot: " + TotalMovimientos);

        lInfoJ1 = new javax.swing.JLabel();
        lInfoJ1.setBackground(new java.awt.Color(95, 106, 106));
        lInfoJ1.setForeground(new java.awt.Color(255, 255, 255));
        lInfoJ1.setSize(200, 30);
        lInfoJ1.setLocation(0, 200);
        I.add(lInfoJ1);
        lInfoJ1.setText("Cantidad movimientos " + NombreJ1 + " : ");

        lTurnosJ1 = new javax.swing.JLabel();
        lTurnosJ1.setBackground(new java.awt.Color(95, 106, 106));
        lTurnosJ1.setForeground(new java.awt.Color(255, 255, 255));
        lTurnosJ1.setSize(200, 30);
        lTurnosJ1.setLocation(55, 225);
        I.add(lTurnosJ1);
        lTurnosJ1.setText(String.valueOf(turnosJ1));

        lInfoJ2 = new javax.swing.JLabel();
        lInfoJ2.setBackground(new java.awt.Color(95, 106, 106));
        lInfoJ2.setForeground(new java.awt.Color(0, 0, 0));
        lInfoJ2.setSize(200, 30);
        lInfoJ2.setLocation(0, 300);
        I.add(lInfoJ2);
        lInfoJ2.setText("Cantidad movimientos " + NombreJ2 + " : ");

        lTurnosJ2 = new javax.swing.JLabel();
        lTurnosJ2.setBackground(new java.awt.Color(95, 106, 106));
        lTurnosJ2.setForeground(new java.awt.Color(0, 0, 0));
        lTurnosJ2.setSize(200, 30);
        lTurnosJ2.setLocation(55, 325);
        I.add(lTurnosJ2);
        lTurnosJ2.setText(String.valueOf(turnosJ2));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

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

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(" ");
            }
        }
    }

    private void ActualizarMatricez(String Nombre) {
        Tablero T = new Tablero(Nombre, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ctdBoprimido);
        T.ActualizarMatricez(Nombre);
    }

    private void MovimientoPantalla() { //Reemplazo de las imagenes fichas al mover
        Caballo c = new Caballo(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Alfil a = new Alfil(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Torre t = new Torre(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Rey k = new Rey(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido, FJ);
        Reina q = new Reina(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Peon p = new Peon(posX, posY, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ctdBoprimido);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (FichaMovida.equals("P")) {
                    if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(p.ImagenFichaB());
                    } else if (ctdBoprimido % 4 == 0) {
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(p.ImagenFichaN());
                    }
                } else if (FichaMovida.equals("C")) {
                    if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(c.ImagenFichaB());
                    } else if (ctdBoprimido % 4 == 0) {
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(c.ImagenFichaN());
                    }
                } else if (FichaMovida.equals("A")) {
                    if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(a.ImagenFichaB());
                    } else if (ctdBoprimido % 4 == 0) {
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(a.ImagenFichaN());
                    }
                } else if (FichaMovida.equals("T")) {
                    if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(t.ImagenFichaB());
                    } else if (ctdBoprimido % 4 == 0) {
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(t.ImagenFichaN());
                    }
                } else if (FichaMovida.equals("Q")) {
                    if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(q.ImagenFichaB());
                    } else if (ctdBoprimido % 4 == 0) {
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(q.ImagenFichaN());
                    }
                } else if (FichaMovida.equals("K")) {
                    if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(k.ImagenFichaB());
                    } else if (ctdBoprimido % 4 == 0) {
                        MatrizBotones[xA][yA].setIcon(null);
                        MatrizBotones[xAct][yAct].setIcon(k.ImagenFichaN());
                    }
                } else if (FichaMovida.equals(null)) {
                    break;
                }
            }
        }
    }

    private boolean CoronaPeon(String Coordenadas) {
        Tablero T = new Tablero(Coordenadas, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ctdBoprimido);
        return T.CoronaPeon();
    }

    public void EscogerFicha(String Coordenadas) {
        ListaFichas.setVisible(true);
        lImagenFicha.setVisible(true);
        lInfoFichaEscogida.setVisible(true);
        ListaFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaFichasActionPerformed(evt, Coordenadas);
            }
        });
    }

    private void ListaFichasActionPerformed(ActionEvent evt, String Coordenadas) {
        this.FichaCambiar = (String) ListaFichas.getSelectedItem();
        CambiarFicha(FichaCambiar, Coordenadas);
    }

    private void CambiarFicha(String FichaCambiar, String Coordenadas) {
        CambioStringCB(FichaCambiar);
        Caballo c = new Caballo(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Alfil a = new Alfil(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Torre t = new Torre(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Rey k = new Rey(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido, FJ);
        Reina q = new Reina(posX, posY, FJ, FE, FichasJ, FichasE, ctdBoprimido);
        Peon p = new Peon(posX, posY, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ctdBoprimido);
        Tablero T = new Tablero(Coordenadas, FJ, FE, FichasJ, FichasE, PeonesJ1, PeonesJ2, ctdBoprimido);
        if (FichaMovida.equals("C")) {
            if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                lImagenFicha.setIcon(c.ImagenFichaB());
                MatrizBotones[xAct][yAct].setIcon(c.ImagenFichaB());
                FichasJ[xAct][yAct] = FichaMovida;
                ActualizacionComponentesInfo();     //Metodo que actualiza el turno de cada jugador
                AnalasisMovimiento(Coordenadas);
                ImpresionArreglos();
                T.ResetPosiblesMov();
                ListaFichas.setVisible(false);
                lInfoFichaEscogida.setText("ficha cambio corona peon");
            } else if (ctdBoprimido % 4 == 0) {
                lImagenFicha.setIcon(c.ImagenFichaN());
                MatrizBotones[xAct][yAct].setIcon(c.ImagenFichaN());
                FichasJ[xAct][yAct] = FichaMovida;
                ActualizacionComponentesInfo();     //Metodo que actualiza el turno de cada jugador
                AnalasisMovimiento(Coordenadas);
                ImpresionArreglos();
                T.ResetPosiblesMov();
                ListaFichas.setVisible(false);
                lInfoFichaEscogida.setText("ficha cambio corona peon");
            }
        } else if (FichaMovida.equals("A")) {
            if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                lImagenFicha.setIcon(a.ImagenFichaB());
                MatrizBotones[xAct][yAct].setIcon(a.ImagenFichaB());
                FichasJ[xAct][yAct] = FichaMovida;
                ActualizacionComponentesInfo();     //Metodo que actualiza el turno de cada jugador
                AnalasisMovimiento(Coordenadas);
                ImpresionArreglos();
                T.ResetPosiblesMov();
                ListaFichas.setVisible(false);
                lInfoFichaEscogida.setText("ficha cambio corona peon");
            } else if (ctdBoprimido % 4 == 0) {
                lImagenFicha.setIcon(a.ImagenFichaN());
                MatrizBotones[xAct][yAct].setIcon(a.ImagenFichaN());
                FichasJ[xAct][yAct] = FichaMovida;
                ActualizacionComponentesInfo();     //Metodo que actualiza el turno de cada jugador
                AnalasisMovimiento(Coordenadas);
                ImpresionArreglos();
                T.ResetPosiblesMov();
                ListaFichas.setVisible(false);
                lInfoFichaEscogida.setText("ficha cambio corona peon");
            }
        } else if (FichaMovida.equals("T")) {
            if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                lImagenFicha.setIcon(t.ImagenFichaB());
                MatrizBotones[xAct][yAct].setIcon(t.ImagenFichaB());
                FichasJ[xAct][yAct] = FichaMovida;
                ActualizacionComponentesInfo();     //Metodo que actualiza el turno de cada jugador
                AnalasisMovimiento(Coordenadas);
                ImpresionArreglos();
                T.ResetPosiblesMov();
                ListaFichas.setVisible(false);
                lInfoFichaEscogida.setText("ficha cambio corona peon");
            } else if (ctdBoprimido % 4 == 0) {
                lImagenFicha.setIcon(t.ImagenFichaN());
                MatrizBotones[xAct][yAct].setIcon(t.ImagenFichaN());
                FichasJ[xAct][yAct] = FichaMovida;
                ActualizacionComponentesInfo();     //Metodo que actualiza el turno de cada jugador
                AnalasisMovimiento(Coordenadas);
                ImpresionArreglos();
                T.ResetPosiblesMov();
                ListaFichas.setVisible(false);
                lInfoFichaEscogida.setText("ficha cambio corona peon");
            }
        } else if (FichaMovida.equals("Q")) {
            if (ctdBoprimido == 2 || (ctdBoprimido - 2) % 4 == 0) { //Para primer jugador{
                lImagenFicha.setIcon(q.ImagenFichaB());
                MatrizBotones[xAct][yAct].setIcon(q.ImagenFichaB());
                FichasJ[xAct][yAct] = FichaMovida;
                ActualizacionComponentesInfo();     //Metodo que actualiza el turno de cada jugador
                AnalasisMovimiento(Coordenadas);
                ImpresionArreglos();
                T.ResetPosiblesMov();
                ListaFichas.setVisible(false);
                lInfoFichaEscogida.setText("ficha cambio corona peon");
            } else if (ctdBoprimido % 4 == 0) {
                lImagenFicha.setIcon(q.ImagenFichaN());
                MatrizBotones[xAct][yAct].setIcon(q.ImagenFichaN());
                FichasJ[xAct][yAct] = FichaMovida;
                ActualizacionComponentesInfo();     //Metodo que actualiza el turno de cada jugador
                AnalasisMovimiento(Coordenadas);
                ImpresionArreglos();
                T.ResetPosiblesMov();
                ListaFichas.setVisible(false);
                lInfoFichaEscogida.setText("ficha cambio corona peon");
            }
        }

    }

    private void BloquearTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                MatrizBotones[i][j].setEnabled(false);
            }
        }
    }

    private void CambioStringCB(String FichaCambiar1) {
        if (FichaCambiar1.equals("Reina")) {
            FichaMovida = "Q";
        } else if (FichaCambiar1.equals("Torre")) {
            FichaMovida = "T";
        } else if (FichaCambiar1.equals("Alfil")) {
            FichaMovida = "A";
        } else if (FichaCambiar1.equals("Caballo")) {
            FichaMovida = "C";
            System.out.println(FichaMovida);
        }
    }

}
