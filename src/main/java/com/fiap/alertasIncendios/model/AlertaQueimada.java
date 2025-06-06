package com.fiap.alertasIncendios.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alerta_queimada")
public class AlertaQueimada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double probabilidade;
    private Double areaEstimada;
    private String risco;
    private LocalDate dataAlerta;


    @OneToOne
    @JoinColumn(name = "id_imagem")
    private ImagemSatelite imagemSatelite;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ImagemSatelite getImagemSatelite() { return imagemSatelite; }
    public void setImagemSatelite(ImagemSatelite imagemSatelite) { this.imagemSatelite = imagemSatelite; }

    public Double getProbabilidade() { return probabilidade; }
    public void setProbabilidade(Double probabilidade) { this.probabilidade = probabilidade; }

    public Double getAreaEstimada() { return areaEstimada; }
    public void setAreaEstimada(Double areaEstimada) { this.areaEstimada = areaEstimada; }

    public String getRisco() { return risco; }
    public void setRisco(String risco) { this.risco = risco; }

    public LocalDate getDataAlerta() { return dataAlerta; }
    public void setDataAlerta(LocalDate dataAlerta) { this.dataAlerta = dataAlerta; }

}
