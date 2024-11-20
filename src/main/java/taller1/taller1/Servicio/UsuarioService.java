package taller1.taller1.Servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taller1.taller1.Dto.UsuarioDTO;
import taller1.taller1.Mapeadores.UsuarioMapper;
import taller1.taller1.Modelo.Usuario;
import taller1.taller1.Repositorio.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> obtenerTodosUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        return UsuarioMapper.toDTO(usuario);
    }

    public boolean crearUsuario(UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.save(UsuarioMapper.toEntity(dto));
        return usuario != null;
    }

    public boolean actualizarUsuario(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        usuario.setIdUsuario(id);
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setContrasena(dto.getContrasena());
        usuario.setEmail(dto.getEmail());
        usuario.setTipoUsuario(dto.getTipoUsuario());
        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return usuarioActualizado != null;
    }

    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false; 
        }
    }
}
