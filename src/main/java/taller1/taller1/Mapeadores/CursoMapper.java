package taller1.taller1.Mapeadores;

import taller1.taller1.Dto.CursoDTO;
import taller1.taller1.Modelo.Curso;

public class CursoMapper {

    public static CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId_curso(curso.getId_curso());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setEstado(curso.getEstado());
        dto.setId_usuario(curso.getId_usuario());
        return dto;
    }

    public static Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setId_curso(dto.getId_curso());
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setEstado(dto.getEstado());
        curso.setId_usuario(dto.getId_usuario());
        return curso;
    }
}