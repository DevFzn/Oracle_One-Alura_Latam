package com.bytebank.modelo;

public class GuardaCuentas {
     // Crear un obj. para guardar cuentas
     // Métodos para agregar, quitar, get, etc.
    int indice = 0;
    Cuenta[] cuenta = new Cuenta[10];

    public GuardaCuentas() {
        this.indice = 0;
    }
    
    public void guardar(Cuenta cta) {
        cuenta[indice] = cta;
        indice++;
    }

    public Cuenta obtener(int indx) {
        return cuenta[indx];
    }

}
