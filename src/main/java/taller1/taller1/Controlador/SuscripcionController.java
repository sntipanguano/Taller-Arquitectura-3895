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

    @GetMapping("/consultar")
    public ResponseEntity<SuscripcionDTO> consultarSuscripcion(@RequestParam Long id_usuario, @RequestParam Long id_curso) {
        Optional<SuscripcionDTO> dtoOpt = suscripcionService.consultarSuscripcion(id_usuario, id_curso);
        if (dtoOpt.isPresent()) {
            return ResponseEntity.ok(dtoOpt.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/suscribir")
    public ResponseEntity<SuscripcionDTO> suscribirUsuario(@RequestParam Long id_usuario, @RequestParam Long id_curso) {
        SuscripcionDTO dto = suscripcionService.suscribirUsuario(id_usuario, id_curso);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/cancelar")
    public ResponseEntity<String> cancelarSuscripcion(@RequestParam Long id_usuario, @RequestParam Long id_curso) {
        boolean resultado = suscripcionService.cancelarSuscripcion(id_usuario, id_curso);
        if (resultado) {
            return ResponseEntity.ok("Suscripción cancelada exitosamente");
        } else {
            return ResponseEntity.badRequest().body("No se encontró la suscripción");
        }
    }
}
