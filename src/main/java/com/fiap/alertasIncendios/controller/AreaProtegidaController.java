package com.fiap.alertasIncendios.controller;
import com.fiap.alertasIncendios.dto.AreaProtegidaDto;
import com.fiap.alertasIncendios.model.AlertaQueimada;
import com.fiap.alertasIncendios.model.AreaProtegida;
import com.fiap.alertasIncendios.service.AreaProtegidaService;
import com.fiap.alertasIncendios.service.AlertaQueimadaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areaprotegida")
public class AreaProtegidaController {

    private final AreaProtegidaService service;
    private final AlertaQueimadaService alertaQueimadaService;

    public AreaProtegidaController(AreaProtegidaService service, AlertaQueimadaService alertaQueimadaService) {
        this.service = service;
        this.alertaQueimadaService = alertaQueimadaService;
    }

    @GetMapping
    public List<AreaProtegida> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaProtegida> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body(
                        new AreaProtegida() {{
                            setId(id);
                            setNome("Área Protegida não encontrada");
                        }}
                ));
    }

    @PostMapping
    public ResponseEntity<AreaProtegida> create(@Valid @RequestBody AreaProtegidaDto dto) {
        AlertaQueimada alertaQueimada = alertaQueimadaService.findById(dto.getIdAlerta())
                .orElseThrow(() -> new RuntimeException("Imagem de satélite não encontrada"));

        AreaProtegida area = new AreaProtegida();
        area.setNome(dto.getNome());
        area.setTipo(dto.getTipo());
        area.setLatitudeCentro(dto.getLatitudeCentro());
        area.setLongitudeCentro(dto.getLongitudeCentro());
        area.setRaioKm(dto.getRaioKm());
        area.setAlertaQueimada(alertaQueimada);

        AreaProtegida saved = service.save(area);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaProtegida> update(@PathVariable Long id, @Valid @RequestBody AreaProtegidaDto dto) {
        return service.findById(id).map(existing -> {
            existing.setNome(dto.getNome());
            existing.setTipo(dto.getTipo());
            existing.setLatitudeCentro(dto.getLatitudeCentro());
            existing.setLongitudeCentro(dto.getLongitudeCentro());
            existing.setRaioKm(dto.getRaioKm());


            AreaProtegida updated = service.save(existing);
            System.out.println("Área Protegida atualizada com sucesso!");
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.status(404).body(
                new AreaProtegida() {{
                    setId(id);
                    setNome("Área Protegida não encontrada para atualização");
                }}
        ));
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
