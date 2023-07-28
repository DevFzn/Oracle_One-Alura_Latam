package com.bytebank.test;

import com.bytebank.modelo.CuentaCorriente;
import com.bytebank.modelo.Cliente;
import com.bytebank.modelo.CuentaAhorro;

public class TestArrayReferencia {
    public static void main(String[] args) {
        CuentaCorriente cc = new CuentaCorriente(11, 22); 
        Object[] referencias = new Object[5];
        referencias[1] = cc;
        System.out.println(cc);
        System.out.println(referencias[1]);
        separador();
        
        referencias[0] = new CuentaCorriente(10, 20);
        System.out.println(referencias[0]);
        separador();
        
        CuentaAhorro ca = new CuentaAhorro(44, 55);
        referencias[2] = ca;
    
        // Cast
        CuentaCorriente ref_cc = (CuentaCorriente)referencias[1];
        // CuentaAhorro ref_cc2 = (CuentaAhorro)referencias[1]; //<- Exception
        // class com.bytebank.modelo.CuentaCorriente cannot be cast to
        // class com.bytebank.modelo.CuentaAhorro
        referencias[4] = new Cliente(); 
        Cliente cliente_obtenido = (Cliente)referencias[4];
        
        for (int i = 0; i < referencias.length; i++) {
            System.out.println(referencias[i]);
        }
        Cliente clienteNormal = new Cliente();
        clienteNormal.setNombre("Flavio");

        Cliente clienteVip = new Cliente();
        clienteVip.setNombre("Romulo");

        Object[] refs = new Object[5];
        refs[0]  = clienteNormal;
        refs[1]  = clienteVip;

        System.out.println(Math.PI);
        System.out.println(((Cliente)refs[1]).getNombre());
    } 
    public static void separador(int saltos) {
        System.out.print("--- --- --- --- --- ---");
        for (int i = 1; i <= saltos; i++) {
            System.out.println("\n");
        }
    }
    public static void separador() {
        System.out.println("--- --- --- --- --- ---");
    }
    
    
}
