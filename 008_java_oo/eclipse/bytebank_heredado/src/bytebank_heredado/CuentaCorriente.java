package bytebank_heredado;

public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(int agencia, int numero) {
        super(agencia, numero);
    }
    
    @Override
    public boolean retirar(double valorRetiro) {
        double comision = 0.2;
        System.out.println("Ejecutando retiro sobreescrito");
        return super.retirar( valorRetiro + comision );
    }

    @Override
    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
    }
}
