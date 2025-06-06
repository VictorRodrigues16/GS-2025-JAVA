package com.fiap.alertasIncendios.service;

import com.fiap.alertasIncendios.model.AlertaQueimada;
import com.fiap.alertasIncendios.repository.AlertaQueimadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaQueimadaService {

    private final AlertaQueimadaRepository repository;

    public AlertaQueimadaService(AlertaQueimadaRepository repository) {
        this.repository = repository;
    }

    public List<AlertaQueimada> findAll() {
        return repository.findAll();
    }

    public Optional<AlertaQueimada> findById(Long id) {
        return repository.findById(id);
    }

    public AlertaQueimada save(AlertaQueimada alerta) {
        return repository.save(alerta);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
