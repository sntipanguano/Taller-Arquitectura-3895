package taller1.taller1.Dto;

public class SuscripcionDTO {

    private Long id_suscripcion;
    private Long id_usuario;
    private Long id_curso;

    // Getters y Setters
    public Long getId_suscripcion() {
        return id_suscripcion;
    }
    
    public void setId_suscripcion(Long id_suscripcion) {
        this.id_suscripcion = id_suscripcion;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }
}
