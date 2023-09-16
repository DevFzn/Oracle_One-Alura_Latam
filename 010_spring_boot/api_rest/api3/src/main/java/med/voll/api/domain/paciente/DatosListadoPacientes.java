package med.voll.api.domain.paciente;

public record DatosListadoPacientes(Long id, String nombre, String documento, String email) {

    public DatosListadoPacientes(Paciente paciente) {
        this(paciente.getId(),
                paciente.getNombre(),
                paciente.getDocumento(),
                paciente.getEmail());
    }

}