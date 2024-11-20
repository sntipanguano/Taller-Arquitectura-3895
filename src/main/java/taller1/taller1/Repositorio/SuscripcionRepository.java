package taller1.taller1.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import taller1.taller1.Modelo.Suscripcion;

import java.util.List;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {
    List<Suscripcion> findAllByIdCurso(Long id_curso);
}
