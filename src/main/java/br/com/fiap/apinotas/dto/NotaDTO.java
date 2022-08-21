package br.com.fiap.apinotas.dto;

import lombok.Data;

@Data
public class NotaDTO {
    private Integer codigo;
    private String texto;
    private Boolean urgente;

    public NotaDTO () {}

    public NotaDTO (Integer codigo, String texto, Boolean urgente) {
        this.codigo = codigo;
        this.texto = texto;
        this.urgente = urgente;
    }

    public NotaDTO (CriarEditarNotaDTO criarEditarNotaDTO)
    {
        this.texto = criarEditarNotaDTO.getTexto();
        this.urgente = criarEditarNotaDTO.getUrgente();
    }
}
