package taller1.taller1.Mapeadores;

import taller1.taller1.Dto.SuscripcionDTO;
import taller1.taller1.Modelo.Suscripcion;

public class SuscripcionMapper {

    public static SuscripcionDTO toDTO(Suscripcion suscripcion) {
        SuscripcionDTO dto = new SuscripcionDTO();
        dto.setId_suscripcion(suscripcion.getId_suscripcion());
        dto.setId_usuario(suscripcion.getId_usuario());
        dto.setId_curso(suscripcion.getId_curso());
        return dto;
    }

    public static Suscripcion toEntity(SuscripcionDTO dto) {
        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setId_suscripcion(dto.getId_suscripcion());
        suscripcion.setId_usuario(dto.getId_usuario());
        suscripcion.setId_curso(dto.getId_curso());
        return suscripcion;
    }
    
}
