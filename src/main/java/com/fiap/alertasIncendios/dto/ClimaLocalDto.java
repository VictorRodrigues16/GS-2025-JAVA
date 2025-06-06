package com.fiap.alertasIncendios.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClimaLocalDto {

    @NotNull(message = "Data da medição é obrigatória")
    private LocalDate dataMedicao;

    @NotNull(message = "Latitude é obrigatória")
    private Double latitude;

    @NotNull(message = "Longitude é obrigatória")
    private Double longitude;

    @NotNull(message = "Temperatura é obrigatória")
    private Double temperatura;

    @NotNull(message = "Umidade é obrigatória")
    private Double umidade;

    @NotNull(message = "Vento é obrigatório")
    private Double vento;


    public LocalDate getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(LocalDate dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    public Double getVento() {
        return vento;
    }

    public void setVento(Double vento) {
        this.vento = vento;
    }
}
