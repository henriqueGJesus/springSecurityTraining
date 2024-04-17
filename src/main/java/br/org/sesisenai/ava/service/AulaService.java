package br.org.sesisenai.ava.service;

import br.org.sesisenai.ava.dto.implementation.aula.AulaPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.aula.AulaPutRequestDTO;
import br.org.sesisenai.ava.dto.implementation.aula.AulaResponseDTO;
import br.org.sesisenai.ava.entity.Aula;
import br.org.sesisenai.ava.entity.Curso;
import br.org.sesisenai.ava.repository.AulaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Data
@AllArgsConstructor
public class AulaService {

    private AulaRepository aulaRepository;
    private CursoService cursoService;

    public AulaResponseDTO adicionarAula(Long cursoId, AulaPostRequestDTO aulaDTO) {
        try {
            cursoService.verificarExistencia(cursoId);
            Aula aula = aulaDTO.toEntity();
            aula = aulaRepository.save(aula);
            return aula.toDTO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AulaResponseDTO atualizarAula(Long cursoId, Long aulaId, AulaPutRequestDTO aulaDTO) {
        try {
            cursoService.verificarExistencia(cursoId);
            Aula aula = aulaRepository.findById(aulaId).get();
            if (!aula.getCurso().getId().equals(cursoId)) {
                throw new RuntimeException("Aula não pertence ao curso informado");
            }
            aula = aulaDTO.toEntity(aula);
            aula = aulaRepository.save(aula);
            return aula.toDTO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarAula(Long cursoId, Long aulaId) {
        if (aulaRepository.existsByCursoIdAndId(cursoId, aulaId)) {
            throw new NoSuchElementException();
        }
        aulaRepository.deleteById(aulaId);
    }

    public AulaResponseDTO buscarAula(Long cursoId, Long aulaId) {
        if (aulaRepository.existsByCursoIdAndId(cursoId, aulaId)) {
            throw new NoSuchElementException();
        }
        Aula aula = aulaRepository.findById(aulaId).get();
        return aula.toDTO();
    }

    public Page<AulaResponseDTO> buscarAulas(Long cursoId, Pageable pageable) {
        return aulaRepository.findAllByCursoId(cursoId, pageable)
                .map(Aula::toDTO);
    }
}
