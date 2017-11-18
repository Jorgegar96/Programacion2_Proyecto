/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2_proyecto;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JorgeLuis
 */
public class Programacion2_Proyecto extends JFrame {

    static Cuadro[][] paneles;
    static Jugador white;
    static Jugador black;
    static Jugador enTurno;
    static Jugador enEspera;
    static Cuadro selected;
    static boolean turno; //P1(white) = true, P2(black) = false
    static Tablero t;
    static Tablero copiaTablero;
    static JFrame frame;
    static int proceso = 1;/*Etapas: 1) Seleccion de pieza
                                     2) Seleccion de casilla a mover
                                     3) Retorno a seleccion de pieza
     */

    public static void main(String[] args) {
        copiaTablero = new Tablero();
        paneles = new Cuadro[8][8];
        selected = new Cuadro();
        t = new Tablero();
        turno = true;
        white = new Jugador("Jugador 1", Color.white);
        asignarPiezas(white);
        black = new Jugador("Jugador 2", Color.BLACK);
        asignarPiezas(black);
        enTurno = new Jugador();
        enTurno = white;
        enEspera = new Jugador();
        enEspera = black;
        frame = new JFrame();
        frame.setLayout(null);
        JPanel panel = new JPanel();
        habilitacionGUI(frame);
        frame.add(panel);
        frame.setSize(580, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (t.getCuadros()[x][y].getColor().equals(Color.DARK_GRAY)) {
                    System.out.print("x" + "    ");
                } else {
                    System.out.print(" " + "    ");
                }
            }
            System.out.println("");
        }
    }

    //public static boolean 
    public static int Proceso(int suma) {
        if (proceso < 3 && proceso > 0) {
            proceso += suma;
        }
        if (proceso == 3 || proceso == 0) {
            proceso = 1;
        }
        return proceso;
    }

    public static void cambioTurno() {
        if (enTurno.equals(white)) {
            enTurno = black;
            enEspera = white;
        } else {
            enTurno = white;
            enEspera = black;
        }
    }

    public static boolean mismoColor(Cuadro tentativo) {
        for (int x = 0; x < t.getCuadros().length; x++) {
            for (int y = 0; y < t.getCuadros().length; y++) {
                if (t.getCuadros()[x][y].isSelected()) {
                    System.out.println(tentativo.getPieza().getColor());
                    System.out.println(t.getCuadros()[x][y].getPieza().getColor());
                    if ((t.getCuadros()[x][y].getPieza().getColor().toString()).equals(tentativo.getPieza().getColor().toString())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean mismaCasilla(Cuadro tentativo) {
        for (int x = 0; x < t.getCuadros().length; x++) {
            for (int y = 0; y < t.getCuadros().length; y++) {
                if (t.getCuadros()[x][y].isSelected()) {
                    if (t.getCuadros()[x][y].getxPos() == tentativo.getxPos()
                            && t.getCuadros()[x][y].getyPos() == tentativo.getyPos()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void cambioCasilla(Cuadro tentativo, int xPos, int yPos, int lim, Tablero t) {
        if (xPos == lim && yPos == lim) {
            if (t.getCuadros()[xPos][yPos].isSelected()) {

                System.out.println(xPos + " ," + yPos);
                tentativo.setPieza(t.getCuadros()[xPos][yPos].getPieza());
                t.getCuadros()[xPos][yPos].setPieza(null);
                tentativo.setOcupado(true);
                t.getCuadros()[xPos][yPos].setOcupado(false);
                tentativo.getLabel().setIcon(new ImageIcon(direccionDeIcono(tentativo.getPieza())));;
                tentativo.select(tentativo.getxPos(), tentativo.getyPos(), t);
                tentativo.select(tentativo.getxPos(), tentativo.getyPos(), t);
                tentativo.getPieza().setCuadro(tentativo);
                if (!tentativo.getPieza().isMovido()) {
                    tentativo.getPieza().setMovido(true);
                    System.out.println("Pieza Movida");
                }
                return;
            }
        } else if (yPos == lim) {
            if (t.getCuadros()[xPos][yPos].isSelected()) {

                System.out.println(xPos + " ," + yPos);
                tentativo.setPieza(t.getCuadros()[xPos][yPos].getPieza());
                t.getCuadros()[xPos][yPos].setPieza(null);
                tentativo.setOcupado(true);
                t.getCuadros()[xPos][yPos].setOcupado(false);
                tentativo.getLabel().setIcon(new ImageIcon(direccionDeIcono(tentativo.getPieza())));;
                tentativo.select(tentativo.getxPos(), tentativo.getyPos(), t);
                tentativo.select(tentativo.getxPos(), tentativo.getyPos(), t);
                tentativo.getPieza().setCuadro(tentativo);
                if (!tentativo.getPieza().isMovido()) {
                    tentativo.getPieza().setMovido(true);
                    System.out.println("Pieza Movida");
                }
                return;
            } else {
                cambioCasilla(tentativo, xPos + 1, 0, lim, t);
            }
        } else {
            if (t.getCuadros()[xPos][yPos].isSelected()) {
                System.out.println(xPos + " ," + yPos);
                tentativo.setPieza(t.getCuadros()[xPos][yPos].getPieza());
                t.getCuadros()[xPos][yPos].setPieza(null);
                tentativo.setOcupado(true);
                t.getCuadros()[xPos][yPos].setOcupado(false);
                tentativo.getLabel().setIcon(new ImageIcon(direccionDeIcono(tentativo.getPieza())));;
                tentativo.select(tentativo.getxPos(), tentativo.getyPos(), t);
                tentativo.select(tentativo.getxPos(), tentativo.getyPos(), t);
                tentativo.getPieza().setCuadro(tentativo);
                if (!tentativo.getPieza().isMovido()) {
                    tentativo.getPieza().setMovido(true);
                    System.out.println("Pieza Movida");
                }
                return;
            } else {
                cambioCasilla(tentativo, xPos, yPos + 1, lim, t);
            }
        }
    }

    public static void asignarPiezas(Jugador jugador) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (t.getCuadros()[x][y].isOcupado()) {
                    if (jugador.getColor().equals(t.getCuadros()[x][y].getPieza().getColor())) {
                        jugador.getPiezas().add(t.getCuadros()[x][y].getPieza());
                    }
                }
            }
        }
    }

    public static boolean piezaPropia(Pieza pieza) {
        for (Pieza pieza_propia : enTurno.getPiezas()) {
            if (pieza_propia.equals(pieza)) {
                return true;
            }
        }
        return false;
    }

    public static void habilitacionGUI(JFrame frame) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                frame.add(t.getCuadros()[x][y]);
                t.getCuadros()[y][x].setBounds(x * 70, y * 70, 70, 70);
                t.getCuadros()[y][x].setVisible(true);
                final int xx = x;
                final int yy = y;
                t.getCuadros()[x][y].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (proceso == 1) {
                            if (t.getCuadros()[xx][yy].isOcupado()) {
                                if (enTurno.getPiezas().contains(t.getCuadros()[xx][yy].getPieza())) {
                                    seleccionDePieza(xx, yy);
                                }
                            } else {
                                System.out.println("Casilla Desocupada");
                            }
                        } else if (proceso == 2) {
                            if (!t.getCuadros()[xx][yy].isOcupado()) {
                                if (selected.getPieza().movimientoSinObstaculos(t.getCuadros()[xx][yy], selected, t)
                                        && selected.getPieza().movimientoLegal(t.getCuadros()[xx][yy])) {
                                    Proceso(1);

                                    copiaTablero = copiarTablero(t, copiaTablero);
                                    cambioCasilla(copiaTablero.getCuadros()[xx][yy], 0, 0, 7, copiaTablero);
                                    if (comprobarJaque()) {
                                        JOptionPane.showMessageDialog(frame, "Su rey está en jaque, haga otro movimiento");
                                    } else {
                                        cambioCasilla(t.getCuadros()[xx][yy], 0, 0, 7, t);
                                        selected = null;
                                        pruebaCoronar();
                                        cambioTurno();
                                    }
                                }
                            } else if (mismoColor(t.getCuadros()[xx][yy])) {
                                System.out.println("mismo color");

                                if (mismaCasilla(t.getCuadros()[xx][yy])) {
                                    System.out.println(t.getCuadros()[xx][yy].getxPos() + ", " + t.getCuadros()[xx][yy].getyPos());
                                    System.out.println(selected.getxPos() + ", " + selected.getyPos());
                                    System.out.println("misma casilla");
                                    t.getCuadros()[xx][yy].select(xx, yy, t);
                                    selected = null;
                                    Proceso(-1);
                                } else {
                                    selected = t.getCuadros()[xx][yy];
                                    t.getCuadros()[xx][yy].select(xx, yy, t);
                                    System.out.println("Selected" + selected.getPieza());
                                    System.out.println("Nueva Pieza Seleccionada");
                                }
                            } else {
                                if (selected.getPieza() instanceof Peon) {
                                    if (selected.getPieza().movimientoSinObstaculos(t.getCuadros()[xx][yy], selected, t)
                                            && (selected.getPieza().movimientoLegal(t.getCuadros()[xx][yy])
                                            || ((Peon) selected.getPieza()).comer(t.getCuadros()[xx][yy], selected))) {
                                        Proceso(1);

                                        copiaTablero = copiarTablero(t, copiaTablero);
                                        cambioCasilla(copiaTablero.getCuadros()[xx][yy], 0, 0, 7, copiaTablero);
                                    }
                                } else if (selected.getPieza().movimientoSinObstaculos(t.getCuadros()[xx][yy], selected, t)
                                        && selected.getPieza().movimientoLegal(t.getCuadros()[xx][yy])) {
                                    Proceso(1);

                                    copiaTablero = copiarTablero(t, copiaTablero);
                                    cambioCasilla(copiaTablero.getCuadros()[xx][yy], 0, 0, 7, copiaTablero);

                                }
                                if (comprobarJaque()) {
                                    Proceso(-1);
                                    JOptionPane.showMessageDialog(frame, "Jaque");
                                } else {
                                    cambioCasilla(t.getCuadros()[xx][yy], 0, 0, 7, t);
                                    pruebaCoronar();
                                    cambioTurno();
                                }
                            }
                        }
                        System.out.println(proceso);
                        finDeJuego();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (proceso == 1) {
                            if (piezaPropia(t.getCuadros()[xx][yy].getPieza())) {
                                t.getCuadros()[xx][yy].enter(xx, yy, t);
                            } else {
                                t.getCuadros()[xx][yy].enterInvalid(xx, yy, t);
                            }
                        } else if (proceso == 2) {
                            if (piezaPropia(t.getCuadros()[xx][yy].getPieza())) {
                                t.getCuadros()[xx][yy].enterPiece(xx, yy, t);
                            } else {
                                if (selected.getPieza().movimientoLegal(t.getCuadros()[xx][yy])
                                        && selected.getPieza().movimientoSinObstaculos(t.getCuadros()[xx][yy], selected, t)) {
                                    t.getCuadros()[xx][yy].enter(xx, yy, t);
                                } else {
                                    t.getCuadros()[xx][yy].enterInvalid(xx, yy, t);
                                }
                            }
                        }

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        t.getCuadros()[xx][yy].exit(xx, yy, t);
                    }
                });

            }
        }

    }

    public static void seleccionDePieza(int xx, int yy) {
        t.getCuadros()[xx][yy].select(xx, yy, t);
        selected = t.getCuadros()[xx][yy];
        System.out.println("SELECTED" + selected.getPieza());
        System.out.println(t.getCuadros()[xx][yy].getPieza().getClass().getSimpleName());
        Proceso(1);
    }

    public static boolean comprobarJaque() {
        for (Pieza pieza : enTurno.getPiezas()) {
            if (pieza instanceof Rey) {
                return ((Rey) pieza).jaque(copiaTablero);
            }
        }
        for (Pieza pieza : enEspera.getPiezas()) {
            if (pieza instanceof Rey) {
                return ((Rey) pieza).jaque(copiaTablero);
            }
        }
        return false;
    }

    public static Tablero copiarTablero(Tablero porCopiar, Tablero porTransformar) {
        Tablero copia = new Tablero();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                copia.getCuadros()[x][y] = copiarCuadro(porCopiar.getCuadros()[x][y], porTransformar);
            }
        }
        return copia;
    }

    public static Cuadro copiarCuadro(Cuadro cuadro, Tablero nuevoTablero) {
        Cuadro nuevo = new Cuadro(cuadro.getColor(), cuadro.getxPos(), cuadro.getyPos());
        if (cuadro.isOcupado()) {
            if (cuadro.getPieza() instanceof Peon) {
                nuevo.setPieza(new Peon());
            } else if (cuadro.getPieza() instanceof Rey) {
                nuevo.setPieza(new Rey());
            } else if (cuadro.getPieza() instanceof Reina) {
                nuevo.setPieza(new Reina());
            } else if (cuadro.getPieza() instanceof Alfil) {
                nuevo.setPieza(new Alfil());
            } else if (cuadro.getPieza() instanceof Torre) {
                nuevo.setPieza(new Torre());
            } else if (cuadro.getPieza() instanceof Caballo) {
                nuevo.setPieza(new Caballo());
            }
            nuevo.getPieza().setColor(cuadro.getPieza().getColor());
            nuevo.getPieza().setMovido(cuadro.getPieza().isMovido());
            nuevo.getPieza().setCuadro(nuevo);
            nuevo.getPieza().setTablero(copiaTablero);
            nuevo.getLabel().setIcon(new ImageIcon(direccionDeIcono(nuevo.getPieza())));
            nuevo.setOcupado(true);
        } else {
            nuevo.setOcupado(false);
        }
        nuevo.setSelected(cuadro.isSelected());
        return nuevo;
    }

    public static String direccionDeIcono(Pieza pieza) {
        if (pieza instanceof Peon) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/programacion2_proyecto/Images/peon_negro.png";
            } else {
                return "src/programacion2_proyecto/Images/peon_blanco.png";
            }
        } else if (pieza instanceof Torre) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/programacion2_proyecto/Images/torre_negra.png";
            } else {
                return "src/programacion2_proyecto/Images/torre_blanca.png";
            }
        } else if (pieza instanceof Alfil) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/programacion2_proyecto/Images/alfil_negro.png";
            } else {
                return "src/programacion2_proyecto/Images/alfil_blanco.png";
            }
        } else if (pieza instanceof Caballo) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/programacion2_proyecto/Images/caballo_negro.png";
            } else {
                return "src/programacion2_proyecto/Images/caballo_blanco.png";
            }
        } else if (pieza instanceof Rey) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/programacion2_proyecto/Images/rey_negro.png";
            } else {
                return "src/programacion2_proyecto/Images/rey_blanco.png";
            }
        } else {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/programacion2_proyecto/Images/reina_negra.png";
            } else {
                return "src/programacion2_proyecto/Images/reina_blanca.png";
            }
        }
    }

    public static void pruebaCoronar() {
        for (int x = 0; x < t.getCuadros().length; x += 7) {
            for (int y = 0; y < t.getCuadros().length; y++) {
                t.getCuadros()[x][y].Coronar();
            }
        }
    }

    public static void finDeJuego() {
        boolean white_king = false;
        boolean black_king = false;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (t.getCuadros()[x][y].isOcupado()) {
                    if (t.getCuadros()[x][y].getPieza() instanceof Rey) {
                        if (t.getCuadros()[x][y].getPieza().getColor().equals(Color.BLACK)) {
                            black_king = true;
                        } else if (t.getCuadros()[x][y].getPieza().getColor().equals(Color.WHITE)) {
                            white_king = true;
                        }
                    }
                }
            }
        }
        if (!black_king) {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Felicidades Jugador 1, has ganado la partida!");
            String resp = JOptionPane.showInputDialog("Desea volver a jugar?");
            if (resp == "s") {
                copiaTablero = new Tablero();
                paneles = new Cuadro[8][8];
                selected = new Cuadro();
                t = new Tablero();
                turno = true;
                white = new Jugador("Jugador 1", Color.white);
                asignarPiezas(white);
                black = new Jugador("Jugador 2", Color.BLACK);
                asignarPiezas(black);
                enTurno = new Jugador();
                enTurno = white;
                enEspera = new Jugador();
                enEspera = black;
                frame = new JFrame();
                frame.setLayout(null);
                JPanel panel = new JPanel();
                habilitacionGUI(frame);
                frame.add(panel);
                frame.setSize(580, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if (t.getCuadros()[x][y].getColor().equals(Color.DARK_GRAY)) {
                            System.out.print("x" + "    ");
                        } else {
                            System.out.print(" " + "    ");
                        }
                    }
                    System.out.println("");
                }
            }
        } else if (!white_king) {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Felecididades jugador 2, has ganado la partida!");
            String resp = JOptionPane.showInputDialog("Desea volver a jugar?");
            if (resp == "s") {
                copiaTablero = new Tablero();
                paneles = new Cuadro[8][8];
                selected = new Cuadro();
                t = new Tablero();
                turno = true;
                white = new Jugador("Jugador 1", Color.white);
                asignarPiezas(white);
                black = new Jugador("Jugador 2", Color.BLACK);
                asignarPiezas(black);
                enTurno = new Jugador();
                enTurno = white;
                enEspera = new Jugador();
                enEspera = black;
                frame = new JFrame();
                frame.setLayout(null);
                JPanel panel = new JPanel();
                habilitacionGUI(frame);
                frame.add(panel);
                frame.setSize(580, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if (t.getCuadros()[x][y].getColor().equals(Color.DARK_GRAY)) {
                            System.out.print("x" + "    ");
                        } else {
                            System.out.print(" " + "    ");
                        }
                    }
                    System.out.println("");
                }
            }
        }
    }

}
