package com.servicodados.localidades.repository;

import com.servicodados.localidades.model.Estado;
import com.servicodados.localidades.model.Municipio;

import java.io.IOException;
import java.util.List;

public interface LocalidadeRepository {

    List<Estado> obterEstados() throws IOException;

    List<Municipio> obterMunicipios(String uf);

    List<Municipio> obterCidades();

}
