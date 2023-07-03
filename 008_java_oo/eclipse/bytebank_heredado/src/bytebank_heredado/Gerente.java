package bytebank_heredado;

public class Gerente extends Funcionario implements Autenticable {
    
    private AutenticacionUtil util;
    
    public Gerente() {
        this.util = new AutenticacionUtil();
    }
    
    //public void setNombre(String nombre){
    //    super.setNombre(nombre);
    //}
    
    public double getBonificacion() {
        return super.getSalario() + (this.getSalario() * 0.5);
    }
    
    @Override
    public void setClave(String clave) {
        this.util.setClave(clave);
    }
    

    @Override
    public boolean inicioSesion(String clave) {
        return this.util.inicioSesion(clave);
    }
}
