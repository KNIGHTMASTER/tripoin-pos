package com.tripoin.pos.rest.desktop.config;

import com.tripoin.scaffolding.endpoint.IDataBuilderEndPoint;
import com.tripoin.scaffolding.endpoint.IResponseConstructor;
import com.tripoin.scaffolding.endpoint.impl.DataBuilderEndPointImpl;
import com.tripoin.scaffolding.endpoint.impl.ResponseConstructorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 11/1/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
public class AppConfiguration {

    @Bean
    public IResponseConstructor responseConstructor() {
        return new ResponseConstructorImpl<>();
    }

    @Bean
    public IDataBuilderEndPoint dataBuilderEndPoint() {
        return new DataBuilderEndPointImpl();
    }
}
