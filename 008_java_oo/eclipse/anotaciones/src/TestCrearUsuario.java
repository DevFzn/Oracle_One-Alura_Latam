import java.time.LocalDate;
import java.time.Month;

public class TestCrearUsuario {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Maria", "123456789", LocalDate.of(1995, Month.MARCH, 14));
        Usuario usuario2 = new Usuario("Mario", "987654321", LocalDate.of(2020, Month.MARCH, 14));
        //System.out.println(Usuario.usuarioValido(usuario1));
        System.out.println(Validador.validador(usuario1));
        //System.out.println(Usuario.usuarioValido(usuario2));
        System.out.println(Validador.validador(usuario2));
        
    }
}
