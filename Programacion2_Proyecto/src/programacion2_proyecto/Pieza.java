/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2_proyecto;

import java.awt.Color;
import java.util.Objects;

/**
 *
 * @author JorgeLuis
 */
public abstract class Pieza{

    private Color color;
    private Tablero tablero;
    private Cuadro cuadro;
    private boolean movido;

    public Pieza() {
        movido = false;
    }

    public Pieza(Color color) {
        this.color = color;
        movido = false;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Cuadro getCuadro() {
        return cuadro;
    }

    public void setCuadro(Cuadro cuadro) {
        this.cuadro = cuadro;
    }

    public boolean isMovido() {
        return movido;
    }

    public void setMovido(boolean movido) {
        this.movido = movido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pieza other = (Pieza) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }

   

    public abstract boolean movimientoLegal(Cuadro cuadro_tentativo);

    public abstract boolean movimientoSinObstaculos(Cuadro cuadro_tentativo, Cuadro selected, Tablero tablero);

    public void comer(Cuadro cuadro) {
        if (cuadro.isOcupado()) {
            if (!cuadro.getPieza().getColor().equals(this.getColor())) {
                cuadro.setPieza(this);
                this.getCuadro().setPieza(null);
                cuadro.setSelected(false);
                cuadro.setBackground(cuadro.getColor());
            }
        }
    }

}

