/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2_proyecto;

import java.awt.Color;

/**
 *
 * @author JorgeLuis
 */
public class Caballo extends Pieza {

    public Caballo() {
    }

    public Caballo(Color color) {
        super(color);
    }

    @Override
    public boolean movimientoLegal(Cuadro cuadro_tentativo) {
        try {
            if (
                    (Math.abs(this.getCuadro().getxPos() - cuadro_tentativo.getxPos()) == 2 && 
                     Math.abs(this.getCuadro().getyPos() - cuadro_tentativo.getyPos()) == 1) ||
                    (Math.abs(this.getCuadro().getxPos() - cuadro_tentativo.getxPos()) == 1 &&
                     Math.abs(this.getCuadro().getyPos() - cuadro_tentativo.getyPos()) == 2)
                ) {
                return true;
            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    @Override
    public boolean movimientoSinObstaculos(Cuadro cuadro_tentativo, Cuadro selected, Tablero tablero) {
        return true;
    }

}
