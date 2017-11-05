package com.tripoin.pos.desktop.swing.util;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.PostConstruct;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class RetrofitFactory implements IComponentInitializer{

    private Retrofit retrofit;

    @PostConstruct
    @Override
    public void initComponents() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8989/tripoin-pos-rest-desktop/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
