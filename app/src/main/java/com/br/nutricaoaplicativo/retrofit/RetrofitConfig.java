package com.br.nutricaoaplicativo.retrofit;

import com.br.nutricaoaplicativo.Service.ClienteService;
import com.br.nutricaoaplicativo.Service.ConsultaService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder().baseUrl("http://10.0.0.3:8080/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ClienteService getClienteService() {
        return this.retrofit.create(ClienteService.class);
    }
    public ConsultaService getConsultaService() {return  this.retrofit.create(ConsultaService.class);}
}
