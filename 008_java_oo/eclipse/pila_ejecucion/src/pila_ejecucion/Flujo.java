package pila_ejecucion;

public class Flujo {

    public static void main(String[] args) {
        System.out.println("Inicio Main");
        metodo1();
        System.out.println("Fin Main");
    }

    public static void metodo1(){
        System.out.println("Inicio Método1");
        metodo2();
        System.out.println("Fin Método1");
    }

    public static void metodo2(){
        System.out.println("Inicio Método2");
        for(int i=1; i<= 4; i++){
            try {
                if (i == 2) {
                    int num = 0;
                    int resultado = i/num;
                    System.out.println("Resultado: "+resultado);
                } else if (i == 3) {
                    Cuenta c = null;
                    c.depositar();
                } else {
                    String resultado = null;
                    System.out.println("Resultado: "+resultado.toString());
                }
            } catch (ArithmeticException | NullPointerException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("Fin Método2");
    }
    
    public class Cuenta {
        void depositar() {
            
        }
    }
}