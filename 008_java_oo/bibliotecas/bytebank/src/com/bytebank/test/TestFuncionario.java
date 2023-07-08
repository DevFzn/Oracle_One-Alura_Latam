package com.bytebank.test;
import com.bytebank.modelo.Contador;
import com.bytebank.modelo.Funcionario;

public class TestFuncionario {
    public static void main(String[] args) {
        Funcionario diego = new Contador();
        diego.setNombre("Diego");
        diego.setDocumento("123456789-F");
        diego.setSalario(2000.0);
        System.out.println("Funcionario: "+diego.getNombre()+" - "+diego.getSalario()+" - "+diego.getDocumento());
        System.out.println(diego.getBonificacion());
    }
}
