package com.servicodados.localidades.service.impl;

import com.servicodados.localidades.model.Estado;
import com.servicodados.localidades.model.Localidade;
import com.servicodados.localidades.model.Municipio;
import com.servicodados.localidades.repository.LocalidadeRepository;
import com.servicodados.localidades.service.LocalidadeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalidadeServiceImpl implements LocalidadeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalidadeServiceImpl.class);

    private final LocalidadeRepository localidadeRepository;

    public LocalidadeServiceImpl(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    @Override
    @ApiOperation(value = "Obter as localidades para ser exportado CSV e JSON")
    public List<Localidade> obterLocalidades() {
        LOGGER.info("Executando obter Localidades::::");
        List<Localidade> localidades = new ArrayList<>();
        try {
            List<Estado> estados = localidadeRepository.obterEstados();
            for (Estado estado : estados) {
                List<Municipio> municipios = localidadeRepository.obterMunicipios(String.valueOf(estado.getId()));
                for (Municipio municipio : municipios) {
                    Localidade locJSON = new Localidade();
                    locJSON.setIdEstado(estado.getId());
                    locJSON.setSiglaEstado(estado.getSigla());
                    locJSON.setRegiaoNome(estado.getRegiao().getNome());
                    locJSON.setNomeCidade(municipio.getNome());
                    locJSON.setNomeMesorregiao(municipio.getMicrorregiao().getMesorregiao().getNome());
                    locJSON.setNomeFormatado(municipio.getNome() + " / " + municipio.getMicrorregiao().getMesorregiao().getUf().getSigla());

                    localidades.add(locJSON);
                }
            }

        } catch (Exception ex) {
            LOGGER.debug("Error obtendo Localidades  ::: " + ex.getMessage());
        }
        return localidades;
    }


    @Override
    @ApiOperation(value = "Obter o codigo de uma cidade basado no nome da cidade")
    @Cacheable(value = "cidade")
    public String obterCodigoCidade(String nomeCidade) {
        LOGGER.info("Executando obter obterCodigoCidade::::");
        String idCidade = null;

        try {
             List<Municipio> municipios = localidadeRepository.obterCidades();
                for (Municipio municipio : municipios) {
                    if (municipio.getNome().equalsIgnoreCase(nomeCidade)) {
                        idCidade = String.valueOf(municipio.getId());
                    }
                }
        } catch (Exception ex) {
            LOGGER.debug("Error obtendo Localidades JSON ::: " + ex.getMessage());
        }

        return idCidade;
    }

}
