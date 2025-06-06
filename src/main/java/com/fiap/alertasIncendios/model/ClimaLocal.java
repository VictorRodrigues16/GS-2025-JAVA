package com.fiap.alertasIncendios.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ClimaLocal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataMedicao;
    private Double latitude;
    private Double longitude;
    private Double temperatura;
    private Double umidade;
    private Double vento;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDataMedicao() { return dataMedicao; }
    public void setDataMedicao(LocalDate dataMedicao) { this.dataMedicao = dataMedicao; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Double getTemperatura() { return temperatura; }
    public void setTemperatura(Double temperatura) { this.temperatura = temperatura; }

    public Double getUmidade() { return umidade; }
    public void setUmidade(Double umidade) { this.umidade = umidade; }

    public Double getVento() { return vento; }
    public void setVento(Double vento) { this.vento = vento; }
}