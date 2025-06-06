package com.fiap.alertasIncendios.service;

import com.fiap.alertasIncendios.model.ImagemSatelite;
import com.fiap.alertasIncendios.repository.ImagemSateliteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemSateliteService {

    private final ImagemSateliteRepository repository;

    public ImagemSateliteService(ImagemSateliteRepository repository) {
        this.repository = repository;
    }

    public List<ImagemSatelite> findAll() {
        return repository.findAll();
    }

    public Optional<ImagemSatelite> findById(Long id) {
        return repository.findById(id);
    }

    public ImagemSatelite save(ImagemSatelite imagemSatelite) {
        return repository.save(imagemSatelite);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
