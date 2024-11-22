package taller1.taller1.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taller1.taller1.Dto.SuscripcionDTO;
import taller1.taller1.Servicio.SuscripcionService;

import java.util.Optional;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    // Método GET: Usamos @RequestParam para los parámetros de la URL
    @GetMapping("/consultar")
    public ResponseEntity<SuscripcionDTO> consultarSuscripcion(@RequestParam Long id_usuario, @RequestParam Long id_curso) {
        Optional<SuscripcionDTO> dtoOpt = suscripcionService.consultarSuscripcion(id_usuario, id_curso);
        if (dtoOpt.isPresent()) {
            return ResponseEntity.ok(dtoOpt.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Método POST
    @PostMapping("/suscribir")
    public ResponseEntity<SuscripcionDTO> suscribirUsuario(@RequestBody SuscripcionDTO suscripcionDTO) {
        SuscripcionDTO dto = suscripcionService.suscribirUsuario(suscripcionDTO.getId_usuario(), suscripcionDTO.getId_curso());
        return ResponseEntity.ok(dto);
    }

    // Método DELETE
    @DeleteMapping("/cancelar")
    public ResponseEntity<String> cancelarSuscripcion(@RequestBody SuscripcionDTO suscripcionDTO) {
        boolean resultado = suscripcionService.cancelarSuscripcion(suscripcionDTO.getId_usuario(), suscripcionDTO.getId_curso());
        if (resultado) {
            return ResponseEntity.ok("Suscripción cancelada exitosamente");
        } else {
            return ResponseEntity.badRequest().body("No se encontró la suscripción");
        }
    }
}
