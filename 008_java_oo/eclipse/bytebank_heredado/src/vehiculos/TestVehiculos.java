package vehiculos;

public class TestVehiculos {
    public static void main(String[] args) {
        Vehiculo m = new Motocicleta();
        m.encender();
        Vehiculo c = new Automovil();
        c.encender();
    }
}
