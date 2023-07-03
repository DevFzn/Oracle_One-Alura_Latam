package bytebank_heredado;

public abstract class Cuenta {
    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular = new Cliente();
    private static int contador = 0;

    public Cuenta(int agencia, int numero) {
        if (agencia <= 0) {
            System.out.println("No se permiten valores negativos");
            this.agencia = 1;
        } else {
            this.agencia = agencia;
        }
        this.numero = numero;
        contador++;
        System.out.println("Cuentas creadas: "+contador);
    }

    public abstract void depositar(double valorDeposito);

    public boolean retirar(double valorRetiro) {
        if (this.saldo >= valorRetiro) {
            this.saldo -= valorRetiro;
            return true;
        } else {
            return false;
        }
    }

    public boolean transferir(double montoTransferencia, Cuenta cuenta){
        if (this.retirar(montoTransferencia)) {
            cuenta.depositar(montoTransferencia);
            return true;
        } else {
            return false;
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
}