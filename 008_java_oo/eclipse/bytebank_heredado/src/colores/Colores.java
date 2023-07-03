package colores;

public class Colores {
    // Colores ANSI
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        System.out.println(RED + "Este texto es rojo" + RESET);
        System.out.println(GREEN + "Este texto es verde" + RESET);
        System.out.println(BLUE + "Este texto es azul" + RESET);
        System.out.println(YELLOW + "Este texto es amarillo" + RESET);
        System.out.println(PURPLE + "Este texto es morado" + RESET);
        System.out.println(CYAN + "Este texto es cian" + RESET);
        System.out.println(WHITE + "Este texto es blanco" + RESET);
    }
}
