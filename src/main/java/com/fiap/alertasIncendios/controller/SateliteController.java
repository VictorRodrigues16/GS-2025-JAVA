package com.fiap.alertasIncendios.controller;

import com.fiap.alertasIncendios.dto.SateliteDto;
import com.fiap.alertasIncendios.model.Satelite;
import com.fiap.alertasIncendios.service.SateliteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/satelite")
public class SateliteController {

    private final SateliteService service;

    public SateliteController(SateliteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Satelite> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Satelite> getById(@PathVariable Long id) {

        Optional<Satelite> satelite = service.findById(id);
        return satelite.map(ResponseEntity::ok).orElse(ResponseEntity.status(404).body(
            new Satelite() {{
                setId(id);
                setNome("Satelite não encontrado");
                setFonte("N/A");
                setResolucao("N/A");
            }}
        ));

    }

    @PostMapping
    public Satelite create(@RequestBody @Valid SateliteDto dto) {
        Satelite satelite = new Satelite();
        satelite.setNome(dto.getNome());
        satelite.setFonte(dto.getFonte());
        satelite.setResolucao(dto.getResolucao());
        Satelite created = service.save(satelite);

        return created;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Satelite> update(@PathVariable Long id, @RequestBody @Valid SateliteDto dto) {

        return service.findById(id).map(existing -> {
            Satelite satelite = new Satelite();
            satelite.setId(existing.getId());
            satelite.setNome(dto.getNome());
            satelite.setFonte(dto.getFonte());
            satelite.setResolucao(dto.getResolucao());

            Satelite updated = service.save(satelite);
            System.out.println("Satelite atualizado com sucesso!");
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.status(404).body(
            new Satelite() {{
                setId(id);
                setNome("Satelite não encontrado para atualização");
                setFonte("N/A");
                setResolucao("N/A");
            }}
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
