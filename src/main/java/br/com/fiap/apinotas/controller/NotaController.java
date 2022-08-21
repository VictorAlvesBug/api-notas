package br.com.fiap.apinotas.controller;

import br.com.fiap.apinotas.dto.CriarEditarNotaDTO;
import br.com.fiap.apinotas.dto.EditarTextoNotaDTO;
import br.com.fiap.apinotas.dto.NotaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("notas")
public class NotaController {

    List<NotaDTO> listaNotas = new ArrayList<NotaDTO>();

    public NotaController(){
    }

    @GetMapping
    public List<NotaDTO> listar(){
        return listaNotas;
    }

    @GetMapping("{id}")
    public NotaDTO buscarPorId(@PathVariable Integer id){
        return listaNotas.stream().filter(nota -> nota.getCodigo().equals(id)).findFirst().get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotaDTO criar(@RequestBody CriarEditarNotaDTO criarEditarNotaDTO){
        NotaDTO notaDTO = new NotaDTO(criarEditarNotaDTO);
        Integer proximoCodigo = listaNotas.size() + 1;
        notaDTO.setCodigo(proximoCodigo);
        listaNotas.add(notaDTO);
        return notaDTO;
    }

    @PutMapping("{id}")
    public NotaDTO editar(@PathVariable Integer id,
                          @RequestBody CriarEditarNotaDTO criarEditarNotaDTO){
        NotaDTO notaDTO = buscarPorId(id);
        notaDTO.setTexto(criarEditarNotaDTO.getTexto());
        notaDTO.setUrgente(criarEditarNotaDTO.getUrgente());

        return notaDTO;
    }

    @PatchMapping("{id}")
    public NotaDTO editarTexto(@PathVariable Integer id,
                               @RequestBody EditarTextoNotaDTO editarTextoNotaDTO){
        NotaDTO notaDTO = buscarPorId(id);
        notaDTO.setTexto(editarTextoNotaDTO.getTexto());

        return notaDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id)
    {
        NotaDTO notaDTO = buscarPorId(id);
        listaNotas.remove(notaDTO);
    }
}
