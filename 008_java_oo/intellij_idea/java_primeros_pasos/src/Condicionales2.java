public class Condicionales2 {
    public static void main(String[] args) {
        int edad = 18;
        int personas = 2;
        boolean pareja = personas > 1;
        boolean permitido = edad >= 18 && pareja;
        String mensaje;

        if (permitido) {
            mensaje = "Puedes pasar";
        } else {
            mensaje = "No puedes pasar";
        }
        System.out.println(mensaje);
    }
}
