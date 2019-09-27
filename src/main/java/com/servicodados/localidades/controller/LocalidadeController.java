package com.servicodados.localidades.controller;

import com.servicodados.localidades.model.LocalidadeJSON;
import com.servicodados.localidades.service.LocalidadeService;
import com.servicodados.localidades.util.CsvUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/rest/localidades")
@Api(value = "Controlador para API que serve para consultar Cidades, Estados e Municipios")
public class LocalidadeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalidadeController.class);

    @Autowired
    LocalidadeService localidadeService;

    @GetMapping(value = "/json/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar Estados", notes = "Retorna todos os estados do Brasil")
    public List<LocalidadeJSON> consultarEstadosJSON() {
        LOGGER.info("Consumir Consultar Estados");
        return localidadeService.obterLocalidadesJSON();

    }

    @GetMapping(value = "/csv/", produces = "text/csv")
    @ApiOperation(value = "Consultar Estados", notes = "Retorna todos os estados do Brasil")
    public void consultarEstadosCSV(HttpServletResponse response) throws IOException {
        LOGGER.info("Consumir Consultar Estados");
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=localidades.csv");
        CsvUtils.downloadCsv(response.getWriter(), localidadeService.obterLocalidadesCSV());
    }

    @GetMapping("/{nomeCidade}")
    @ApiOperation(value = "Consultar Ciudades", notes = "Retorna todas as Cidades por Estado")
    public String searchCountries(@PathVariable String nomeCidade) {
        LOGGER.info("Consumir Consultar Ciudades");
        return localidadeService.obterCodigoCidade(nomeCidade);

    }


}
