/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2_proyecto;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author JorgeLuis
 */
public class Tablero {

    private Cuadro[][] cuadros;

    public Tablero() {
        cuadros = new Cuadro[8][8];
        crearTablero(0, 0, new Cuadro(Color.LIGHT_GRAY, 0, 0), 7);
        agregarPiezas(0, 0, 7);
    }

    private void crearTablero(int pos_x, int pos_y, Cuadro cuadro, int lim) {
        if (pos_x == lim && pos_y == lim) {
            cuadros[pos_x][pos_y] = cuadro;
        } else if (pos_y == lim) {
            cuadros[pos_x][pos_y] = cuadro;
            if ((pos_x + 1) % 2 == 0) {
                crearTablero(pos_x + 1, 0, new Cuadro(Color.LIGHT_GRAY, pos_x + 1, 0), lim);
            } else {
                crearTablero(pos_x + 1, 0, new Cuadro(Color.GRAY, pos_x + 1, 0), lim);
            }
        } else {
            cuadros[pos_x][pos_y] = cuadro;
            if (pos_x % 2 == 0) {
                if ((pos_y + 1) % 2 == 0) {
                    crearTablero(pos_x, pos_y + 1, new Cuadro(Color.LIGHT_GRAY, pos_x, pos_y + 1), lim);
                } else /*if (pos_y + 1 % 2 != 0)*/ {
                    crearTablero(pos_x, pos_y + 1, new Cuadro(Color.GRAY, pos_x, pos_y + 1), lim);
                }
            } else {
                if ((pos_y + 1) % 2 == 0) {
                    crearTablero(pos_x, pos_y + 1, new Cuadro(Color.GRAY, pos_x, pos_y + 1), lim);
                } else /*if (pos_y + 1 % 2 != 0)*/ {
                    crearTablero(pos_x, pos_y + 1, new Cuadro(Color.LIGHT_GRAY, pos_x, pos_y + 1), lim);
                }
            }
        }
    }

    public void agregarPiezas(int pos_x, int pos_y, int lim) {
        if (pos_x == lim && pos_y == lim) {
            cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/torre_blanca.png"));
            cuadros[pos_x][pos_y].setPieza(new Torre(Color.WHITE));
            cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
            cuadros[pos_x][pos_y].getPieza().setTablero(this);
        } else if (pos_y == lim) {
            if (pos_x == 0) {
                cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/torre_negra.png"));
                cuadros[pos_x][pos_y].setPieza(new Torre(Color.BLACK));
                cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                cuadros[pos_x][pos_y].getPieza().setTablero(this);
            } else if (pos_x == 1) {
                cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/peon_negro.png"));
                cuadros[pos_x][pos_y].setPieza(new Peon(Color.BLACK));
                cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                cuadros[pos_x][pos_y].getPieza().setTablero(this);
            } else if (pos_x == 6) {
                cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/peon_blanco.png"));
                cuadros[pos_x][pos_y].setPieza(new Peon(Color.WHITE));
                cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                cuadros[pos_x][pos_y].getPieza().setTablero(this);
            }
            agregarPiezas(pos_x + 1, 0, lim);
        } else {
            if (pos_x == 1) {
                cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/peon_negro.png"));
                cuadros[pos_x][pos_y].setPieza(new Peon(Color.BLACK));
                cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                cuadros[pos_x][pos_y].getPieza().setTablero(this);
            } else if (pos_x == 6) {
                cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/peon_blanco.png"));
                cuadros[pos_x][pos_y].setPieza(new Peon(Color.WHITE));
                cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                cuadros[pos_x][pos_y].getPieza().setTablero(this);
            } else if (pos_x == 0) {
                if (pos_y == 0) {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/torre_negra.png"));
                    //cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/Images/info_futeca.png"));
                    //cuadros[pos_x][pos_y].add(new JLabel("ROOK"));
                    
                    cuadros[pos_x][pos_y].setPieza(new Torre(Color.BLACK));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                } else if (pos_y == 1 || pos_y == 6) {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/caballo_negro.png"));
                    cuadros[pos_x][pos_y].setPieza(new Caballo(Color.BLACK));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                } else if (pos_y == 2 || pos_y == 5) {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/alfil_negro.png"));
                    cuadros[pos_x][pos_y].setPieza(new Alfil(Color.BLACK));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                } else if (pos_y == 4) {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/rey_negro.png"));
                    cuadros[pos_x][pos_y].setPieza(new Rey(Color.BLACK));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                } else {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/reina_negra.png"));
                    cuadros[pos_x][pos_y].setPieza(new Reina(Color.BLACK));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                }
            } else if (pos_x == 7){
                if (pos_y == 0) {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/torre_blanca.png"));
                    cuadros[pos_x][pos_y].setPieza(new Torre(Color.WHITE));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                } else if (pos_y == 1 || pos_y == 6) {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/caballo_blanco.png"));
                    cuadros[pos_x][pos_y].setPieza(new Caballo(Color.WHITE));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                } else if (pos_y == 2 || pos_y == 5) {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/alfil_blanco.png"));
                    cuadros[pos_x][pos_y].setPieza(new Alfil(Color.WHITE));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                } else if (pos_y == 4) {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/rey_blanco.png"));
                    cuadros[pos_x][pos_y].setPieza(new Rey(Color.WHITE));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                } else {
                    cuadros[pos_x][pos_y].getLabel().setIcon(new ImageIcon("src/programacion2_proyecto/Images/reina_blanca.png"));
                    cuadros[pos_x][pos_y].setPieza(new Reina(Color.WHITE));
                    cuadros[pos_x][pos_y].getPieza().setCuadro(cuadros[pos_x][pos_y]);
                    cuadros[pos_x][pos_y].getPieza().setTablero(this);
                }
            }
            agregarPiezas(pos_x, pos_y + 1, lim);
        }
    }

    public Cuadro[][] getCuadros() {
        return cuadros;
    }

    public void setCuadros(Cuadro[][] cuadros) {
        this.cuadros = cuadros;
    }

}

