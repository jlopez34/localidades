package com.servicodados.localidades;

import com.servicodados.localidades.model.Localidade;
import com.servicodados.localidades.model.Municipio;
import com.servicodados.localidades.repository.LocalidadeRepository;
import com.servicodados.localidades.service.LocalidadeService;
import com.servicodados.localidades.service.impl.LocalidadeServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalidadesApplicationTests {

    @Mock
    private LocalidadeRepository localidadeRepository;

    @InjectMocks
    private LocalidadeService localidadeService = new LocalidadeServiceImpl(localidadeRepository);

    @BeforeEach
    void setMockOutput() {
        final OngoingStubbing<List<Municipio>> listOngoingStubbing = when(localidadeRepository.obterCidades()).thenReturn(new ArrayList<Municipio>());
    }

    @DisplayName("Test para todos os municipios")
    @Test
    public void testObterLocalidades() {
        assertEquals(new ArrayList<Localidade>(), localidadeService.obterLocalidades());
    }

    @DisplayName("Test obter codigo de Cidade")
    @Test
    public void testObterCodigoCidade() {
        String nomeCidade = "Brasília";
        assertEquals(null, localidadeService.obterCodigoCidade(nomeCidade));
    }

}
