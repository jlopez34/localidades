package com.servicodados.localidades.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servicodados.localidades.model.Estado;
import com.servicodados.localidades.model.Municipio;
import com.servicodados.localidades.repository.LocalidadeRepository;
import com.servicodados.localidades.util.LocalidadesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Repository
public class LocalidadeRepositoryImpl implements LocalidadeRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalidadeRepositoryImpl.class);
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Estado> obterEstados() {
        final String uri = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
        List<Estado> estados = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String resultado = restTemplate.getForObject(uri, String.class);
            LOGGER.info("Responsta consulta estados ::: "+ resultado);
            if (resultado != null) {
                if(resultado.contains("id")) {
                    estados = Arrays.asList(mapper.readValue(resultado, Estado[].class));
                }else{
                    InputStream in = this.getClass().getClassLoader().getResourceAsStream("json/estados/estados.json");
                    String backup = LocalidadesUtil.convert(in, StandardCharsets.UTF_8);
                    estados = Arrays.asList(mapper.readValue(backup, Estado[].class));
                }
            }
        } catch (Exception ioex) {
            LOGGER.debug("Error obtendo listado de Estados ::: " + ioex.getMessage());
        }
        return estados;
    }

    @Override
    public List<Municipio> obterMunicipios(String uf) {
        final String uri = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + uf + "/municipios/";
        List<Municipio> municipios = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String resultado = restTemplate.getForObject(uri, String.class);
            LOGGER.info("Responsta consulta municipios ::: "+ resultado);
            if (resultado != null) {
                if(resultado.contains("id")) {
                    municipios = Arrays.asList(mapper.readValue(resultado, Municipio[].class));
                }else{
                    InputStream in = this.getClass().getClassLoader().getResourceAsStream("json/municipios/municipios_"+uf+".json");
                    String backup = LocalidadesUtil.convert(in, StandardCharsets.UTF_8);
                    municipios = Arrays.asList(mapper.readValue(backup, Municipio[].class));
                }
            }
        } catch (Exception ioex) {
            LOGGER.debug("Error obtendo listado de Municipios por estado ::: " + ioex.getMessage());
        }
        return municipios;
    }

    @Override
    public List<Municipio> obterCidades() {
        final String uri = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios/";
        List<Municipio> municipios = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String resultado = restTemplate.getForObject(uri, String.class);
            LOGGER.info("Responsta consulta cidades ::: "+ resultado);
            municipios = Arrays.asList(mapper.readValue(resultado, Municipio[].class));
        } catch (Exception ioex) {
            LOGGER.debug("Error obtendo listado de Municipios ::: " + ioex.getMessage());
        }
        return municipios;
    }
}
