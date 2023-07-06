package bytebank_excep;

public class TestCuentaExceptionSaldo {
    public static void main(String[] args) {
        Cuenta ca = new CuentaAhorro(11, 22);
        System.out.println("Deposito 1000");
        ca.depositar(1000);
        try {
            System.out.println("Retirando 1000");
            ca.retirar(1000);
            System.out.println("Retiro OK");
            
            //System.out.println("Retirando 1");
            //ca.retirar(1);
            //System.out.println("Retiro OK");
            
            Cuenta cc = new CuentaCorriente(11, 33);
            cc.depositar(1000);
            cc.transferir(500, ca);
            cc.transferir(5000, ca);
            System.out.println(ca.getSaldo());
            System.out.println(cc.getSaldo());
            
            
            
            
            
        } catch (SaldoInsuficienteExcepction e) {
            e.printStackTrace();
        }
        System.out.println("Fin Programa");
    }
}
