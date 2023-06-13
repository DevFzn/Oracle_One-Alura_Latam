public class CrearCuenta {
    public static void main(String[] args) {
        Cuenta primeraCuenta = new Cuenta(1);
        primeraCuenta.depositar(1000);
        //primeraCuenta.pais = "Zambia"; No compila, no existe el atributo
        System.out.println(primeraCuenta.getSaldo());

        Cuenta segundaCuenta = new Cuenta(1);
        //segundaCuenta.saldo = 500;
        System.out.println(segundaCuenta.getSaldo());
        //System.out.println(segundaCuenta.titular); null
        //System.out.println(segundaCuenta.agencia); 0
    }
}
