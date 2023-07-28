package com.bytebank.test;

import com.bytebank.modelo.Cuenta;
import com.bytebank.modelo.CuentaCorriente;
import com.bytebank.modelo.GuardaCuentas;
import com.bytebank.modelo.GuardaReferencias;

public class TestGuardaCuentas {
    public static void main(String[] args) {
        
        GuardaCuentas guardaCuentas = new GuardaCuentas();        
        Cuenta cc1 = new CuentaCorriente(11, 22);
        guardaCuentas.guardar(cc1);
        Cuenta cc2 = new CuentaCorriente(12, 23);
        guardaCuentas.guardar(cc2);
        
        System.out.println(guardaCuentas.obtener(0));
        System.out.println(guardaCuentas.obtener(1));

        GuardaReferencias guardaRefs = new GuardaReferencias();
        String obj1 = new String("Objeto 1");
        Object obj2 = new Object();
        guardaRefs.guardar(obj1);
        guardaRefs.guardar(obj2);
        System.out.println(guardaRefs.obtener(0));
        System.out.println(guardaRefs.obtener(1));
    }
}
