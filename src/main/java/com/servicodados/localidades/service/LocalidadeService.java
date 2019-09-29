package com.servicodados.localidades.service;

import com.servicodados.localidades.model.Localidade;

import java.util.List;

public interface LocalidadeService {

    List<Localidade> obterLocalidades();

    String obterCodigoCidade(String nomeCidade);
}
