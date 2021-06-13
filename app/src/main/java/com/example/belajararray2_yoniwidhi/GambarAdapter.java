package com.example.belajararray2_yoniwidhi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GambarAdapter extends BaseAdapter {
    Context context;
    int[] gambar;
    LayoutInflater inflater;

    public GambarAdapter(Context applicationContext, int[] gmbrFramework) {
        this.context = applicationContext;
        this.gambar = gmbrFramework;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return gambar.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.list_gambar, null);
        ImageView logo = v.findViewById(R.id.tv_list_logo);
        logo.setImageResource(gambar[i]);
        return v;
    }
}
