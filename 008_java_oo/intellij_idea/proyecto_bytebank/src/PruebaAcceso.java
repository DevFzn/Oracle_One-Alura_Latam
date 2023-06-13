public class PruebaAcceso {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1);
        cuenta.retirar(300);
        System.out.println(cuenta.getSaldo());
        cuenta.depositar(300);
        System.out.println(cuenta.getSaldo());
        System.out.println(cuenta.getAgencia());
    }
}
