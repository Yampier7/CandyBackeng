package pe.upc.edu.upcprecandy.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", length = 60, nullable = false)
    private String title;
    @Column(name="apellido")
    private String apellido;
    @Column(name="correo", length = 60, nullable = false)
    private String correo;
    @Column(name="contrasenia", length = 60, nullable = false)
    private String contrasenia;

    public User() {
    }

    public User(String title, String apellido, String correo, String contrasenia) {
        this.title = title;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
