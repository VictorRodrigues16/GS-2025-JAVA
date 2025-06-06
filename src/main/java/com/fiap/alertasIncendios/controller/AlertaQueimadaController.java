package com.fiap.alertasIncendios.controller;

import com.fiap.alertasIncendios.dto.AlertaQueimadaDto;
import com.fiap.alertasIncendios.model.AlertaQueimada;
import com.fiap.alertasIncendios.model.ImagemSatelite;
import com.fiap.alertasIncendios.service.AlertaQueimadaService;
import com.fiap.alertasIncendios.service.ImagemSateliteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertaqueimada")
public class AlertaQueimadaController {

    private final AlertaQueimadaService service;
    private final ImagemSateliteService imagemSateliteService;

    public AlertaQueimadaController(AlertaQueimadaService service, ImagemSateliteService imagemSateliteService) {
        this.service = service;
        this.imagemSateliteService = imagemSateliteService;
    }

    @GetMapping
    public List<AlertaQueimada> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaQueimada> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body(
                        new AlertaQueimada() {{
                            setId(id);
                            setRisco("Alerta não encontrado");
                            setProbabilidade(0.0);
                            setAreaEstimada(0.0);
                            setDataAlerta(null);
                        }}
                ));
    }

    @PostMapping
    public ResponseEntity<AlertaQueimada> create(@Valid @RequestBody AlertaQueimadaDto dto) {
        ImagemSatelite imgSatelite = imagemSateliteService.findById(dto.getIdImagem())
                .orElseThrow(() -> new RuntimeException("Imagem de satélite não encontrada"));

        AlertaQueimada alerta = new AlertaQueimada();
        alerta.setProbabilidade(dto.getProbabilidade());
        alerta.setAreaEstimada(dto.getAreaEstimada());
        alerta.setRisco(dto.getRisco());
        alerta.setDataAlerta(dto.getDataAlerta());
        alerta.setImagemSatelite(imgSatelite);

        AlertaQueimada saved = service.save(alerta);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertaQueimada> update(@PathVariable Long id, @Valid @RequestBody AlertaQueimadaDto dto) {
        return service.findById(id).map(existing -> {
            existing.setProbabilidade(dto.getProbabilidade());
            existing.setAreaEstimada(dto.getAreaEstimada());
            existing.setRisco(dto.getRisco());
            existing.setDataAlerta(dto.getDataAlerta());

            AlertaQueimada updated = service.save(existing);
            System.out.println("AlertaQueimada atualizado com sucesso!");
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.status(404).body(
                new AlertaQueimada() {{
                    setId(id);
                    setRisco("Alerta não encontrado para atualização");
                    setProbabilidade(0.0);
                    setAreaEstimada(0.0);
                    setDataAlerta(null);
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
