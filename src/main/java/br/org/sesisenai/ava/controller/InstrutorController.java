package br.org.sesisenai.ava.controller;

import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoResponseDTO;
import br.org.sesisenai.ava.dto.implementation.instrutor.InstrutorPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.instrutor.InstrutorResponseDTO;
import br.org.sesisenai.ava.service.InscricaoService;
import br.org.sesisenai.ava.service.InstrutorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/instrutor")
public class InstrutorController {

    private InstrutorService instrutorService;

    @PostMapping
    public ResponseEntity<InstrutorResponseDTO> criarInstrutor(
            @RequestBody InstrutorPostRequestDTO instrutorDTO) {
        InstrutorResponseDTO novoInstrutor = instrutorService.criarInstrutor(instrutorDTO);
        return new ResponseEntity<>(novoInstrutor, HttpStatus.CREATED);
    }
}
