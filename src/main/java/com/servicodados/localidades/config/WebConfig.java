package com.servicodados.localidades.config;

import org.springframework.context.annotation.Bean;
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

    /**
     *
     * @param manager
     * @return
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        //Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<>();

        resolvers.add(csvViewResolver());
        resolver.setViewResolvers(resolvers);

        return resolver;
    }

    /**
     *
     * @return
     */
    @Bean
    public ViewResolver csvViewResolver(){
        //return new CsvViewResolver();
        return null;
    }
}
