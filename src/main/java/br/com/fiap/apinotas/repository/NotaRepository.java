package br.com.fiap.apinotas.repository;

import br.com.fiap.apinotas.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<NotaEntity, Integer> {
}
