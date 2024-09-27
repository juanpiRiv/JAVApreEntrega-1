package edu.coderhouse.Jpa.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "ADRESS")
public class Adress {

    public Adress() {}

    public Adress(String street, int number, String floor, String departament, String cp, String location, String state, Client client) {
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.departament = departament;
        this.cp = cp;
        this.location = location;
        this.state = state;
        this.client = client;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER")
    private int number;

    @Column(name = "FLOOR")
    private String floor;

    @Column(name = "DEPARTAMENT")
    private String departament;

    @Column(name = "CP")
    private String cp;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "STATE")
    private String state;

    @ManyToOne
    @JoinColumn(name = "CLIENTID", nullable = false)
    private Client client;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

