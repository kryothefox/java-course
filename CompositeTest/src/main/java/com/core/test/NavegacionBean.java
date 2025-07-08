package com.core.test;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class NavegacionBean implements Serializable {
    private int vista = 1;

    public void mostrarVista1() {
        vista = 1;
    }

    public void mostrarVista2() {
        vista = 2;
    }

    public int getVista() {
        return vista;
    }

    public void setVista(int vista) {
        this.vista = vista;
    }
}
