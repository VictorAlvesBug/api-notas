package br.com.fiap.apinotas.service;

import br.com.fiap.apinotas.dto.CriarEditarNotaDTO;
import br.com.fiap.apinotas.dto.EditarTextoNotaDTO;
import br.com.fiap.apinotas.dto.NotaDTO;
import br.com.fiap.apinotas.entity.NotaEntity;
import br.com.fiap.apinotas.repository.NotaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {

    private NotaRepository notaRepository;
    private ObjectMapper objectMapper;

    public NotaServiceImpl(NotaRepository notaRepository,
                           ObjectMapper objectMapper){
        this.notaRepository = notaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public NotaDTO criar(CriarEditarNotaDTO criarEditarNotaDTO) {
        NotaEntity notaEntity = new NotaEntity(criarEditarNotaDTO);
        NotaEntity notaSalvaEntity = notaRepository.save(notaEntity);
        return new NotaDTO(notaSalvaEntity);
    }

    @Override
    public List<NotaDTO> listar() {
        return notaRepository.findAll().stream().map(NotaDTO::new).toList();
    }

    @Override
    public NotaDTO buscarPorId(Integer id) {
        return new NotaDTO(notaRepository.findById(id).get());
    }

    @Override
    public NotaDTO editar(Integer id, CriarEditarNotaDTO criarEditarNotaDTO) {
        NotaEntity notaEntity = notaRepository.findById(id).get();
        return null;
    }

    @Override
    public NotaDTO editarTexto(Integer id, EditarTextoNotaDTO editarTextoNotaDTO) {
        return null;
    }

    @Override
    public void deletar(Integer id) {

    }
}
