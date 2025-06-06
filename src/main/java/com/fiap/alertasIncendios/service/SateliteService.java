package com.fiap.alertasIncendios.service;

import com.fiap.alertasIncendios.model.Satelite;
import com.fiap.alertasIncendios.repository.SateliteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SateliteService {

    private final SateliteRepository repository;

    public SateliteService(SateliteRepository repository) {
        this.repository = repository;
    }

    public List<Satelite> findAll() {
        return repository.findAll();
    }


    public Optional<Satelite> findById(Long id) {
        return repository.findById(id);
    }

    public Satelite save(Satelite satelite) {
        return repository.save(satelite);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
