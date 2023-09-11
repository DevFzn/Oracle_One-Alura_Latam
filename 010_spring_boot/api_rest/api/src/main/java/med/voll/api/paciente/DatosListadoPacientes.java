package med.voll.api.paciente;

public record DatosListadoPacientes(String nombre, String documento, String email) {

    public DatosListadoPacientes(Paciente medico) {
        this(medico.getNombre(),
                medico.getDocumento(),
                medico.getEmail());
    }

}