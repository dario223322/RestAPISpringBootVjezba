package com.example.ispit.service;

import com.example.ispit.dto.UpisDTO;
import com.example.ispit.entity.Polaznik;
import com.example.ispit.entity.ProgramObrazovanja;
import com.example.ispit.entity.Upis;
import com.example.ispit.repository.PolaznikRepository;
import com.example.ispit.repository.ProgramObrazovanjaRepository;
import com.example.ispit.repository.UpisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpisService {
    private final UpisRepository repo;
    private final PolaznikRepository polaznikRepo;
    private final ProgramObrazovanjaRepository programRepo;

    public UpisService(UpisRepository repo, PolaznikRepository polaznikRepo, ProgramObrazovanjaRepository programRepo) {
        this.repo = repo;
        this.polaznikRepo = polaznikRepo;
        this.programRepo = programRepo;
    }

    public List<UpisDTO> getAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UpisDTO getById(Long id) {
        return repo.findById(id).map(this::toDTO).orElse(null);

    }

    public UpisDTO create(UpisDTO dto) {
        Polaznik polaznik = polaznikRepo.findById(dto.getPolaznikId())
                .orElseThrow(() -> new RuntimeException("Polaznik not found"));
        ProgramObrazovanja program = programRepo.findById(dto.getProgramObrazovanjaId())
                .orElseThrow(() -> new RuntimeException("Program not found"));

        Upis upis = new Upis();
        upis.setPolaznik(polaznik);
        upis.setProgramObrazovanja(program);

        Upis saved = repo.save(upis);
        return toDTO(saved);

    }

    private UpisDTO toDTO(Upis upis) {
        UpisDTO dto = new UpisDTO();
        dto.setUpisId(upis.getUpisId());
        dto.setPolaznikId(upis.getPolaznik().getPolaznikID());
        dto.setProgramObrazovanjaId(upis.getProgramObrazovanja().getProgramObrazovanjaId());
        return dto;
    }
}
