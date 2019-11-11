package com.br.nutricaoaplicativo.Service;

import com.br.nutricaoaplicativo.response.ClienteResponse;
import com.br.nutricaoaplicativo.response.ConsultaResponse;
import com.br.nutricaoaplicativo.response.EmailResponse;
import com.br.nutricaoaplicativo.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ConsultaService {

    @Headers("Content-Type: application/json")
    @POST("consultas/aplicativo")
    Call<ConsultaResponse> buscarCardapio (@Body EmailResponse emailResponse);

}
