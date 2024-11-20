package taller1.taller1.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taller1.taller1.Dto.CursoDTO;
import taller1.taller1.Servicio.CursoService;

import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/crear")
    public ResponseEntity<CursoDTO> crearCurso(@RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.ok(cursoService.crearCurso(cursoDTO));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<CursoDTO> modificarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        CursoDTO dto = cursoService.modificarCurso(id, cursoDTO);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCurso(@PathVariable Long id) {
        if (cursoService.eliminarCurso(id)) {
            return ResponseEntity.ok("Curso eliminado exitosamente");
        }
        return ResponseEntity.badRequest().body("No se encontró el curso");
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<CursoDTO> consultarCurso(@PathVariable Long id) {
        Optional<CursoDTO> dtoOpt = cursoService.consultarCurso(id);
        if (dtoOpt.isPresent()) {
            return ResponseEntity.ok(dtoOpt.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/estado/{id}")
    public ResponseEntity<String> cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        if (cursoService.cambiarEstado(id, estado)) {
            return ResponseEntity.ok("Estado cambiado exitosamente");
        }
        return ResponseEntity.badRequest().body("No se encontró el curso");
    }
}