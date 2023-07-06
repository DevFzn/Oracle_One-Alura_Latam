package bytebank_excep;

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

    public void retirar(double valorRetiro) throws SaldoInsuficienteExcepction {
        if (this.saldo < valorRetiro) {
            throw new SaldoInsuficienteExcepction("Saldo insuficiente");
        }
        this.saldo -= valorRetiro;
    }

    public boolean transferir(double montoTransferencia, Cuenta cuenta) throws SaldoInsuficienteExcepction{
        if (this.saldo >= montoTransferencia) {
            try {
                this.retirar(montoTransferencia);
            } catch (SaldoInsuficienteExcepction e) {
                e.printStackTrace();
            }
            cuenta.depositar(montoTransferencia);
            return true;
        } else {
            throw new SaldoInsuficienteExcepction("Saldo insuficiente\nSaldo : $ "+
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
}