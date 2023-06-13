public class TestReferencia {
    public static void main(String[] args) {
        Cuenta primeraCuenta = new Cuenta(1);
        primeraCuenta.depositar(200);

        //Cuenta segundaCuenta = new Cuenta();
        // System.out.println(primeraCuenta);             // Cuenta@23fc625e
        // System.out.println(segundaCuenta);           // Cuenta@3f99bd52

        Cuenta segundaCuenta = primeraCuenta;
        segundaCuenta.depositar(100);
        System.out.println("Saldo primera cuenta: " + primeraCuenta.getSaldo());
        System.out.println("Saldo segunda cuenta: " + segundaCuenta.getSaldo());

        segundaCuenta.depositar(400);
        System.out.println("Saldo primera cuenta: " + primeraCuenta.getSaldo());

        // Obtener referencia del objeto
        System.out.println(primeraCuenta);          // Cuenta@23fc625e
        System.out.println(segundaCuenta);        // Cuenta@23fc625e

        if (primeraCuenta == segundaCuenta) {
            System.out.println("Son el mismo objeto");
        } else {
            System.out.println("Son diferentes");
        }
    }
}
