package bytebank_heredado;

public class TestCuentas {
    public static void main(String[] args) {
        CuentaCorriente cta_corriente = new CuentaCorriente(1, 1);
        CuentaAhorro cta_ahorro = new CuentaAhorro(2, 3);
        cta_corriente.depositar(2000.0);
        cta_corriente.transferir(1000.0, cta_ahorro);
        System.out.println("Saldo Cuenta de Ahorro   : " + cta_ahorro.getSaldo());
        System.out.println("Saldo Cuenta de Corriente: " + cta_corriente.getSaldo());
    }
}
