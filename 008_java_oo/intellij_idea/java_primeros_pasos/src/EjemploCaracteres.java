public class EjemploCaracteres {
    public static void main(String[] args) {
        char caracter = 'F';
        System.out.println(caracter);

        caracter = 65;
        System.out.println(caracter);

        caracter = 65 + 1;
        char segundo_caracter = (char)(caracter + 1);
        System.out.println(segundo_caracter);

        String cadena = "Alura Latam";
        System.out.println(cadena);
        cadena = cadena + " + Oracle Next Education " + 2023;
        System.out.println(cadena);
    }
}
