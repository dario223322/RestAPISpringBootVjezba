package com.example.ispit.controller;


import com.example.ispit.dto.ProgramObrazovanjaDTO;
import com.example.ispit.service.ProgramObrazovanjaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programObrazovanja")
public class ProgramObrazovanjaController {
    private final ProgramObrazovanjaService service;

    public ProgramObrazovanjaController(ProgramObrazovanjaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProgramObrazovanjaDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramObrazovanjaDTO> getOne(@PathVariable Long id) {
        ProgramObrazovanjaDTO dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProgramObrazovanjaDTO> create(@Valid @RequestBody ProgramObrazovanjaDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }
}
