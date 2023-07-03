package bytebank_heredado;

public interface Autenticable {
    
    public void setClave(String clave);
    
    public boolean inicioSesion(String clave);
    
}
