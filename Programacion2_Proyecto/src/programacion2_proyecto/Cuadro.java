/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2_proyecto;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JorgeLuis
 */
public class Cuadro extends JPanel {

    private Pieza pieza;
    private final int width = 70;
    private final int height = 70;
    private Color color;
    private boolean selected;
    private boolean ocupado;
    //private int number;
    private int xPos;
    private int yPos;
    private JLabel label;

    //***--Insert Code--***
    public Cuadro() {
        selected = false;
        ocupado = false;
        label = new JLabel();
        this.getLabel().setBounds(this.getBounds());
        this.add(label);
    }

    public Cuadro(Color color, int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.setBackground(color);
        selected = false;
        ocupado = false;
        label = new JLabel();
        this.getLabel().setBounds(this.getBounds());

        this.add(label);
    }

    public Cuadro(Pieza pieza, Color color) {
        this.pieza = pieza;
        this.color = color;
        selected = false;
        ocupado = false;
        label = new JLabel();
        this.getLabel().setBounds(this.getBounds());

        this.add(label);
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
        if (pieza == null) {
            ocupado = false;
            this.label.setVisible(false);
        } else {
            ocupado = true;
            this.label.setVisible(true);
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    //***--Insert Code Ends--***

    //***--Metodos de Administración--***
    public static void enter(int x, int y, Tablero t) {
        if (!t.getCuadros()[x][y].isSelected()) {
            t.getCuadros()[x][y].setBackground(Color.GREEN);
        }
    }

    public static void exit(int x, int y, Tablero t) {
        if (!t.getCuadros()[x][y].isSelected()) {
            
            t.getCuadros()[x][y].setBackground(t.getCuadros()[x][y].getColor());
        }
    }

    public static void enterInvalid(int x, int y, Tablero t) {
        if (!t.getCuadros()[x][y].isSelected()) {
            
            t.getCuadros()[x][y].setBackground(Color.RED);
        }
    }

    public static void enterPiece(int x, int y, Tablero t) {
        if (!t.getCuadros()[x][y].isSelected()) {
            t.getCuadros()[x][y].setBackground(Color.CYAN);
        }
    }

    public void select(int x, int y, Tablero t) {
        if (!t.getCuadros()[x][y].isSelected()) {
            t.getCuadros()[x][y].setBackground(Color.GREEN);
            t.getCuadros()[x][y].setSelected(true);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i != x || j != y) && t.getCuadros()[i][j].isSelected()) {
                        t.getCuadros()[i][j].setBackground(t.getCuadros()[i][j].getColor());
                        t.getCuadros()[i][j].setSelected(false);
                    }
                }
            }
        } else {
            t.getCuadros()[x][y].setBackground(t.getCuadros()[x][y].getColor());
            t.getCuadros()[x][y].setSelected(false);
        }

    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public void Coronar() {
        if ((this.getxPos() == 0 || this.getxPos() == 7)
                && this.isOcupado()) {
            if (this.getPieza() instanceof Peon) {
                boolean repetir = false;
                do {
                    try {
                        Color c = this.getPieza().getColor();
                        Tablero t = this.getPieza().getTablero();
                        int nueva_pieza = Integer.parseInt(JOptionPane.showInputDialog(this, "Coronar Peon:\n"
                                + "1) Reina\n"
                                + "2) Alfil\n"
                                + "3) Caballo\n"
                                + "4) Torre\n"
                        ));
                        if (nueva_pieza > 0 || nueva_pieza < 5) {
                            switch (nueva_pieza) {
                                case 1:
                                    this.setPieza(new Reina(c));
                                    this.getPieza().setCuadro(this);
                                    this.getLabel().setIcon(new ImageIcon(direccionDeIcono(this.getPieza())));
                                    this.getPieza().setTablero(t);
                                    break;
                                case 2:
                                    this.setPieza(new Alfil(c));
                                    this.getPieza().setCuadro(this);
                                    this.getLabel().setIcon(new ImageIcon(direccionDeIcono(this.getPieza())));
                                    this.getPieza().setTablero(t);
                                    break;
                                case 3:
                                    this.setPieza(new Caballo(c));
                                    this.getPieza().setCuadro(this);
                                    this.getLabel().setIcon(new ImageIcon(direccionDeIcono(this.getPieza())));
                                    this.getPieza().setTablero(t);
                                    break;
                                case 4:
                                    this.setPieza(new Torre(c));
                                    this.getPieza().setCuadro(this);
                                    this.getLabel().setIcon(new ImageIcon(direccionDeIcono(this.getPieza())));
                                    this.getPieza().setTablero(t);
                                    break;
                            }
                            repetir = false;
                        } else {
                            repetir = true;
                        }
                    } catch (NumberFormatException e) {
                        repetir = true;
                    }
                } while (repetir);
            }

        }
    }
    public static String direccionDeIcono(Pieza pieza) {
        if (pieza instanceof Peon) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/Images/peon_negro.png";
            } else {
                return "src/Images/peon_blanco.png";
            }
        } else if (pieza instanceof Torre) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/Images/torre_negra.png";
            } else {
                return "src/Images/torre_blanca.png";
            }
        } else if (pieza instanceof Alfil) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/Images/alfil_negro.png";
            } else {
                return "src/Images/alfil_blanco.png";
            }
        } else if (pieza instanceof Caballo) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/Images/caballo_negro.png";
            } else {
                return "src/Images/caballo_blanco.png";
            }
        } else if (pieza instanceof Rey) {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/Images/rey_negro.png";
            } else {
                return "src/Images/rey_blanco.png";
            }
        } else {
            if (pieza.getColor().equals(Color.BLACK)) {
                return "src/Images/reina_negra.png";
            } else {
                return "src/Images/reina_blanca.png";
            }
        }
    }
}

