package com.example.ispit.service;

import com.example.ispit.dto.PolaznikDTO;
import com.example.ispit.entity.Polaznik;
import com.example.ispit.repository.PolaznikRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolaznikService {
    private final PolaznikRepository repo;

    public PolaznikService(PolaznikRepository repo) {
        this.repo = repo;
    }

    public List<PolaznikDTO> getAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PolaznikDTO getById(Long id) {
        return repo.findById(id).map(this::toDTO).orElse(null);
    }

    public PolaznikDTO create(PolaznikDTO dto) {
        Polaznik saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    //mapiranja
    private PolaznikDTO toDTO(Polaznik p) {
        PolaznikDTO dto = new PolaznikDTO();
        dto.setPolaznikID(p.getPolaznikID());
        dto.setIme(p.getIme());
        dto.setPrezime(p.getPrezime());
        return dto;
    }

    private Polaznik toEntity(PolaznikDTO dto) {
        Polaznik p = new Polaznik();
        p.setPolaznikID(dto.getPolaznikID());
        p.setIme(dto.getIme());
        p.setPrezime(dto.getPrezime());
        return p;
    }
}
