package com.bytebank.modelo;

/**
 * Crea nuevas instancias de Cuenta...
 *
 * @version 0.1
 * @author DevFzn
 */
public abstract class Cuenta implements Comparable<Cuenta> {
    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular = new Cliente();
    private static int contador = 0;

    /**
     * Instancia una Cuenta, sin parámetros
     */
    public Cuenta() {}

    /**
     * Instancia una Cuenta usando agencia y numero
     * @param agencia
     * @param numero
     */
    public Cuenta(int agencia, int numero) {
        if (agencia <= 0) {
            System.out.println("No se permiten valores negativos");
            this.agencia = 1;
        } else {
            this.agencia = agencia;
        }
        this.numero = numero;
        contador++;
        System.out.print("Creada cuenta nro: "+this.numero);
        System.out.println(" - Total ctas. creadas: "+contador);
    }

    public abstract void depositar(double valorDeposito);

    /**
     * Retira saldo de la cuenta, si no hay saldo suficiente arroja excepción
     * @param valorRetiro
     * @throws SaldoInsuficienteException
     */
    public void retirar(double valorRetiro) throws SaldoInsuficienteException {
        if (this.saldo < valorRetiro) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        this.saldo -= valorRetiro;
    }

    public boolean transferir(double montoTransferencia, Cuenta cuenta) throws SaldoInsuficienteException{
        if (this.saldo >= montoTransferencia) {
            try {
                this.retirar(montoTransferencia);
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }
            cuenta.depositar(montoTransferencia);
            return true;
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente\nSaldo : $ "+
                                                  this.saldo+"\nRetiro: $ "+montoTransferencia);
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return titular;
    }

    public static int getContador(){
        return Cuenta.contador;
    }
    
    @Override
    public String toString() {
    	return String.format("Cuenta\nNro  : %d\nAgnc : %d\nTitular: %s", this.numero, this.agencia, this.titular.getNombre());
    }
    
    public boolean esIgual(Cuenta cuenta) {
        return this.agencia == cuenta.getAgencia() && this.numero == cuenta.getNumero();
    }
    
    @Override
    public boolean equals(Object obj) {
        Cuenta cuenta = (Cuenta) obj;
        return this.agencia == cuenta.getAgencia() && this.numero == cuenta.getNumero();
    }
    
    @Override
    public int compareTo(Cuenta o) {
        // Orden Natural: Nro. agencia
        //return (Integer.compare(this.getAgencia(), o.getAgencia()));
        // Orden Natural: Mayor Saldo (*-1) 
        return (Double.compare(this.getSaldo(), o.getSaldo())) * -1;
    }
    
}
