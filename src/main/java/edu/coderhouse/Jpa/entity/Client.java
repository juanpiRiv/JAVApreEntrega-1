package edu.coderhouse.Jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {

    public Client (){}

    public Client(String name, String lastname, String dni ) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "DNI")
    private String dni;

    @OneToMany (mappedBy = "client" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Adress> addresses;




}
