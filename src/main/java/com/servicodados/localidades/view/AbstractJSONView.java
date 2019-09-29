package com.servicodados.localidades.view;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public abstract class AbstractJSONView extends AbstractView {

    private static final String CONTENT_TYPE = "application/json";

    public AbstractJSONView() {
        setContentType(CONTENT_TYPE);
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        buildJsonDocument(model, response);

    }

    protected abstract void buildJsonDocument(Map<String, Object> model, HttpServletResponse response) throws Exception;
}
