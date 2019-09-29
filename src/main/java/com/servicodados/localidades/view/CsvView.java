package com.servicodados.localidades.view;

import com.servicodados.localidades.model.Localidade;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class CsvView extends AbstractCsvView {
    @Override
    protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"localidades.csv\"");
        List<Localidade> localidades = (List<Localidade>) model.get("localidade");
        String[] header = {"idEstado", "siglaEstado", "regiaoNome", "nomeCidade", "nomeMesorregiao", "nomeFormatado"};

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        csvWriter.writeHeader(header);

        for(Localidade local: localidades){
            csvWriter.write(local, header);
        }

        csvWriter.close();
    }
}
