public class Condicionales {
    public static void main(String[] args) {
        int edad = 15;
        String mensaje = "";
        if (edad > 18) {
            mensaje = "Eres mayor de edad";
        } else {
            mensaje = "Eres menor de edad";
            if (edad >= 16){
                mensaje += " pero puedes pasar";
            } else {
                mensaje += " y no puedes pasar";
            }
        }
        System.out.println(mensaje);

        // Sintaxis relajada para una linea sgte. al if
        if (edad > 18) System.out.println("la edad es " + edad);
    }
}
