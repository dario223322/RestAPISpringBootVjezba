package com.example.ispit.controller;

import com.example.ispit.dto.PolaznikDTO;
import com.example.ispit.service.PolaznikService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/polaznici")
public class PolaznikController {
    private final PolaznikService service;

    public PolaznikController(PolaznikService service) {
        this.service = service;
    }

    @GetMapping
    public List<PolaznikDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolaznikDTO> getOne(@PathVariable Long id) {
        PolaznikDTO dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<PolaznikDTO> create(@Valid @RequestBody PolaznikDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }
}
