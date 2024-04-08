package com.example.OneToMany.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CARS_DETAILS")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "version")
    private String version;

    @Column(name = "color")
    private String color;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Cars(){}

    public Cars(int id,String brand, String version, String color, Owner owner) {
        this.id = id;
        this.brand = brand;
        this.version = version;
        this.color = color;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
