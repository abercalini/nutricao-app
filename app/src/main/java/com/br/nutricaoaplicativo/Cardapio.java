package com.br.nutricaoaplicativo;

import android.os.Bundle;

import com.br.nutricaoaplicativo.response.ClienteResponse;
import com.br.nutricaoaplicativo.response.ConsultaResponse;
import com.br.nutricaoaplicativo.response.EmailResponse;
import com.br.nutricaoaplicativo.retrofit.RetrofitConfig;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;


public class Cardapio extends AppCompatActivity {

    private TextView refeicao1;
    private TextView refeicao2;
    private TextView duranteManha;
    private TextView refeicao3;
    private TextView refeicao4;
    private TextView preTreino;
    private TextView refeicao5;

    private TextView nomeCliente;
    private TextView dataConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        ClienteResponse clientes = (ClienteResponse) getIntent().getSerializableExtra("cliente");
        EmailResponse emailResponse = new EmailResponse(clientes.getEmail());
        Call<ConsultaResponse> call = new RetrofitConfig().getConsultaService().buscarCardapio(emailResponse);
        call.enqueue(new Callback<ConsultaResponse>() {

            @Override
            public void onResponse(Call<ConsultaResponse> call, Response<ConsultaResponse> response) {
                 ConsultaResponse consultaResponse = (ConsultaResponse) response.body();

                Log.d("sucesso", response.body().toString());

                nomeCliente = findViewById(R.id.cardapio_nome_cliente);
                nomeCliente.setText("Nome Cliente : " + consultaResponse.getCliente().getNome() + " " +  consultaResponse.getCliente().getSobrenome());

                dataConsulta = findViewById(R.id.cardapio_data_consulta);
                String dataFormat = DateFormat.format("dd/MM/yyyy", consultaResponse.getDataConsulta()).toString();
                Cardapio.this.dataConsulta.setText("Data consulta : " + dataFormat);

                refeicao1 = findViewById(R.id.cardapio_refeicao1);
                String pularLinha = "\n\n";
                refeicao1.setText(consultaResponse.getCardapio().getRefeicao1().replace(".", pularLinha));

                duranteManha = findViewById(R.id.cardapio_durante_manha);
                duranteManha.setText(consultaResponse.getCardapio().getDuranteManha());

                refeicao2 = findViewById(R.id.cardapio_refeicao2);
                refeicao2.setText(consultaResponse.getCardapio().getRefeicao2());

                refeicao3 = findViewById(R.id.cardapio_refeicao3);
                refeicao3.setText(consultaResponse.getCardapio().getRefeicao3().replace("." , "\n\n"));

                refeicao4 = findViewById(R.id.cardapio_refeicao4);
                refeicao4.setText(consultaResponse.getCardapio().getRefeicao4().replace("." , "\n\n"));

                preTreino = findViewById(R.id.cardapio_pre_treino);
                preTreino.setText(consultaResponse.getCardapio().getPreTreino().replace("." , "\n\n"));

                refeicao5 = findViewById(R.id.cardapio_refeicao5);
                refeicao5.setText(consultaResponse.getCardapio().getRefeicao5().replace("." , "\n\n"));
            }

            @Override
            public void onFailure(Call<ConsultaResponse> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }

}
