package com.example.ispit.service;


import com.example.ispit.dto.ProgramObrazovanjaDTO;
import com.example.ispit.entity.ProgramObrazovanja;
import com.example.ispit.repository.ProgramObrazovanjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class ProgramObrazovanjaService {
    private final ProgramObrazovanjaRepository repo;

    public ProgramObrazovanjaService(ProgramObrazovanjaRepository repo) {
        this.repo = repo;
    }

    public List<ProgramObrazovanjaDTO> getAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProgramObrazovanjaDTO getById(Long id) {
        return repo.findById(id).map(this::toDTO).orElse(null);
    }

    public ProgramObrazovanjaDTO create(ProgramObrazovanjaDTO dto) {
        ProgramObrazovanja saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    private ProgramObrazovanjaDTO toDTO(ProgramObrazovanja p) {
        ProgramObrazovanjaDTO dto = new ProgramObrazovanjaDTO();
        dto.setProgramObrazovanjaId(p.getProgramObrazovanjaId());
        dto.setNaziv(p.getNaziv());
        dto.setCsvet(p.getCsvet());
        return dto;
    }

    private ProgramObrazovanja toEntity(ProgramObrazovanjaDTO dto) {
        ProgramObrazovanja p = new ProgramObrazovanja();
        p.setProgramObrazovanjaId(dto.getProgramObrazovanjaId());
        p.setNaziv(dto.getNaziv());
        p.setCsvet(dto.getCsvet());
        return p;
    }
}
