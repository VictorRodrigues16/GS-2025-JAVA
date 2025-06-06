package com.fiap.alertasIncendios.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AreaProtegidaDto {

    private Long id;

    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Tipo é obrigatório")
    private String tipo;

    @NotNull(message = "Latitude do centro é obrigatória")
    private Double latitudeCentro;

    @NotNull(message = "Longitude do centro é obrigatória")
    private Double longitudeCentro;

    @NotNull(message = "Raio em Km é obrigatório")
    @Positive(message = "Raio deve ser positivo")
    private Double raioKm;

    @NotNull(message = "ID do alerta é obrigatório")
    private Long idAlerta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getLatitudeCentro() {
        return latitudeCentro;
    }

    public void setLatitudeCentro(Double latitudeCentro) {
        this.latitudeCentro = latitudeCentro;
    }

    public Double getLongitudeCentro() {
        return longitudeCentro;
    }

    public void setLongitudeCentro(Double longitudeCentro) {
        this.longitudeCentro = longitudeCentro;
    }

    public Double getRaioKm() {
        return raioKm;
    }

    public void setRaioKm(Double raioKm) {
        this.raioKm = raioKm;
    }

    public Long getIdAlerta() {return idAlerta;}
    public void setIdAlerta(Long idAlerta) {this.idAlerta = idAlerta;}


}
