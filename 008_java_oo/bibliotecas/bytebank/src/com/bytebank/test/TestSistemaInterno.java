package com.bytebank.test;
import com.bytebank.modelo.SistemaInterno;
import com.bytebank.modelo.Gerente;
import com.bytebank.modelo.Administrador;

public class TestSistemaInterno {
    public static void main(String[] args) {
        SistemaInterno sistema = new SistemaInterno();
        Gerente gerente1 = new Gerente();
        Administrador admin1 = new Administrador();
        System.out.println(sistema.autentica(gerente1));
        System.out.println(sistema.autentica(admin1));
        //sistema.autentica(admin1);
    }
}
