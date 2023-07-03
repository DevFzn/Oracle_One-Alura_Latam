package bytebank_heredado;

public class SistemaInterno {
    
    private String clave = "12345";
    
    public boolean autentica(Autenticable autenticable) {
    
        boolean autorizado = autenticable.inicioSesion(clave);
        if (autorizado) {
            System.out.println("Sesion iniciada");
            return true;
        } else {
            System.out.println("No autorizado");
            return false;
        }
            
    }
}
