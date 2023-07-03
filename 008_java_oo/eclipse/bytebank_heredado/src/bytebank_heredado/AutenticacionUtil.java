package bytebank_heredado;

public class AutenticacionUtil {
    
    private String clave;
    
    public boolean inicioSesion(String clave) {
        return this.clave == clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
}
