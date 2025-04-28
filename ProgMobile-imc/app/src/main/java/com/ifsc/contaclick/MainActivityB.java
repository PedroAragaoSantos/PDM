package com.ifsc.contaclick;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityB extends AppCompatActivity {

    TextView txtResultado;
    ImageView imagemResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        txtResultado = findViewById(R.id.txtResultado);
        imagemResultado = findViewById(R.id.imagemResultado);

        double imc = getIntent().getDoubleExtra("imc", 0.0);
        String classificacao;

        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
            imagemResultado.setImageResource(R.drawable.abaixopeso);
        } else if (imc < 24.9) {
            classificacao = "Peso ideal";
            imagemResultado.setImageResource(R.drawable.normal);
        } else if (imc < 29.9) {
            classificacao = "Sobrepeso";
            imagemResultado.setImageResource(R.drawable.sobrepeso);
        } else if (imc < 34.9) {
            classificacao = "Obesidade grau 1";
            imagemResultado.setImageResource(R.drawable.obesidade1);
        } else if (imc < 39.9) {
            classificacao = "Obesidade grau 2";
            imagemResultado.setImageResource(R.drawable.obesidade2);
        } else {
            classificacao = "Obesidade grau 3";
            imagemResultado.setImageResource(R.drawable.obesidade3);
        }

        txtResultado.setText(String.format("IMC: %.2f\n%s", imc, classificacao));
    }
}