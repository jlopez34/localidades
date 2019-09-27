package com.servicodados.localidades.service;

import com.servicodados.localidades.model.LocalidadeCSV;
import com.servicodados.localidades.model.LocalidadeJSON;

import java.util.List;

public interface LocalidadeService {

    List<LocalidadeJSON> obterLocalidadesJSON();

    List<LocalidadeCSV> obterLocalidadesCSV();

    String obterCodigoCidade(String nomeCidade);
}
