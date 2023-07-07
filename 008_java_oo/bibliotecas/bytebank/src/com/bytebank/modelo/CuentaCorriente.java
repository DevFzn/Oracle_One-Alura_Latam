package com.bytebank.modelo;

public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(int agencia, int numero) {
        super(agencia, numero);
    }
    
    @Override
    public void retirar(double valorRetiro) throws SaldoInsuficienteException {
        double comision = 0.2;
        System.out.println("Ejecutando retiro sobreescrito");
        super.retirar( valorRetiro + comision );
    }

    @Override
    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
