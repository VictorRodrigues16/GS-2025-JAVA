package com.fiap.alertasIncendios.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ImagemSateliteDto {

    @NotNull(message = "O id do satélite é obrigatório")
    private Long sateliteId;

    @NotNull(message = "A data de coleta é obrigatória")
    private LocalDate dataColeta;

    @NotNull(message = "A latitude é obrigatória")
    @DecimalMin(value = "-90.0", message = "Latitude mínima é -90")
    @DecimalMax(value = "90.0", message = "Latitude máxima é 90")
    private Double latitude;

    @NotNull(message = "A longitude é obrigatória")
    @DecimalMin(value = "-180.0", message = "Longitude mínima é -180")
    @DecimalMax(value = "180.0", message = "Longitude máxima é 180")
    private Double longitude;

    public Long getSateliteId() {
        return sateliteId;
    }

    public void setSateliteId(Long sateliteId) {
        this.sateliteId = sateliteId;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
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
}
