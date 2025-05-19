package com.ifsc.contaclique;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int i=0;

    String [] nomes = new String[]{"Mercurio","Venus","Terra","Marte","Jupiter","Saturno","Urano","Netuno"};

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);

        PlanetaDao planetaDao = new PlanetaDao();

        AdapterPlaneta ap = new AdapterPlaneta(this,
                R.layout.item_lista,
                planetaDao.getPlaneta());
        lv.setAdapter(ap);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planeta p = planetaDao.getPlaneta().get(position);

                Intent i = new Intent(getApplicationContext(), PlanetaActivity.class);
                i.putExtra("nome",p);
                i.putExtra("planeta", p);

                startActivity(i);
            }
        });
    }
}