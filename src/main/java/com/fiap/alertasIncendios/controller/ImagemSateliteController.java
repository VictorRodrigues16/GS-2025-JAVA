package com.fiap.alertasIncendios.controller;

import com.fiap.alertasIncendios.dto.ImagemSateliteDto;
import com.fiap.alertasIncendios.model.ImagemSatelite;
import com.fiap.alertasIncendios.model.Satelite;
import com.fiap.alertasIncendios.service.ImagemSateliteService;
import com.fiap.alertasIncendios.service.SateliteService;  // Import necessário para o sateliteService
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagemsatelite")
public class ImagemSateliteController {

    private final ImagemSateliteService service;
    private final SateliteService sateliteService;

    public ImagemSateliteController(ImagemSateliteService service, SateliteService sateliteService) {
        this.service = service;
        this.sateliteService = sateliteService;
    }

    @GetMapping
    public List<ImagemSatelite> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagemSatelite> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ImagemSatelite create(@Valid @RequestBody ImagemSateliteDto dto) {
        Satelite satelite = sateliteService.findById(dto.getSateliteId())
                .orElseThrow(() -> new RuntimeException("Satélite não encontrado"));

        ImagemSatelite img = new ImagemSatelite();
        img.setSatelite(satelite);
        img.setDataColeta(dto.getDataColeta());
        img.setLatitude(dto.getLatitude());
        img.setLongitude(dto.getLongitude());

        return service.save(img);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagemSatelite> update(@PathVariable Long id, @Valid @RequestBody ImagemSateliteDto dto) {
        return service.findById(id).map(existing -> {
            Satelite satelite = sateliteService.findById(dto.getSateliteId())
                    .orElseThrow(() -> new RuntimeException("Satélite não encontrado"));

            existing.setSatelite(satelite);
            existing.setDataColeta(dto.getDataColeta());
            existing.setLatitude(dto.getLatitude());
            existing.setLongitude(dto.getLongitude());

            ImagemSatelite updated = service.save(existing);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
