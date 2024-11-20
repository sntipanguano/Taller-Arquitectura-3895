package taller1.taller1.Mapeadores;

import taller1.taller1.Dto.UsuarioDTO;
import taller1.taller1.Modelo.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setContrasena(usuario.getContrasena());
        dto.setEmail(usuario.getEmail());
        dto.setTipoUsuario(usuario.getTipoUsuario());
        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setContrasena(dto.getContrasena());
        usuario.setEmail(dto.getEmail());
        usuario.setTipoUsuario(dto.getTipoUsuario());
        return usuario;
    }
}
