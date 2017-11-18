/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2_proyecto;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author JorgeLuis
 */
public class Jugador {
    private String nombre;
    private Color color;
    private ArrayList<Pieza> piezas;
    private ArrayList<Pieza> capturadas;
    private int puntaje;

    public Jugador(String nombre) {
        piezas = new ArrayList();
        capturadas = new ArrayList();
        this.nombre = nombre;
        puntaje = 0;
    }

    public Jugador(String nombre, Color color) {
        piezas = new ArrayList();
        capturadas = new ArrayList();
        this.nombre = nombre;
        this.color = color;
        puntaje = 0;
    }

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(ArrayList<Pieza> piezas) {
        this.piezas = piezas;
    }

    public ArrayList<Pieza> getCapturadas() {
        return capturadas;
    }

    public void setCapturadas(ArrayList<Pieza> capturadas) {
        this.capturadas = capturadas;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    
}

