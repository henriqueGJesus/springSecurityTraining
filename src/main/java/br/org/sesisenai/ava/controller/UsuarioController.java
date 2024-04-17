package br.org.sesisenai.ava.controller;

import br.org.sesisenai.ava.dto.implementation.usuario.UsuarioPatchRequestDTO;
import br.org.sesisenai.ava.dto.implementation.usuario.UsuarioPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.usuario.UsuarioPutRequestDTO;
import br.org.sesisenai.ava.dto.implementation.usuario.UsuarioResponseDTO;
import br.org.sesisenai.ava.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody UsuarioPostRequestDTO usuarioDTO) {
        try {
            UsuarioResponseDTO novoUsuario = usuarioService.criarUsuario(usuarioDTO);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(
            @PathVariable Long id, @RequestBody UsuarioPutRequestDTO usuarioDTO) {
        try{
            UsuarioResponseDTO usuarioAtualizado =
                    usuarioService.atualizarUsuario(id, usuarioDTO);
            return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}/senha")
    public ResponseEntity<UsuarioResponseDTO> atualizarSenhaUsuario(
            @PathVariable Long id, @RequestBody UsuarioPatchRequestDTO usuarioDTO) {
        try{
            UsuarioResponseDTO usuarioAtualizado =
                    usuarioService.atualizarUsuario(id, usuarioDTO);
            return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> buscarUsuarios(Pageable pageable) {
        Page<UsuarioResponseDTO> usuarios = usuarioService.buscarUsuarios(pageable);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuario(@PathVariable Long id) {
        try{
            UsuarioResponseDTO usuario = usuarioService.buscarUsuario(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        try{
            usuarioService.deletarUsuario(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}