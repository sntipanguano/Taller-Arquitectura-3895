package taller1.taller1.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import taller1.taller1.Modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}