public class CiclosWhile2 {
    public static void main(String[] args) {
        int contador = 0;
        int sumatoria = 0;
        while (contador < 10){
            contador++;
            sumatoria+=contador;
            System.out.println("Ciclo "+contador+" : "+sumatoria);
        }
    }
}
