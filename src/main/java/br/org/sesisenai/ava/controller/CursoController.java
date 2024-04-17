package br.org.sesisenai.ava.controller;

import br.org.sesisenai.ava.dto.implementation.curso.CursoPatchRequestDTO;
import br.org.sesisenai.ava.dto.implementation.curso.CursoPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.curso.CursoPutRequestDTO;
import br.org.sesisenai.ava.dto.implementation.curso.CursoResponseDTO;
import br.org.sesisenai.ava.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<Page<CursoResponseDTO>> findAll(Pageable pageable) {
        try {
            Page<CursoResponseDTO> aulas = cursoService.buscarCursos(pageable);
            return new ResponseEntity<>(aulas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> findById(@PathVariable Long id) {
        try {
            CursoResponseDTO curso = cursoService.buscarCurso(id);
            return new ResponseEntity<>(curso, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<CursoResponseDTO> adicionarCurso(@RequestBody CursoPostRequestDTO cursoDTO) {
        try {
            CursoResponseDTO novoCurso = cursoService.adicionarCurso(cursoDTO);
            return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> atualizarCurso(@PathVariable Long id, @RequestBody CursoPutRequestDTO cursoDTO) {
        try {
            CursoResponseDTO cursoAtualizado = cursoService.atualizarCurso(id, cursoDTO);
            return new ResponseEntity<>(cursoAtualizado, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
        try {
            cursoService.deletarCurso(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> alterarInstrutor(@PathVariable Long id, @RequestBody CursoPatchRequestDTO cursoDTO) {
        try {
            CursoResponseDTO cursoAtualizado = cursoService.alterarInstrutor(id, cursoDTO);
            return new ResponseEntity<>(cursoAtualizado, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}