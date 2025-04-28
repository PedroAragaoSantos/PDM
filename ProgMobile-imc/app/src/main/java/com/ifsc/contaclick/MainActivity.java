package com.ifsc.contaclick;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtPeso, edtAltura;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesoStr = edtPeso.getText().toString();
                String alturaStr = edtAltura.getText().toString();

                if (!pesoStr.isEmpty() && !alturaStr.isEmpty()) {
                    double peso = Double.parseDouble(pesoStr);
                    double altura = Double.parseDouble(alturaStr);
                    double imc = peso / (altura * altura);

                    Intent intent = new Intent(MainActivity.this, MainActivityB.class);
                    intent.putExtra("imc", imc);
                    startActivity(intent);
                }
            }
        });
    }
}




