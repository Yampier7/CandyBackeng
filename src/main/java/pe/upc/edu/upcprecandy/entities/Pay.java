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
    private Number NTarjeta;
    @Column(name="fecha", length = 60, nullable = false)
    private String fecha;
    @Column(name="cid")
    private Number cid;
    @Column(name="postal")
    private Number postal;



    public Pay() {
    }

    public Pay(String direccion, Number NTarjeta, String fecha, Number cid, Number postal) {
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

    public Number getNTarjeta() {
        return NTarjeta;
    }

    public void setNTarjeta(Number NTarjeta) {
        this.NTarjeta = NTarjeta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Number getCid() {
        return cid;
    }

    public void setCid(Number cid) {
        this.cid = cid;
    }

    public Number getPostal() {
        return postal;
    }

    public void setPostal(Number postal) {
        this.postal = postal;
    }

}
