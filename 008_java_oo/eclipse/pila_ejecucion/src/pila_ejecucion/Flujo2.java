package pila_ejecucion;

public class Flujo2 {

    public static void main(String[] args) {
        System.out.println("Inicio Main");
        metodo1();
        System.out.println("Fin Main");
    }

    public static void metodo1(){
        System.out.println("Inicio Método1");
        try {
            metodo2();
        } catch (ArithmeticException | MiExcepcion ae) {
            //System.out.println("Excepción: "+ae.getMessage());
            ae.printStackTrace();
        }
        System.out.println("Fin Método1");
    }

    public static void metodo2(){
        System.out.println("Inicio Método2");
        //ArithmeticException ae = new ArithmeticException();
        //throw ae;
        //throw new ArithmeticException("Error aritmético");
        //throw new MiExcepcion("Mi excepción");
        try {
            metodo3();
        } catch (MiExcepcion2 e2) {
            e2.printStackTrace();
        }
        //System.out.println("Fin Método2");
    }
    
    public static void metodo3() throws MiExcepcion2 {
        throw new MiExcepcion2("Mi excepcion 2");
    }
    
    public class Cuenta {
        void depositar() {}
    }
}