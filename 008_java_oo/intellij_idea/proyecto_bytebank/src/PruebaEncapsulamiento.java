public class PruebaEncapsulamiento {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1);
        Cliente cliente = new Cliente();
        cliente.setNombre("Zerafín");
        cliente.setDocumento("abcDEFghiJKL");
        cuenta.setTitular(cliente);

        System.out.println(cliente.getNombre());
        System.out.println(cuenta.getTitular().getNombre());

        Cliente titular = cuenta.getTitular();
        System.out.println(titular.getNombre());
    }
}
