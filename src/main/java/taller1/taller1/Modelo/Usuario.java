package taller1.taller1.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_usuario")
    private Long id_usuario;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "contrasena")
    private String contrasena;
    
    @JsonProperty("tipo_usuario")
    private String tipo_usuario;

    public void setApellido(String Apellido) {
        apellido = Apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setContrasena(String Contrasena) {
        contrasena = Contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setEmail(String Email) {
        email = Email;
    }

    public String getEmail() {
        return email;
    }

    public void setIdUsuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getIdUsuario() {
        return id_usuario;
    }

    public void setNombre(String Nombre) {
        nombre = Nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setTipoUsuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getTipoUsuario() {
        return tipo_usuario;
    }
}
