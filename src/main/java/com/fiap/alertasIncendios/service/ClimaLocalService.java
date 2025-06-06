package com.fiap.alertasIncendios.service;

import com.fiap.alertasIncendios.model.ClimaLocal;
import com.fiap.alertasIncendios.repository.ClimaLocalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClimaLocalService {

    private final ClimaLocalRepository repository;

    public ClimaLocalService(ClimaLocalRepository repository) {
        this.repository = repository;
    }

    public List<ClimaLocal> findAll() {
        return repository.findAll();
    }

    public Optional<ClimaLocal> findById(Long id) {
        return repository.findById(id);
    }

    public ClimaLocal save(ClimaLocal climaLocal) {
        return repository.save(climaLocal);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
