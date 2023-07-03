import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class Validador {
    public static <T> boolean validador(T objeto) {
        Class<?> clase = objeto.getClass();
        for (Field field : clase.getDeclaredFields()) {
            if (field.isAnnotationPresent(EdadMinima.class)) {
                EdadMinima edadMinima = field.getAnnotation(EdadMinima.class);
                try {
                    field.setAccessible(true);
                    LocalDate fechaNacimiento = (LocalDate) field.get(objeto);
                    return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= edadMinima.valor();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
