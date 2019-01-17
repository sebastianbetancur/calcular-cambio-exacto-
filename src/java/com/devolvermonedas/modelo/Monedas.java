/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devolvermonedas.modelo;

/**
 *
 * @author sebas
 */
public class Monedas {

    //Array que tiene las monedas
    int[] monedas = {100, 50, 25, 10, 5, 1};

    //Array con que indica el tipo de monedas
    int[] devolver = {0, 0, 0, 0, 0, 0};

    public Monedas() {
    }

    public int[] getMonedas() {
        return monedas;
    }

    public void setMonedas(int[] monedas) {
        this.monedas = monedas;
    }

    public int[] getDevolver() {
        return devolver;
    }

    public void setDevolver(int[] devolver) {
        this.devolver = devolver;
    }

    @Override
    public String toString() {
        return "Monedas{" + "monedas=" + monedas + ", devolver=" + devolver + '}';
    }
}
