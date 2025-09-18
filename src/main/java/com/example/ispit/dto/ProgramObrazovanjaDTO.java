package com.example.ispit.dto;

public class ProgramObrazovanjaDTO {
    private Long programObrazovanjaId;

    private String naziv;

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
