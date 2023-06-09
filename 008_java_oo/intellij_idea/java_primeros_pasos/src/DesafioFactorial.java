public class DesafioFactorial {
    public static void main(String[] args) {
        for (int num = 1; num <= 10; num++) {
            System.out.println("El factorial de "+num+" es "+calculoFactorial(num));
        }
    }
    static int calculoFactorial(int num){
        int resultado = 1;
        while (num > 1){
            resultado = resultado * num;
            num--;
        }
        return resultado;
    }
}
