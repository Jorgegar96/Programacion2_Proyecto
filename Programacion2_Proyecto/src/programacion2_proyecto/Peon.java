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
public class Peon extends Pieza {

    //boolean movido;
    public Peon() {
    }

    public Peon(Color color) {
        super(color);
    }

    

    @Override
    public boolean movimientoLegal(Cuadro cuadro_tentativo) {
        if (!this.isMovido()) {
            if (this.getColor().equals(Color.WHITE)) {
                if (this.getCuadro().getyPos() == cuadro_tentativo.getyPos()
                        && (this.getCuadro().getxPos() - cuadro_tentativo.getxPos() == 2
                        || this.getCuadro().getxPos() - cuadro_tentativo.getxPos() == 1)) {
                    return true;
                } else {
                    return false;
                }
            } else if (this.getColor().equals(Color.BLACK)) {
                if (this.getCuadro().getyPos() == cuadro_tentativo.getyPos()
                        && (this.getCuadro().getxPos() - cuadro_tentativo.getxPos() == -2
                        || this.getCuadro().getxPos() - cuadro_tentativo.getxPos() == -1)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (this.getColor().equals(Color.WHITE)) {
                if (this.getCuadro().getyPos() == cuadro_tentativo.getyPos()
                        && this.getCuadro().getxPos() - cuadro_tentativo.getxPos() == 1) {
                    return true;
                } else {
                    return false;
                }
            }else if (this.getColor().equals(Color.BLACK)){
                if (this.getCuadro().getyPos() == cuadro_tentativo.getyPos()
                        && this.getCuadro().getxPos() - cuadro_tentativo.getxPos() == -1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;//arreglar
    }

    @Override
    public boolean movimientoSinObstaculos(Cuadro cuadro_tentativo, Cuadro selected, Tablero tablero) {
        int delta_x =  cuadro_tentativo.getxPos() - selected.getxPos();
        System.out.println(delta_x);
        int delta_y = cuadro_tentativo.getyPos() - selected.getyPos();
        System.out.println(delta_y);
        int cambio_x = 0, cambio_y = 0, sum_x = 0, sum_y = 0, desplazamiento_total = 0;
        if (delta_x < 0) {
            cambio_x = -1;
            desplazamiento_total = delta_x;
        } else if (delta_x > 0){
            cambio_x = 1;
            desplazamiento_total = delta_x;
        } else{
            cambio_x = 0;
        }
        if (delta_y < 0) {
            cambio_y = -1;
            desplazamiento_total = delta_y;
        } else if (delta_y > 0){
            cambio_y = 1;
            desplazamiento_total = delta_y;
        }else{
            cambio_y = 0;
        }
        System.out.println(cambio_x + ", " + cambio_y);
        sum_x = cambio_x;
        sum_y = cambio_y;
        for (int i = 1; i < Math.abs(desplazamiento_total); i++) {
            //for(int j = 0 ; j < Math.abs(b); j++){
                if (tablero.getCuadros()[selected.getxPos() + cambio_x][selected.getyPos() + cambio_y].isOcupado()){
                    return false;
                }else{
                    cambio_x += sum_x;
                    cambio_y += sum_y;
                }
            //}
        }
        return true;
    }
    
    public boolean comer(Cuadro tentativo, Cuadro selected){
        if (Math.abs(tentativo.getxPos() - selected.getxPos()) ==
                Math.abs(tentativo.getyPos() - selected.getyPos()) &&
                Math.abs(tentativo.getxPos() - selected.getxPos()) == 1 &&
                Math.abs(tentativo.getyPos() - selected.getyPos()) == 1){
        return true;
        }
        return false;
    }
    
}

