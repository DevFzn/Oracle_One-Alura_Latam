public class TablaMultiplicacion {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++){
            System.out.println("Tabla Nro "+i);
            for (int mult = 0; mult <= 10; mult++){
                System.out.println(i+" x "+mult+" = "+(mult*i));
            }
            System.out.println();
        }
    }
}
