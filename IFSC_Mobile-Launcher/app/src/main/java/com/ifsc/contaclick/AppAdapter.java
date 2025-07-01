package com.ifsc.contaclick;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    int mresource;
    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);
        mresource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View v = layoutInflater.inflate(mresource,parent,false);
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textView = v.findViewById(R.id.textView);
        LinearLayout ll = v.findViewById(R.id.linearlayout);

        ApplicationInfo appinfo = getItem(position);
        textView.setText(appinfo.loadLabel(getContext().getPackageManager()));
        imageView.setImageDrawable(appinfo.loadIcon(getContext().getPackageManager()));

        TextView tvPackageName = new TextView(getContext());
        tvPackageName.setText(appinfo.packageName);

        TextView tvs = new TextView(getContext());
        tvs.setText((CharSequence) appinfo.className);

        ll.addView(tvPackageName);
        ll.addView(tvs);

        return v;
    }
}
