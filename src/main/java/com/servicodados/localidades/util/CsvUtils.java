package com.servicodados.localidades.util;

import com.servicodados.localidades.model.LocalidadeCSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.List;

public class CsvUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvUtils.class);

    public static void downloadCsv(PrintWriter writer, List<LocalidadeCSV> localidades) {
        LOGGER.info("Download CSV ::: Localidades");
        writer.write("idEstado, siglaEstado, regiaoNome, nomeCidade , nomeMesorregiao, nomeFormatado \n");
        for (LocalidadeCSV localidade : localidades) {
            writer.write(localidade.getIdEstado() + "," + localidade.getSiglaEstado() + ","
                    + localidade.getRegiaoNome() + "," + localidade.getNomeCidade() + ","
                    + localidade.getNomeMesorregiao() + "," + localidade.getNomeFormatado() + "\n");
        }
    }
}
