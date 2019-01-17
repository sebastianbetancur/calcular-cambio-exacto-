/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devolvermonedas.controlador;

import com.devolvermonedas.modelo.Monedas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author sebas
 */
@Named(value = "controladorDevuelta")
@SessionScoped
public class ControladorDevuelta implements Serializable {

    //Atributos
    private Monedas monedas = new Monedas();
    private int valorDeDevolucion = 0;
    private String devolucion = "";

    //Constructor
    public ControladorDevuelta() {
    }

    //Metodos
    public String getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }

    public Monedas getMonedas() {
        return monedas;
    }

    public void setMonedas(Monedas monedas) {
        this.monedas = monedas;
    }

    public int getValorDeDevolucion() {
        return valorDeDevolucion;
    }

    public void setValorDeDevolucion(int valorDeDevolucion) {
        this.valorDeDevolucion = valorDeDevolucion;
    }

    public void devolucionDeDinero() {
        devolucion = "";
        reset();
        devolucion += devolucionDeDinero(valorDeDevolucion);

    }

    public void reset() {
        for (int i = 0; i < monedas.getDevolver().length; i++) {
            monedas.getDevolver()[i] = 0;
        }
    }

    private String devolucionDeDinero(int devolucion) {

        String total = "";
        if (devolucion > 0) {

            //Recorro las monedas de mi caja
            for (int i = 0; i < monedas.getMonedas().length; i++) {
                if (devolucion >= monedas.getMonedas()[i]) {
                    monedas.getDevolver()[i] = devolucion / monedas.getMonedas()[i];
                    devolucion = devolucion - (monedas.getDevolver()[i] * monedas.getMonedas()[i]);
                }
            }

            //Resultado
            for (int i = 0; i < monedas.getMonedas().length; i++) {
                if (monedas.getDevolver()[i] > 0) {
                    if (monedas.getMonedas()[i] > 2) {
                        total += "Hay: " + monedas.getDevolver()[i] + " Monedas: " + monedas.getMonedas()[i] + " Pesos" + "\n";
                    } else {
                        total += "Hay: " + monedas.getDevolver()[i] + " Monedas: " + monedas.getMonedas()[i] + " Pesos" + "\n";
                    }
                }
            }
        }
        return total;
    }

}
