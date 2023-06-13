public class PruebaMetodos {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta(1);
        cuenta1.depositar(300);
        System.out.println(cuenta1.retirar(200));
        System.out.println(cuenta1.getSaldo());

        Cuenta cuenta2 = new Cuenta(1);
        cuenta2.depositar(2000);

        boolean puedeTransferir = cuenta2.transferir(400, cuenta1);
        if (puedeTransferir) {
            System.out.println("Transferencia exitosa");
        }
    }
}
