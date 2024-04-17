package br.org.sesisenai.ava.service;

import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.instrutor.InstrutorPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.instrutor.InstrutorResponseDTO;
import br.org.sesisenai.ava.entity.Instrutor;
import br.org.sesisenai.ava.repository.InstrutorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class InstrutorService {
    private InstrutorRepository instrutorRepository;

    public InstrutorResponseDTO criarInstrutor(InstrutorPostRequestDTO instrutorDTO) {
        Instrutor instrutor = instrutorDTO.toEntity();
        instrutor = instrutorRepository.save(instrutor);
        return instrutor.toDTO();
    }
}
