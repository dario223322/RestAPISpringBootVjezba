package com.example.ispit.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "programObrazovanja")
public class ProgramObrazovanja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programObrazovanjaId;

    @Column(nullable = false)
    private String naziv;

    @Column
    private int csvet;

    public Long getProgramObrazovanjaId() {
        return programObrazovanjaId;
    }

    public void setProgramObrazovanjaId(Long programObrazovanjaId) {
        this.programObrazovanjaId = programObrazovanjaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getCsvet() {
        return csvet;
    }

    public void setCsvet(int csvet) {
        this.csvet = csvet;
    }
}
