package com.servicodados.localidades.controller;

import com.servicodados.localidades.service.LocalidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Api(value = "Controlador para API que serve para consultar Cidades, Estados e Municipios")
public class ExportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalidadeController.class);

    @Autowired
    LocalidadeService localidadeService;

    @GetMapping(value = "/localidade/csv/")
    @ApiOperation(value = "Consultar Estados", notes = "Retorna todos os estados do Brasil")
    public String consultarEstadosCSV(Model model) {
        LOGGER.info("Consumir Consultar Estados CSV");
        model.addAttribute("localidade", localidadeService.obterLocalidades());
        return "";
    }

}
