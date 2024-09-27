package edu.coderhouse.Jpa.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "LINEA")
public class Linea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lineaId;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CANTIDAD")
    private int cantidad;

    @Column(name = "PRECIO")
    private float precio;

    @ManyToOne
    @JoinColumn(name = "COMPROBANTEID", nullable = false)
    private Invoices invoices;

    @ManyToOne
    @JoinColumn(name = "PRODUCTOID", nullable = false)
    private Products products;

    // Constructor vacío
    public Linea() {}

    // Constructor con parámetros
    public Linea(String descripcion, int cantidad, float precio, Invoices invoices, Products products) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.invoices = invoices;
        this.products = products;
    }

    // Getters y Setters
    public Integer getLineaId() {
        return lineaId;
    }

    public void setLineaId(Integer lineaId) {
        this.lineaId = lineaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Invoices getInvoices() {
        return invoices;
    }

    public void setInvoices(Invoices invoices) {
        this.invoices = invoices;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}

