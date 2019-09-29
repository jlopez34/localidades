package com.servicodados.localidades.view;

import com.servicodados.localidades.model.Localidade;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class JsonView extends AbstractJSONView {
    @Override
    protected void buildJsonDocument(Map<String, Object> model,  HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"localidades.json\"");
        List<Localidade> localidades = (List<Localidade>) model.get("localidade");

        for(Localidade local: localidades){
            response.getWriter().write(local.toString());
        }

    }
}