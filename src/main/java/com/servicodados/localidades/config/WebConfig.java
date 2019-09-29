package com.servicodados.localidades.config;

import com.servicodados.localidades.viewResolver.CsvViewResolver;
import com.servicodados.localidades.viewResolver.JsonViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.ArrayList;
import java.util.List;


public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON).favorPathExtension(true);
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        //Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<>();

        resolvers.add(csvViewResolver());
        //resolvers.add(jsonViewResolver());

        resolver.setViewResolvers(resolvers);


        return resolver;
    }

    /**
     * @return
     */
    @Bean
    public ViewResolver csvViewResolver() {
        return new CsvViewResolver();
    }

    /**
     * @return
     */
    @Bean
    public ViewResolver xmlViewResolver() {
        //return new CsvViewResolver();
        return null;
    }

    /**
     * @return
     */
    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }
}
