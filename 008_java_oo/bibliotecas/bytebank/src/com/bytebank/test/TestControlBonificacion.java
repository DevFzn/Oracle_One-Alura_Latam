package com.bytebank.test;
import com.bytebank.modelo.Contador;
import com.bytebank.modelo.ControlBonificacion;
import com.bytebank.modelo.Funcionario;
import com.bytebank.modelo.Gerente;

public class TestControlBonificacion {
    public static void main(String[] args) {
        Funcionario diego = new Contador();
        diego.setSalario(2000.0);
        
        Gerente jimena = new Gerente();
        jimena.setSalario(10000.0);
        
        ControlBonificacion controlBonificacion = new ControlBonificacion();
        System.out.println(controlBonificacion.registrarSalario(diego));
        System.out.println(controlBonificacion.registrarSalario(jimena));
        
        Contador alex = new Contador();
        alex.setSalario(5000.0);
        System.out.println(controlBonificacion.registrarSalario(alex));
    }
}
