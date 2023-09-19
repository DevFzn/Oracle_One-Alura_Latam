package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);

    //@Query("select Medico from Medico m where m.activo=true and m.especialidad=:especialidad")
    //@Query("""
    //        SELECT m FROM Medico m
    //        WHERE m.activo=1 and
    //        m.especialidad=:especialidad and
    //        m.id NOT IN(
    //            SELECT c.medico.id FROM Consulta c
    //            WHERE c.fecha=:fecha
    //        ) ORDER BY RAND() LIMIT 1
    //        """)
    //@Query("""
    //    SELECT m FROM Medico m
    //    WHERE m.activo=true
    //    AND  m.especialidad=?1 AND m.id NOT IN(
    //        SELECT c.medico.id FROM Consulta c
    //        WHERE c.fecha=?2
    //   ) ORDER BY RAND() LIMIT 1
    //   """)
    @Query("""
            select m from Medico m
                where m.activo= true\s
                and
                m.especialidad=:especialidad\s
                and
                m.id not in( \s
                    select c.medico.id from Consulta c
                    where
                    c.fecha=:fecha
                )
                order by rand()
                limit 1
            """)
    Medico seleccionarMedicoConEspecialidadEnFecha(Especialidad especialidad, LocalDateTime fecha);

    @Query("""
            SELECT m.activo 
            FROM Medico m 
            WHERE m.id=:idMedico
            """)
    Boolean findActivoById(Long idMedico);

}
