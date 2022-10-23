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
    @Column(name="dni")
    private Long dni;
    @Column(name="correo", length = 60, nullable = false)
    private String correo;
    @Column(name="contrasenia", length = 60, nullable = false)
    private String contrasenia;

    @OneToOne
    @JoinColumn(name = "detail_id", nullable = false)
    private Detail detail;

    public User() {
    }

    public User(String title, Long dni, String correo, String contrasenia, Detail detail) {
        this.title = title;
        this.dni = dni;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.detail = detail;
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

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
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

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
