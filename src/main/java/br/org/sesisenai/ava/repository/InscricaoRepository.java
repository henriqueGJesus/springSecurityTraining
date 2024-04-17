package br.org.sesisenai.ava.repository;

import br.org.sesisenai.ava.entity.Inscricao;
import br.org.sesisenai.ava.entity.InscricaoId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface InscricaoRepository extends JpaRepository<Inscricao, InscricaoId> {
    List<Inscricao> findAllByCursoId(Long cursoId);
}
