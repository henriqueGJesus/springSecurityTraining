package br.org.sesisenai.ava.controller;

import br.org.sesisenai.ava.dto.implementation.aula.AulaPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.aula.AulaPutRequestDTO;
import br.org.sesisenai.ava.dto.implementation.aula.AulaResponseDTO;
import br.org.sesisenai.ava.service.AulaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cursos/{cursoId}/aulas")
public class AulaController {

    private AulaService aulaService;

    @PostMapping
    public ResponseEntity<AulaResponseDTO> adicionarAula(
            @PathVariable Long cursoId,@RequestBody AulaPostRequestDTO aulaDTO) {
        try {
            AulaResponseDTO novaAula = aulaService.adicionarAula(cursoId, aulaDTO);
            return new ResponseEntity<>(novaAula, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{aulaId}")
    public ResponseEntity<AulaResponseDTO> atualizarAula(
            @PathVariable Long cursoId, @PathVariable Long aulaId, @RequestBody AulaPutRequestDTO aulaDTO) {
        try {
            AulaResponseDTO aulaAtualizada = aulaService.atualizarAula(cursoId, aulaId, aulaDTO);
            return new ResponseEntity<>(aulaAtualizada, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{aulaId}")
    public ResponseEntity<Void> deletarAula(@PathVariable Long cursoId, @PathVariable Long aulaId) {
        try {
            aulaService.deletarAula(cursoId, aulaId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{aulaId}")
    public ResponseEntity<AulaResponseDTO> buscarAula(@PathVariable Long cursoId, @PathVariable Long aulaId) {
        try {
            AulaResponseDTO aula = aulaService.buscarAula(cursoId, aulaId);
            return new ResponseEntity<>(aula, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Page<AulaResponseDTO>> buscarAulas(@PathVariable Long cursoId, Pageable pageable) {
        try {
            Page<AulaResponseDTO> aulas = aulaService.buscarAulas(cursoId, pageable);
            return new ResponseEntity<>(aulas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}