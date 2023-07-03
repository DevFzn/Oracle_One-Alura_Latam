public class TestReferencia2 {

    public static void main(String[] args) {
        Cliente diego = new Cliente();
        diego.setNombre("Diego");
        diego.setDocumento("123.123.123-1");

        Cuenta cuentaDiego = new Cuenta(1);
        cuentaDiego.setTitular(diego);
        System.out.println(cuentaDiego.getTitular().getDocumento());

        // referencia
        System.out.println(cuentaDiego.getTitular());    // Cliente@2a84aee7
        System.out.println(diego);                       // Cliente@2a84aee7
    }
}
