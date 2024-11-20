package taller1.taller1.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import taller1.taller1.Dto.SuscripcionDTO;
import taller1.taller1.Modelo.Suscripcion;
import taller1.taller1.Mapeadores.SuscripcionMapper;
import taller1.taller1.Repositorio.SuscripcionRepository;


import java.util.Optional;

public class SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    public SuscripcionDTO suscribirUsuario(Long id_usuario, Long id_curso) {
        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setId_usuario(id_usuario);
        suscripcion.setId_curso(id_curso);

        suscripcion = suscripcionRepository.save(suscripcion);
        return SuscripcionMapper.toDTO(suscripcion);
    }

    public boolean cancelarSuscripcion(Long id_usuario, Long id_curso) {
        Optional<Suscripcion> suscripcionOpt = suscripcionRepository.findById_usuarioAndId_curso(id_usuario, id_curso);
        if (suscripcionOpt.isPresent()) {
            suscripcionRepository.delete(suscripcionOpt.get());
            return true;
        }
        return false;
    }

    public Optional<SuscripcionDTO> consultarSuscripcion(Long id_usuario, Long id_curso) {
        Optional<Suscripcion> suscripcionOpt = suscripcionRepository.findById_usuarioAndId_curso(id_usuario, id_curso);
        return suscripcionOpt.map(SuscripcionMapper::toDTO);
    }
    
}
