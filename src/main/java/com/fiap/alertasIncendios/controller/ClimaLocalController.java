package com.fiap.alertasIncendios.controller;

import com.fiap.alertasIncendios.dto.ClimaLocalDto;
import com.fiap.alertasIncendios.model.ClimaLocal;
import com.fiap.alertasIncendios.service.ClimaLocalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/climalocal")
public class ClimaLocalController {

    private final ClimaLocalService service;

    public ClimaLocalController(ClimaLocalService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClimaLocal> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body(
                        new ClimaLocal() {{
                            setId(id);
                            setDataMedicao(null);
                            setLatitude(null);
                            setLongitude(null);
                            setTemperatura(null);
                            setUmidade(null);
                            setVento(null);
                        }}
                ));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ClimaLocalDto dto) {
        ClimaLocal clima = new ClimaLocal();
        clima.setDataMedicao(dto.getDataMedicao());
        clima.setLatitude(dto.getLatitude());
        clima.setLongitude(dto.getLongitude());
        clima.setTemperatura(dto.getTemperatura());
        clima.setUmidade(dto.getUmidade());
        clima.setVento(dto.getVento());

        ClimaLocal saved = service.save(clima);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ClimaLocalDto dto) {
        return service.findById(id).map(existing -> {
            existing.setDataMedicao(dto.getDataMedicao());
            existing.setLatitude(dto.getLatitude());
            existing.setLongitude(dto.getLongitude());
            existing.setTemperatura(dto.getTemperatura());
            existing.setUmidade(dto.getUmidade());
            existing.setVento(dto.getVento());

            ClimaLocal updated = service.save(existing);
            System.out.println("ClimaLocal atualizado com sucesso!");
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.status(404).body(
                new ClimaLocal() {{
                    setId(id);
                    setDataMedicao(null);
                    setLatitude(null);
                    setLongitude(null);
                    setTemperatura(null);
                    setUmidade(null);
                    setVento(null);
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
