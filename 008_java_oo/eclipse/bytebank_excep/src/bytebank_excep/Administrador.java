package bytebank_excep;

public class Administrador extends Funcionario implements Autenticable {
    
    private AutenticacionUtil util;
    
    public Administrador() {
        this.util = new AutenticacionUtil();
    }

    @Override
    public double getBonificacion() {
        return this.getSalario();
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
