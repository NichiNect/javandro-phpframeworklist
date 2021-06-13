package com.example.belajararray2_yoniwidhi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CardAdapter extends BaseAdapter {
    Context context;
    String[] namaFramework;
    int[] logoFramework;
    String[] descFramework;
    LayoutInflater inflater;

    public CardAdapter(Context applicationContext, String[] nama, int[] gambar, String[] deskripsi) {
        this.context = applicationContext;
        this.namaFramework = nama;
        this.logoFramework = gambar;
        this.descFramework = deskripsi;
        inflater = (LayoutInflater.from(this.context));
    }

    @Override
    public int getCount() {
        return logoFramework.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.list_card, null);
        TextView tvTitle = v.findViewById(R.id.tv_title);
        ImageView imgGambar = v.findViewById(R.id.img_gambar);
        TextView tvDeskripsi = v.findViewById(R.id.tv_description);

        tvTitle.setText(this.namaFramework[i]);
        imgGambar.setImageResource(this.logoFramework[i]);
        tvDeskripsi.setText(this.descFramework[i]);

        return v;
    }

}
