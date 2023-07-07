package com.bytebank.modelo;

public class ControlBonificacion {
    private double suma_bonific;
    
    public double registrarSalario(Funcionario funcionario) {
        System.out.println(this.suma_bonific);
        return this.suma_bonific += funcionario.getBonificacion();
    }
}
