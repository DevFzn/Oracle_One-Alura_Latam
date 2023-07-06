package pila_ejecucion;

public class MiExcepcion extends RuntimeException {
    public MiExcepcion() {
        super();
    }

    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}
