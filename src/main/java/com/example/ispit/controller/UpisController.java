package com.example.ispit.controller;


import com.example.ispit.dto.UpisDTO;
import com.example.ispit.service.UpisService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/upisi")
public class UpisController {
    private final UpisService service;

    public UpisController(UpisService service) {
        this.service = service;
    }

    @GetMapping
    public List<UpisDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpisDTO> getOne(@PathVariable Long id) {
        UpisDTO dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UpisDTO> create(@Valid @RequestBody UpisDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }
}
