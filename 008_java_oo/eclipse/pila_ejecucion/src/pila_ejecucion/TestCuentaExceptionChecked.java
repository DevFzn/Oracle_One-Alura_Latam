package pila_ejecucion;

public class TestCuentaExceptionChecked {
    
    public static void main(String[] args) {
        
        Cuenta cuenta = new Cuenta();
        try {
            System.out.println("en try");
            cuenta.deposita();
        } catch (MiExcepcion2 ex) {
            System.out.println("en catch");
            ex.printStackTrace();
        }
    }
}
