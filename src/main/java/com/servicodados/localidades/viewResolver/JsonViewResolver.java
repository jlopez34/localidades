package com.servicodados.localidades.viewResolver;

import com.servicodados.localidades.view.JsonView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class JsonViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return new JsonView();
    }
}