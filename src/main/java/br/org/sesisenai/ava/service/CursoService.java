package br.org.sesisenai.ava.service;

import br.org.sesisenai.ava.dto.implementation.curso.CursoPatchRequestDTO;
import br.org.sesisenai.ava.dto.implementation.curso.CursoPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.curso.CursoPutRequestDTO;
import br.org.sesisenai.ava.dto.implementation.curso.CursoResponseDTO;
import br.org.sesisenai.ava.entity.Curso;
import br.org.sesisenai.ava.repository.CursoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public void verificarExistencia(Long cursoId) {
        if (!cursoRepository.existsById(cursoId)) {
            throw new NoSuchElementException("Curso não encontrado");
        }
    }

    public Page<CursoResponseDTO> buscarCursos(Pageable pageable) {
        return cursoRepository.findAll(pageable).map(Curso::toDTO);
    }

    public CursoResponseDTO buscarCurso(Long id) {
        Curso curso = cursoRepository.findById(id).get();
        return curso.toDTO();
    }

    public CursoResponseDTO adicionarCurso(CursoPostRequestDTO cursoDTO) {
        Curso curso = cursoDTO.toEntity();
        cursoRepository.save(curso);
        return curso.toDTO();
    }

    public CursoResponseDTO atualizarCurso(Long id, CursoPutRequestDTO cursoDTO) {
        Curso curso = cursoRepository.findById(id).get();
        curso = cursoDTO.toEntity(curso);
        cursoRepository.save(curso);
        return curso.toDTO();
    }

    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public CursoResponseDTO alterarInstrutor(Long id, CursoPatchRequestDTO cursoDTO) {
        Curso curso = cursoRepository.findById(id).get();
        curso = cursoDTO.toEntity(curso);
        cursoRepository.save(curso);
        return curso.toDTO();
    }
}