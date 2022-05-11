package com.example.internacionalizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class IdiomaActivity extends AppCompatActivity {

    //Declaração de elementos
    private ImageButton btnPortugues;
    private ImageButton btnIngles;
    private ImageButton btnEspanhol;
    private ImageButton btnFrances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);

        EditText edtValor;
        TextView txtResult;
        edtValor = findViewById(R.id.edtValor);
        txtResult = findViewById(R.id.txtResultado);
        txtResult.setText(Integer.parseInt(edtValor.getText().toString()));

        //Identificando elementos
        btnPortugues = findViewById(R.id.btnBrasil);

        btnPortugues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configIdioma("pt");
            }
        });

        btnIngles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configIdioma("en");
            }
        });

        btnEspanhol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configIdioma("es");
            }
        });

        btnFrances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configIdioma("fr");
            }
        });
    }

    public void sair(View v){
        finish();
    }

    public void configIdioma(String lingua){
        Locale idioma = new Locale(lingua);
        Locale.setDefault(idioma);

        Context context = this;
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());

        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor dados = getSharedPreferences("idiomafatec", MODE_PRIVATE).edit();
        dados.commit();

        recreate();
    }
}