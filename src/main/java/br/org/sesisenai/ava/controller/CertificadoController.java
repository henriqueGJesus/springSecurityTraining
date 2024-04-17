//package br.org.sesisenai.ava.controller;
//
//import br.org.sesisenai.ava.dto.CertificadoDTO;
//import br.org.sesisenai.ava.service.CertificadoService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@AllArgsConstructor
//@RestController
//@RequestMapping("/api/usuarios")
//public class CertificadoController {
//
//    private CertificadoService certificadoService;
//
//    @GetMapping("/{usuarioId}/certificados")
//    public ResponseEntity<List<CertificadoDTO>> obterCertificados(@PathVariable Long usuarioId) {
//        List<CertificadoDTO> certificados = certificadoService.obterCertificados(usuarioId);
//        return new ResponseEntity<>(certificados, HttpStatus.OK);
//    }
//}
