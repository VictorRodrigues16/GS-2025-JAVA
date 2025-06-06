package com.fiap.alertasIncendios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SateliteDto {

    @NotBlank(message = "O nome não pode estar vazio")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "A fonte não pode estar vazia")
    @Size(max = 100, message = "A fonte deve ter no máximo 100 caracteres")
    private String fonte;

    @NotBlank(message = "A resolução não pode estar vazia")
    @Size(max = 50, message = "A resolução deve ter no máximo 50 caracteres")
    private String resolucao;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getFonte() { return fonte; }
    public void setFonte(String fonte) { this.fonte = fonte; }

    public String getResolucao() { return resolucao; }
    public void setResolucao(String resolucao) { this.resolucao = resolucao; }
}
