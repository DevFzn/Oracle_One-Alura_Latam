package bytebank_heredado;

public class CuentaAhorro extends Cuenta {
    public CuentaAhorro(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
    }
}
