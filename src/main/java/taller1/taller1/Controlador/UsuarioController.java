package taller1.taller1.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import taller1.taller1.Dto.UsuarioDTO;
import taller1.taller1.Servicio.UsuarioService;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioService.obtenerTodosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO dto) {
        boolean resultado = usuarioService.crearUsuario(dto);
        if (resultado) {
            return ResponseEntity.ok("Usuario creado exitosamente");
        } else {
            return ResponseEntity.badRequest().body("No se pudo crear el usuario");
        }
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Long id,@RequestBody UsuarioDTO dto) {
        boolean resultado = usuarioService.actualizarUsuario(id,dto);
        if (resultado) {
            return ResponseEntity.ok("Usuario actualizado exitosamente");
        } else {
            return ResponseEntity.badRequest().body("No se pudo actualizar el usuario");
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Long id) {
        boolean resultado = usuarioService.eliminarUsuario(id);
        if (resultado) {
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } else {
            return ResponseEntity.badRequest().body("No se pudo eliminar el usuario");
        }
    }
}
