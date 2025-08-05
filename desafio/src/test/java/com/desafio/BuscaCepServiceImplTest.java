package com.desafio;

import com.desafio.dto.CepResponseDTO;
import com.desafio.repository.JpaLogRepository;
import com.desafio.service.ICepClient;
import com.desafio.service.impl.BuscaCepServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuscaCepServiceImplTest {

    @Mock
    private ICepClient cepClient;

    @Mock
    private JpaLogRepository jpaLogRepository;

    private BuscaCepServiceImpl buscaCepService;

    @BeforeEach
    void setUp() {
        buscaCepService = new BuscaCepServiceImpl(cepClient, jpaLogRepository);
    }

    @Test
    void deveBuscarCepValidoComSucesso() {
        String cep = "01001000";
        CepResponseDTO mockResponse = new CepResponseDTO();
        mockResponse.setCep(cep);
        mockResponse.setLogradouro("Praça da Sé");

        when(cepClient.consultar(cep)).thenReturn(mockResponse);

        CepResponseDTO response = buscaCepService.buscar(cep);

        assertNotNull(response);
        assertEquals("01001000", response.getCep());
        verify(cepClient).consultar(cep);
        verify(jpaLogRepository).salvar(any());
    }

    @Test
    void deveLancarExcecaoQuandoCepClientFalhar() {

        when(cepClient.consultar("01001000"))
                .thenThrow(new RuntimeException("Serviço externo indisponível"));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            buscaCepService.buscar("01001000");
        });

        assertEquals("Serviço externo indisponível", ex.getMessage());
        verify(jpaLogRepository, never()).salvar(any());
    }

}
