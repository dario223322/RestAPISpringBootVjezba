package com.example.ispit.dto;

import jakarta.validation.constraints.NotNull;

public class UpisDTO {
    private Long upisId;

    @NotNull
    private Long polaznikId;

    @NotNull
    private Long programObrazovanjaId;

    public Long getUpisId() {
        return upisId;
    }

    public void setUpisId(Long upisId) {
        this.upisId = upisId;
    }

    public Long getPolaznikId() {
        return polaznikId;
    }

    public void setPolaznikId(Long polaznikId) {
        this.polaznikId = polaznikId;
    }

    public Long getProgramObrazovanjaId() {
        return programObrazovanjaId;
    }

    public void setProgramObrazovanjaId(Long programObrazovanjaId) {
        this.programObrazovanjaId = programObrazovanjaId;
    }
}
