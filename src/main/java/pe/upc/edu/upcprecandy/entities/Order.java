package pe.upc.edu.upcprecandy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", length = 60, nullable = false)
    private String title;
    @Column(name="precio")
    private Long precio;
    @Column(name="categoria", length = 60, nullable = false)
    private String categoria;
    @Column(name="url")
    private String url;
    @Column(name="pais", length = 60, nullable = false)
    private String pais;
    @Column(name="estado", length = 60, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Order() {
    }

    public Order(String title, Long precio, String categoria, String url, String pais, String estado, User user) {
        this.title = title;
        this.precio = precio;
        this.categoria = categoria;
        this.url = url;
        this.pais = pais;
        this.estado = estado;
        this.user = user;
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

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
