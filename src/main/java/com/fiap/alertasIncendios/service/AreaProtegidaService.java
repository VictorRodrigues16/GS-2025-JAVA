package com.fiap.alertasIncendios.service;

import com.fiap.alertasIncendios.model.AreaProtegida;
import com.fiap.alertasIncendios.repository.AreaProtegidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaProtegidaService {

    private final AreaProtegidaRepository repository;

    public AreaProtegidaService(AreaProtegidaRepository repository) {
        this.repository = repository;
    }

    public List<AreaProtegida> findAll() {
        return repository.findAll();
    }

    public Optional<AreaProtegida> findById(Long id) {
        return repository.findById(id);
    }

    public AreaProtegida save(AreaProtegida area) {
        return repository.save(area);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
