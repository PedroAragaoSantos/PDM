package com.ifsc.contaclique;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int i=0;
    SQLiteDatabase db;

    EditText editText;
    Button botaoInserir;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        db =openOrCreateDatabase("banco",MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT, txt TEXT)");
        editText = findViewById(R.id.editTextText);
        botaoInserir = findViewById(R.id.button);
        listView = findViewById(R.id.lista);
        botaoInserir.setOnClickListener(v-> {
            String msg = editText.getText().toString();
            listagem();
            inserir(msg);

        });
    }
    public void listagem(){
        Cursor cursor = db.rawQuery("SELECT * FROM notas",null);
        cursor.moveToFirst();
        ArrayList<String> listaTexto = new ArrayList<String>();
        while (!cursor.isAfterLast()){
            int coluna = cursor.getColumnIndex("txt");
            listaTexto.add(cursor.getString(coluna));
            cursor.moveToNext();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaTexto);
    }
    public void inserir(String txt){
        ContentValues cv = new ContentValues();
        cv.put("txt",txt);
        db.insert("notas",null, cv);

    }
}