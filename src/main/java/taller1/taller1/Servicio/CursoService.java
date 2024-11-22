package taller1.taller1.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taller1.taller1.Dto.CursoDTO;
import taller1.taller1.Mapeadores.CursoMapper;
import taller1.taller1.Modelo.Curso;
import taller1.taller1.Repositorio.CursoRepository;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoDTO crearCurso(CursoDTO cursoDTO) {
        Curso curso = CursoMapper.toEntity(cursoDTO);
        curso = cursoRepository.save(curso);
        return CursoMapper.toDTO(curso);
    }

    public CursoDTO modificarCurso(Long id, CursoDTO cursoDTO) {
        Optional<Curso> cursoOpt = cursoRepository.findById(id);
        if (cursoOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            curso.setNombre(cursoDTO.getNombre());
            curso.setDescripcion(cursoDTO.getDescripcion());
            curso.setEstado(cursoDTO.getEstado());
            curso.setId_usuario(cursoDTO.getId_usuario());
            return CursoMapper.toDTO(cursoRepository.save(curso));
        }
        return null;
    }

    public boolean eliminarCurso(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<CursoDTO> consultarCurso(Long id) {
        return cursoRepository.findById(id).map(CursoMapper::toDTO);
    }

    public boolean cambiarEstado(Long id, CursoDTO dto) {
        Optional<Curso> cursoOpt = cursoRepository.findById(id);
        if (cursoOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            curso.setEstado(dto.getEstado());
            cursoRepository.save(curso);
            return true;
        }
        return false;
    }
}