package com.example.m2testing2jorgeaparicio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private Integer ram;
    private Integer cores;
    private String color;
    private Double price;

    public Laptop () {}

    public Laptop(Long id, String modelo, Integer ram, Integer cores, String color, Double price) {
        this.id = id;
        this.modelo = modelo;
        this.ram = ram;
        this.cores = cores;
        this.color = color;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public Integer getRam() { return ram; }
    public void setRam(Integer ram) { this.ram = ram; }
    public Integer getCores() { return cores; }
    public void setCores(Integer cores) { this.cores = cores; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", ram=" + ram +
                ", cores=" + cores +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

