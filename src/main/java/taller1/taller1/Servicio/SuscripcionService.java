package taller1.taller1.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taller1.taller1.Dto.SuscripcionDTO;
import taller1.taller1.Modelo.Suscripcion;
import taller1.taller1.Mapeadores.SuscripcionMapper;
import taller1.taller1.Repositorio.SuscripcionRepository;

import java.util.List;
import java.util.Optional;

@Service
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
        List<Suscripcion> suscripciones = suscripcionRepository.findAllByIdCurso(id_curso);
        // Verificar si existe una suscripción asociada al usuario y curso
        for (Suscripcion suscripcion : suscripciones) {
            if (suscripcion.getId_usuario().equals(id_usuario)) {
                // Eliminar la suscripción encontrada
                suscripcionRepository.delete(suscripcion);
                System.out.println("La suscripción ha sido cancelada con éxito.");
                return true;
            }
        }

        // Si no se encuentra una suscripción válida
        System.out.println("No se encontró una suscripción para el usuario y curso especificados.");
        return false;
    }

    public Optional<SuscripcionDTO> consultarSuscripcion(Long id_usuario, Long id_curso) {
        // Buscar la suscripción
        List<Suscripcion> suscripciones = suscripcionRepository.findAllByIdCurso(id_curso);
        // Buscar la suscripción que pertenezca al usuario
        return suscripciones.stream()
            .filter(suscripcion -> suscripcion.getId_usuario().equals(id_usuario))
            .findFirst()
            .map(SuscripcionMapper::toDTO);
    }
    
}
