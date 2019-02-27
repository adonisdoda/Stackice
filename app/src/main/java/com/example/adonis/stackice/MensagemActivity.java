package com.example.adonis.stackice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MensagemActivity extends AppCompatActivity {

    private EditText nome;
    private TextView nomeTexto;
    private EditText cidade;
    private TextView cidadeTexto;
    private EditText mensagem;
    private TextView mensagemTexto;
    private ImageView botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mensagem);
        nome = findViewById(R.id.nome);
        nomeTexto = findViewById(R.id.nomeTexto);
        cidade = findViewById(R.id.cidade);
        cidadeTexto = findViewById(R.id.cidadeTexto);
        mensagem = findViewById(R.id.mensagem);
        mensagemTexto = findViewById(R.id.mensagemTexto);
        botaoVoltar = findViewById(R.id.botaoVoltar);


        AlteracaoCorClique();

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    protected void AlteracaoCorClique()
    {

        nome = findViewById(R.id.nome);
        nomeTexto = findViewById(R.id.nomeTexto);
        cidade = findViewById(R.id.cidade);
        cidadeTexto = findViewById(R.id.cidadeTexto);
        mensagem = findViewById(R.id.mensagem);
        mensagemTexto = findViewById(R.id.mensagemTexto);
        botaoVoltar = findViewById(R.id.botaoVoltar);


        nome.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                nomeTexto.setTextColor(getResources().getColor(R.color.colorPrimaryDetails));
                cidadeTexto.setTextColor(getResources().getColor(R.color.textoTab));
                mensagemTexto.setTextColor(getResources().getColor(R.color.textoTab));
                return false;
            }
        });

        cidade.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                cidadeTexto.setTextColor(getResources().getColor(R.color.colorPrimaryDetails));
                nomeTexto.setTextColor(getResources().getColor(R.color.textoTab));
                mensagemTexto.setTextColor(getResources().getColor(R.color.textoTab));
                return false;
            }
        });

        mensagem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mensagemTexto.setTextColor(getResources().getColor(R.color.colorPrimaryDetails));
                nomeTexto.setTextColor(getResources().getColor(R.color.textoTab));
                cidadeTexto.setTextColor(getResources().getColor(R.color.textoTab));
                return false;
            }
        });

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }




}
