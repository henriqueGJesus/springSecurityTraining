package br.org.sesisenai.ava.service;

import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoDeleteRequestDTO;
import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoPostRequestDTO;
import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoResponseDTO;
import br.org.sesisenai.ava.entity.Inscricao;
import br.org.sesisenai.ava.entity.InscricaoId;
import br.org.sesisenai.ava.repository.InscricaoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class InscricaoService {

    private InscricaoRepository inscricaoRepository;
    private CursoService cursoService;

    public InscricaoResponseDTO inscreverUsuario(Long cursoId, InscricaoPostRequestDTO inscricaoDTO) {
        cursoService.verificarExistencia(cursoId);
        Inscricao inscricao = inscricaoDTO.toEntity();
        inscricao = inscricaoRepository.save(inscricao);
        return inscricao.toDTO();
    }


    public void cancelarInscricao(Long cursoId, InscricaoDeleteRequestDTO inscricaoDTO) {
        cursoService.verificarExistencia(cursoId);
        InscricaoId inscricao = inscricaoDTO.toEntity();
        inscricaoRepository.deleteById(inscricao);
    }

    public List<InscricaoResponseDTO> buscarInscricoes(Long cursoId) {
        cursoService.verificarExistencia(cursoId);
        return inscricaoRepository.findAllByCursoId(cursoId)
                .stream().map(Inscricao::toDTO).toList();
    }
}
