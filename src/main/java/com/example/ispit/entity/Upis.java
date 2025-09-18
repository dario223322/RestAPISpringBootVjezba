package com.example.ispit.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
@Table(name = "upis")
public class Upis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upisId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDPolaznik")
    private Polaznik polaznik;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDProgramObrazovanja")
    private ProgramObrazovanja programObrazovanja;



    public Long getUpisId() {
        return upisId;
    }

    public void setUpisId(Long upisId) {
        this.upisId = upisId;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public ProgramObrazovanja getProgramObrazovanja() {
        return programObrazovanja;
    }

    public void setProgramObrazovanja(ProgramObrazovanja programObrazovanja) {
        this.programObrazovanja = programObrazovanja;
    }


}
