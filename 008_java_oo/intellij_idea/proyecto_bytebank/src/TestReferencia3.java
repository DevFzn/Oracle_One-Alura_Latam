public class TestReferencia3 {
    public static void main(String[] args) {
        Cuenta cuentaDeDiego = new Cuenta(1);
        //cuentaDeDiego.titular = new Cliente();
        cuentaDeDiego.getTitular().setNombre("Diego");
        System.out.println(cuentaDeDiego.getTitular().getNombre());
    }
}
