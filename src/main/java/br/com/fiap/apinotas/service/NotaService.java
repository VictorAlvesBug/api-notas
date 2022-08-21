package br.com.fiap.apinotas.service;

import br.com.fiap.apinotas.dto.CriarEditarNotaDTO;
import br.com.fiap.apinotas.dto.EditarTextoNotaDTO;
import br.com.fiap.apinotas.dto.NotaDTO;

import java.util.List;

public interface NotaService {
    NotaDTO criar(CriarEditarNotaDTO criarEditarNotaDTO);
    List<NotaDTO> listar();
    NotaDTO buscarPorId(Integer id);
    NotaDTO editar(Integer id, CriarEditarNotaDTO criarEditarNotaDTO);
    NotaDTO editarTexto(Integer id, EditarTextoNotaDTO editarTextoNotaDTO);
    void deletar(Integer id);

}
