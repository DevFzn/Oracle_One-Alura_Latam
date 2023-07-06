package bytebank_excep;

public class SaldoInsuficienteExcepction extends Exception {
    public SaldoInsuficienteExcepction(String mensaje) {
        super(mensaje);
    }
}
