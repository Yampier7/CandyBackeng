package pe.upc.edu.upcprecandy.entities;

import javax.persistence.*;

@Entity
@Table(name="products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", length = 60, nullable = false)
    private String title;
    @Column(name="pais", length = 60, nullable = false)
    private String pais;
    @Column(name="precio")
    private Number precio;
    @Column(name="categoria", length = 60, nullable = false)
    private String categoria;
    @Column(name="url")
    private String url;

    public Product() {
    }

    public Product(String title, String pais, Number precio, String categoria, String url) {
        this.title = title;
        this.pais = pais;
        this.precio = precio;
        this.categoria = categoria;
        this.url = url;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Number getPrecio() {
        return precio;
    }

    public void setPrecio(Number precio) {
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
}
