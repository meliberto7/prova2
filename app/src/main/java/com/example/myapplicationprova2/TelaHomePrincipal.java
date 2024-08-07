package com.example.myapplicationprova2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaHomePrincipal extends AppCompatActivity {

    private View layoutDrawer;
    private ImageView imageMenu;
    private Button buttonSair, buttonRoteiro, buttonViajante, buttonConfiguracoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_home_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonSair = findViewById(R.id.buttonSair);
        layoutDrawer = findViewById(R.id.layoutDrawer);
        imageMenu = findViewById(R.id.imageMenu);
        buttonRoteiro = findViewById(R.id.buttonRoteiro);
        buttonViajante = findViewById(R.id.buttonViajante);
        buttonConfiguracoes = findViewById(R.id.buttonConfiguracoes);

        buttonRoteiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model.setNome("Tela Roteiro Personalizado");
                irNovaTela();

            }
        });

        buttonViajante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model.setNome("Tela Viajante Gamificado");
                irNovaTela();

            }
        });

        buttonConfiguracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model.setNome("Tela Configurações de Usuário");
                irNovaTela();

            }
        });

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutDrawer.setVisibility(View.VISIBLE);

            }
        });

        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                irTelaLogin();

            }
        });

    }

    private void irTelaLogin() {

        Intent intent = new Intent(TelaHomePrincipal.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    private void irNovaTela() {

        Intent intent = new Intent(TelaHomePrincipal.this, TelaHomePrincipal.class);
        startActivity(intent);
        finish();

    }

}