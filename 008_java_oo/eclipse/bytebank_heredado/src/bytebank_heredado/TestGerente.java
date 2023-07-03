package bytebank_heredado;

public class TestGerente {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        gerente.setNombre("pepe");
        gerente.setSalario(5000.0);
        gerente.setDocumento("987654321-D");
        System.out.println(gerente.getNombre()+" - "+
                           gerente.getDocumento()+" - "+
                           gerente.getSalario()+" - "+
                           gerente.getBonificacion());
        
        gerente.setClave("AluraLatam");
        System.out.println(gerente.inicioSesion("AluraLatam"));
        System.out.println(gerente.inicioSesion("ClaveErronea"));
    }
}
