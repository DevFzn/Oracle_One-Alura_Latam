public class VariablesMemoria {
    public static void main(String[] args) {
        int var1 = 10;
        int var2 = 6;

        var1 = var2;
        var2 = 20;

        // var1 tima el VALOR de la variable var1 al momento de la asignación
        // java no asinga punteros de variables, solo valores
        System.out.println(var1);
    }
}
