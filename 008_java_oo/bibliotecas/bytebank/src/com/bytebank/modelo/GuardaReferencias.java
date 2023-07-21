package com.bytebank.modelo;

public class GuardaReferencias {
    int indice;
    Object[] objeto;
    
    public GuardaReferencias() {
        this.objeto = new Object[10];
        this.indice = 0;
    }

    public void guardar(Object obj) {
        this.objeto[indice] = obj;
        this.indice++;
    }

    public Object obtener(int indx) {
        return objeto[indx];
    }

}
