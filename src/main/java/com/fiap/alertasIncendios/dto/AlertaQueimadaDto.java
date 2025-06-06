package com.fiap.alertasIncendios.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class AlertaQueimadaDto {

    @NotNull(message = "Probabilidade é obrigatória")
    @DecimalMin(value = "0.0", inclusive = true, message = "Probabilidade deve ser >= 0")
    @DecimalMax(value = "1.0", inclusive = true, message = "Probabilidade deve ser <= 1")
    private Double probabilidade;

    @NotNull(message = "Área estimada é obrigatória")
    @PositiveOrZero(message = "Área estimada deve ser >= 0")
    private Double areaEstimada;

    @NotBlank(message = "Risco é obrigatório")
    private String risco;

    @NotNull(message = "Data do alerta é obrigatória")
    private LocalDate dataAlerta;

    @NotNull(message = "ID da imagem é obrigatório")
    private Long idImagem;

    public Double getProbabilidade() { return probabilidade; }
    public void setProbabilidade(Double probabilidade) { this.probabilidade = probabilidade; }

    public Double getAreaEstimada() { return areaEstimada; }
    public void setAreaEstimada(Double areaEstimada) { this.areaEstimada = areaEstimada; }

    public String getRisco() { return risco; }
    public void setRisco(String risco) { this.risco = risco; }

    public LocalDate getDataAlerta() { return dataAlerta; }
    public void setDataAlerta(LocalDate dataAlerta) { this.dataAlerta = dataAlerta; }

    public Long getIdImagem() { return idImagem; }
    public void setIdImagem(Long idImagem) { this.idImagem = idImagem; }

}
