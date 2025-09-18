package com.example.ispit.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "polaznik")
public class Polaznik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long polaznikID;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    public Long getPolaznikID() {
        return polaznikID;
    }

    public void setPolaznikID(Long polaznikID) {
        this.polaznikID = polaznikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
