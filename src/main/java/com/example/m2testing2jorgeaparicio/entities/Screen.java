package com.example.m2testing2jorgeaparicio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer inches;
    private Double width;
    private Double height;

    public Screen() {}
    public Screen(Long id, Integer inches, Double width, Double height) {
        this.id = id;
        this.inches = inches;
        this.width = width;
        this.height = height;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getInches() { return inches; }
    public void setInches(Integer inches) { this.inches = inches; }
    public Double getWidth() { return width; }
    public void setWidth(Double width) { this.width = width; }
    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }
    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", inches=" + inches +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
