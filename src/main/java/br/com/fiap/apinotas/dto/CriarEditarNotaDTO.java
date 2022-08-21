package br.com.fiap.apinotas.dto;

import lombok.Data;

@Data
public class CriarEditarNotaDTO {
    private String texto;
    private Boolean urgente;
}
