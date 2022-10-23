package pe.upc.edu.upcprecandy.entities;

import javax.persistence.*;

@Entity
@Table(name = "shippings")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="direccion", length = 60, nullable = false)
    private String direccion;
    @Column(name="postal")
    private Long postal;
    @Column(name="referencia", length = 60, nullable = false)
    private String referencia;
    @Column(name="calle", length = 60, nullable = false)
    private String calle;
    @Column(name="tipoEnvio", length = 60, nullable = false)
    private String tipoEnvio;

    @OneToOne
    @JoinColumn(name = "detail_id", nullable = false)
    private Detail detail;

    public Shipping() {
    }

    public Shipping(String direccion, Long postal, String referencia, String calle, String tipoEnvio, Detail detail) {
        this.direccion = direccion;
        this.postal = postal;
        this.referencia = referencia;
        this.calle = calle;
        this.tipoEnvio = tipoEnvio;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getPostal() {
        return postal;
    }

    public void setPostal(Long postal) {
        this.postal = postal;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
