public class TipoVariable {
    public static void main(String[] args) {
        // Entero
        int edad = 16*2;
        System.out.println("La edad es " + edad);

        // Double
        double salario = 1250.58;
        System.out.println("El salario es de " + salario + " centavos" );

        // División de enteros devuelve enteros - 32/5 = 6.4 --> 6
        System.out.println( edad / 5);

        // División de decimales devuelve decimales - 4.0 / 2 = 2.0
        System.out.println( 4.0 / 2 );

        // CONVERSIONES
        int salario_int = (int)salario;
        System.out.println("Salario convertido a entero : " + salario_int);

        //long numero_largo = 9_223_372_036_854_775_807L;
        long numero_largo = Long.MAX_VALUE;
        //int numero = 1_999_999_999;
        int numero = Integer.MAX_VALUE;
        //short numero_corto = 19_999;
        short numero_corto = Short.MAX_VALUE;
        //byte clasico_byte = 127;
        byte clasico_byte = Byte.MAX_VALUE;
        //float decimal_bajo = 16.5F;
        float decimal_bajo = Float.MAX_VALUE;

        System.out.println(
                "long  : " + numero_largo + "\n"+
                "int   : " + numero + "\n"+
                "short : " + numero_corto + "\n" +
                "byte  : " + clasico_byte + "\n" +
                "float : " + decimal_bajo);
    }
}
