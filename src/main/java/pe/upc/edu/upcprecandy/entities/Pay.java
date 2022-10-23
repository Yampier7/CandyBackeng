package pe.upc.edu.upcprecandy.entities;

import javax.persistence.*;
import java.sql.Time;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "pays")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="direccion", length = 60, nullable = false)
    private String direccion;
    @Column(name="nTarjeta")
    private Long NTarjeta;
    @Column(name="fecha", length = 60, nullable = false)
    private String fecha;
    @Column(name="cid")
    private Long cid;
    @Column(name="postal")
    private Long postal;



    public Pay() {
    }

    public Pay(String direccion, Long NTarjeta, String fecha, Long cid, Long postal, Detail detail) {
        this.direccion = direccion;
        this.NTarjeta = NTarjeta;
        this.fecha = fecha;
        this.cid = cid;
        this.postal = postal;
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

    public Long getNTarjeta() {
        return NTarjeta;
    }

    public void setNTarjeta(Long NTarjeta) {
        this.NTarjeta = NTarjeta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getPostal() {
        return postal;
    }

    public void setPostal(Long postal) {
        this.postal = postal;
    }

}
