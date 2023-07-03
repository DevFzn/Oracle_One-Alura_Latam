import java.time.LocalDate;
import java.time.Period;

public class Usuario {
    
    private String nombre;
    private String identidad;
    @EdadMinima(valor=10)
    private LocalDate fechaNacimiento;

    public Usuario(String nombre, String identidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.identidad = identidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public static boolean usuarioValido(Usuario usuario) {
        if (!usuario.getNombre().matches("[a-zA-Záàâãéèêíïóôõöúçñ\\s]+")) {
            System.out.println("Fail RegexNombre");
            return false;
        }
        if (!usuario.getIdentidad().matches("[^0-9]+")) {
            System.out.println("Fail RegexIdentidad");
            return false;
        }
        return Period.between(usuario.getFechaNacimiento(), LocalDate.now()).getYears() >= 18;
    }
    
}
