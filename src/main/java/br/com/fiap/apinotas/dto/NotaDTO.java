package br.com.fiap.apinotas.dto;

import br.com.fiap.apinotas.entity.NotaEntity;
import lombok.Data;

import java.util.Date;

@Data
public class NotaDTO {
    private Integer codigo;
    private String texto;
    private Boolean urgente;
    private Date dataHoraCadastro;

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

    public NotaDTO (NotaEntity notaEntity){
        this.codigo = notaEntity.getCodigo();
        this.texto = notaEntity.getTexto();
        this.urgente = notaEntity.getUrgente();
        this.dataHoraCadastro = notaEntity.getDataHoraCadastro();
    }
}
