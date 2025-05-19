package com.ifsc.contaclique;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Planeta implements Serializable {
    String nome;
    //Bitmap imagem;
    Integer imagem; //são recursos da pasta drawable R.drawable.nomeDaImagem

    public Planeta(String nome, Integer imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }
}

