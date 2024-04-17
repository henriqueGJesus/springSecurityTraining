package br.org.sesisenai.ava.repository;

import br.org.sesisenai.ava.entity.Aula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    boolean existsByCursoIdAndId(Long cursoId, Long aulaId);

    Page<Aula> findAllByCursoId(Long cursoId, Pageable pageable);
}
