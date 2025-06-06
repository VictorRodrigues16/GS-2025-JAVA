package com.fiap.alertasIncendios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "area_protegida")
public class AreaProtegida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private Double latitudeCentro;
    private Double longitudeCentro;
    private Double raioKm;


    @OneToOne
    @JoinColumn(name = "id_alerta")
    private AlertaQueimada alertaQueimada;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AlertaQueimada getAlertaQueimada() { return alertaQueimada; }
    public void setAlertaQueimada(AlertaQueimada alertaQueimada) { this.alertaQueimada = alertaQueimada; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Double getLatitudeCentro() { return latitudeCentro; }
    public void setLatitudeCentro(Double latitudeCentro) { this.latitudeCentro = latitudeCentro; }

    public Double getLongitudeCentro() { return longitudeCentro; }
    public void setLongitudeCentro(Double longitudeCentro) { this.longitudeCentro = longitudeCentro; }

    public Double getRaioKm() { return raioKm; }
    public void setRaioKm(Double raioKm) { this.raioKm = raioKm; }

}
