public class PruebaConstructor {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(555);
        //cuenta.setAgencia(-15);
        System.out.println(cuenta.getAgencia());
        @SuppressWarnings("unused")
		Cuenta cuenta2 = new Cuenta(333);
        @SuppressWarnings("unused")
		Cuenta cuenta3 = new Cuenta(444);
        System.out.println(Cuenta.getContador());
    }
}