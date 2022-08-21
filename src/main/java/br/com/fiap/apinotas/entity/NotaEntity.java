package br.com.fiap.apinotas.entity;

import br.com.fiap.apinotas.dto.CriarEditarNotaDTO;
import br.com.fiap.apinotas.dto.EditarTextoNotaDTO;
import br.com.fiap.apinotas.repository.NotaRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_NOTA")
@Data
@EntityListeners(AuditingEntityListener.class)
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String texto;

    private Boolean urgente;

    @CreatedDate
    private Date dataHoraCadastro;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT 1")
    private Boolean ativo;

    public NotaEntity() {}

    public NotaEntity (CriarEditarNotaDTO criarEditarNotaDTO) {
        texto = criarEditarNotaDTO.getTexto();
        urgente = criarEditarNotaDTO.getUrgente();
    }

    public NotaEntity (EditarTextoNotaDTO editarTextoNotaDTO) {
        texto = editarTextoNotaDTO.getTexto();
    }
}
