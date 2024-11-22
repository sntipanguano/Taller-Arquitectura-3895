package taller1.taller1.Modelo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_usuario")
    private Long id_usuario;
    
    @Column(name = "nombre",nullable = false)
    @NotBlank(message = "El tipo de usuario no puede estar vacío")
    private String nombre;

    @Column(name = "apellido",nullable = false)
    @NotBlank(message = "El tipo de usuario no puede estar vacío")
    private String apellido;

    @Column(name = "email",nullable = false)
    @NotBlank(message = "El tipo de usuario no puede estar vacío")
    private String email;

    @Column(name = "contrasena",nullable = false)
    @NotBlank(message = "El tipo de usuario no puede estar vacío")
    private String contrasena;

    @Column(name = "tipo_usuario",nullable = false)
    @JsonProperty("tipo_usuario")
    @NotBlank(message = "El tipo de usuario no puede estar vacío")
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
