package edu.coderhouse.Jpa.entity;
import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDateTime;


@Entity
@Table(name = "INVOICES")
public class Invoices {
    public Invoices(){}

    public Invoices(LocalDateTime fecha, Client client) {
        this.fecha = fecha;
        this.client = client;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comprobanteId;

    @Column(name = "FECHA")
    private LocalDateTime fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clientid", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "invoices", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Linea> lineas;

    public Integer getComprobanteId() {
        return comprobanteId;
    }

    public void setComprobanteId(Integer comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }
}
