package taller1.taller1.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import taller1.taller1.Modelo.Usuario;
import taller1.taller1.Repositorio.UsuarioRepository;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @GetMapping
    public List<Usuario> obtenerUsuarioUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepositorio.save(usuario));
    }
}
