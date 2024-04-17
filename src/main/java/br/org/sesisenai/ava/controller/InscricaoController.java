package br.org.sesisenai.ava.controller;

import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoDeleteRequestDTO;
import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoResponseDTO;
import br.org.sesisenai.ava.service.InscricaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cursos/{cursoId}/incricoes")
public class InscricaoController {

    private InscricaoService inscricaoService;

    @PostMapping
    public ResponseEntity<InscricaoResponseDTO> inscreverUsuario(
            @PathVariable Long cursoId,
            @RequestBody InscricaoPostRequestDTO inscricaoDTO) {
        try {
            InscricaoResponseDTO novaInscricao =
                    inscricaoService.inscreverUsuario(cursoId, inscricaoDTO);
            return new ResponseEntity<>(novaInscricao, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cancelar")
    public ResponseEntity<InscricaoPostRequestDTO> cancelarInscricao(
            @PathVariable Long cursoId,
            @RequestBody InscricaoDeleteRequestDTO inscricaoDTO) {
        try {
            inscricaoService.cancelarInscricao(cursoId, inscricaoDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<InscricaoResponseDTO>> buscarInscricoes(
            @PathVariable Long cursoId) {
        try {
            List<InscricaoResponseDTO> inscricoes =
                    inscricaoService.buscarInscricoes(cursoId);
            return new ResponseEntity<>(inscricoes, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
