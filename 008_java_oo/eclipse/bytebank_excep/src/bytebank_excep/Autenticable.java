package bytebank_excep;

public interface Autenticable {
    
    public void setClave(String clave);
    
    public boolean inicioSesion(String clave);
    
}
