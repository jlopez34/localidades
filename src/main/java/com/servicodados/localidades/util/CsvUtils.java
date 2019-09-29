package com.servicodados.localidades.util;

import com.servicodados.localidades.model.Localidade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.List;

@Api(value = "Clase utilitaria para fazer download CSV")
public class CsvUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvUtils.class);

    @ApiOperation(value = "metodo que faz download de dados")
    public static void downloadCsv(PrintWriter writer, List<Localidade> localidades) {
        LOGGER.info("Download CSV ::: Localidades");
        writer.write("idEstado, siglaEstado, regiaoNome, nomeCidade , nomeMesorregiao, nomeFormatado \n");
        for (Localidade localidade : localidades) {
            writer.write(localidade.getIdEstado() + "," + localidade.getSiglaEstado() + ","
                    + localidade.getRegiaoNome() + "," + localidade.getNomeCidade() + ","
                    + localidade.getNomeMesorregiao() + "," + localidade.getNomeFormatado() + "\n");
        }
    }
}
