package bytebank_heredado;

public class TestReferencias {
    public static void main(String[] args) {
        
        // El elemento mas genérico puede ser adaptado al elemento mas específico:
        // Todos los 'gerentes' son 'funcionarios', pero no todos los 'funcionarios'
        // son 'gerentes' 

        //Funcionario funcionario = new Funcionario();
        Funcionario funcionario = new Gerente(); 
        funcionario.setNombre("Diego");
        
        Gerente gerente = new Gerente();
        gerente.setNombre("Jimena");
        
        funcionario.setSalario(2000.0);
        gerente.setSalario(10000.0);
        
        //funcionario.inicioSesion("no_es_posible");
        System.out.println(gerente.inicioSesion("askldfhkasjdhf"));
    }
}
