package com.ifsc.contaclique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterPlaneta extends ArrayAdapter<Planeta> {
    int mresourcer;
    public AdapterPlaneta(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        mresourcer=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(mresourcer,parent,false);
        //preencher a item da view
        TextView tvnome = convertView.findViewById(R.id.textView);
        ImageView im = convertView.findViewById(R.id.imageView);

        tvnome.setText(this.getItem(position).nome);
        im.setImageResource(this.getItem(position).imagem);



        return convertView;
    }
}
