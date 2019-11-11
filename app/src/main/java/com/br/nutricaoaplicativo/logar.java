package com.br.nutricaoaplicativo;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.nutricaoaplicativo.response.ClienteResponse;
import com.br.nutricaoaplicativo.response.LoginResponse;
import com.br.nutricaoaplicativo.retrofit.RetrofitConfig;

public class logar extends AppCompatActivity {

    EditText email;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logar);

        email = findViewById(R.id.login_email);
        senha = findViewById(R.id.login_senha);
        Button botaoLogar = findViewById(R.id.login_botao);
        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginResponse loginResponse = new LoginResponse(email.getText().toString(), senha.getText().toString());
                Call<ClienteResponse> call = new RetrofitConfig().getClienteService().logarSistema(loginResponse);
                call.enqueue(new Callback<ClienteResponse>() {
                    @Override
                    public void onResponse(Call<ClienteResponse> call, Response<ClienteResponse> response) {
                        ClienteResponse clienteResponse = response.body();
                        if (clienteResponse.getCodigo() == null) {
                            Toast.makeText(logar.this, "Email ou senha invalido", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(logar.this, Cardapio.class);
                            intent.putExtra("cliente", clienteResponse);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ClienteResponse> call, Throwable t) {
                        Log.e("error", t.getMessage());
                        Toast.makeText(logar.this, "Error, contratar o administrador do aplicativo", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
