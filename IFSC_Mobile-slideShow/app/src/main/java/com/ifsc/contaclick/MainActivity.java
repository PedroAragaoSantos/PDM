package com.ifsc.contaclick;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    EditText edPeso,edAltura;
    TextView tvResultado;
    Button buttonCalcular;

    Button buttonNextImage;

    ImageView img;

    Integer imagens[] = new Integer[]{R.drawable.normal, R.drawable.obesidade1, R.drawable.obesidade2, R.drawable.obesidade3, R.drawable.perfil, R.drawable.sobrepeso, R.drawable.cachorro };

    int posicao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("ciclo de vida", "metodo onCreate");

        setContentView(R.layout.activity_main);
        edPeso=findViewById((R.id.editTxtPeso));
        edAltura=findViewById(R.id.editTxtAltura);
        buttonCalcular=findViewById(R.id.button);
        buttonNextImage=findViewById(R.id.button2);
        img=findViewById(R.id.imageView);

        // tratamento click button
        //buttonCalcular.setOnClickListener(v ->{...});
        buttonNextImage.setOnClickListener(v ->{
            img.setImageResource(imagens[posicao]);
            if(posicao<imagens.length-1){
                posicao++;
            } else{
                posicao = 0;
            }
        });

    }

}