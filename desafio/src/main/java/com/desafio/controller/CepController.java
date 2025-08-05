package com.desafio.controller;


import com.desafio.dto.CepResponseDTO;
import com.desafio.service.BuscaCepService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cep")
public class CepController {

    private final BuscaCepService buscaCepService;

    public CepController(BuscaCepService buscaCepService) {
        this.buscaCepService = buscaCepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<CepResponseDTO> buscarCep(@PathVariable String cep) {
        CepResponseDTO dto = buscaCepService.buscar(cep);
        return ResponseEntity.ok(dto);
    }
}


