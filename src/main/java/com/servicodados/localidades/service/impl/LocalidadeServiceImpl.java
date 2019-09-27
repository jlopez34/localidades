package com.servicodados.localidades.service.impl;

import com.servicodados.localidades.model.Estado;
import com.servicodados.localidades.model.LocalidadeCSV;
import com.servicodados.localidades.model.LocalidadeJSON;
import com.servicodados.localidades.model.Municipio;
import com.servicodados.localidades.repository.LocalidadeRepository;
import com.servicodados.localidades.service.LocalidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public List<LocalidadeJSON> obterLocalidadesJSON() {
        LOGGER.info("Executando obter LocalidadesJSON::::");
        List<LocalidadeJSON> localidades = new ArrayList<>();
        try {
            List<Estado> estados = localidadeRepository.obterEstados();
            for (Estado estado : estados) {
                List<Municipio> municipios = localidadeRepository.obterMunicipios(String.valueOf(estado.getId()));
                for (Municipio municipio : municipios) {
                    LocalidadeJSON locJSON = new LocalidadeJSON();
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
            LOGGER.debug("Error obtendo Localidades JSON ::: " + ex.getMessage());
        }
        return localidades;
    }

    @Override
    public List<LocalidadeCSV> obterLocalidadesCSV() {
        LOGGER.info("Executando obter obterLocalidadesCSV::::");
        List<LocalidadeCSV> localidades = new ArrayList<>();
        try {
            List<Estado> estados = localidadeRepository.obterEstados();
            for (Estado estado : estados) {
                List<Municipio> municipios = localidadeRepository.obterMunicipios(String.valueOf(estado.getId()));
                for (Municipio municipio : municipios) {
                    LocalidadeCSV locCVS = new LocalidadeCSV();
                    locCVS.setIdEstado(estado.getId());
                    locCVS.setSiglaEstado(estado.getSigla());
                    locCVS.setRegiaoNome(estado.getRegiao().getNome());
                    locCVS.setNomeCidade(municipio.getNome());
                    locCVS.setNomeMesorregiao(municipio.getMicrorregiao().getMesorregiao().getNome());
                    locCVS.setNomeFormatado(municipio.getNome() + " / " + municipio.getMicrorregiao().getMesorregiao().getUf().getSigla());

                    localidades.add(locCVS);
                }
            }
        } catch (Exception ex) {
            LOGGER.debug("Error obtendo Localidades JSON ::: " + ex.getMessage());
        }
        return localidades;
    }

    @Override
    public String obterCodigoCidade(String nomeCidade) {
        LOGGER.info("Executando obter obterCodigoCidade::::");
        String idCidade = null;

        try {
            idCidade = getCodigoCidade(nomeCidade);

            if (idCidade == null) {
                List<Municipio> municipios = localidadeRepository.obterCidades();
                for (Municipio municipio : municipios) {
                    if (municipio.getNome().equalsIgnoreCase(nomeCidade)) {
                        idCidade = String.valueOf(municipio.getId());
                        //Salvar em cache
                    }
                }
            }
        } catch (Exception ex) {
            LOGGER.debug("Error obtendo Localidades JSON ::: " + ex.getMessage());
        }

        return idCidade;
    }

    private String getCodigoCidade(String nomeCidade) {
        LOGGER.info("Codigo Cidade Procurado em Cache ::: " + nomeCidade);
        //Procurar em cache
        return null;
    }
}
