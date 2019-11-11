package com.br.nutricaoaplicativo.Service;

import com.br.nutricaoaplicativo.response.ClienteResponse;
import com.br.nutricaoaplicativo.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ClienteService {

    @Headers({"Content-Type: application/json"})
    @POST("clientes/aplicativo")
    Call<ClienteResponse> logarSistema(@Body LoginResponse loginResponse);
}
