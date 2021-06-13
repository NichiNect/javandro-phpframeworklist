package com.example.belajararray2_yoniwidhi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DeskripsiLengkap extends AppCompatActivity {
    public static final String NAMA_FRAMEWORK = "TES";
    public static final String DESC_FRAMEWORK = "TESS";
    public static final String LOGO_FRAMEWORK = "";
    TextView tvJudulFramework;
    TextView tvDescriptionFramework;
    ImageView imgGambarFramework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_lengkap);

        this.tvJudulFramework = findViewById(R.id.judul_desc);
        this.tvDescriptionFramework = findViewById(R.id.description_desc);
        this.imgGambarFramework = findViewById(R.id.gambar_desc);

        String namaFramework = getIntent().getStringExtra(NAMA_FRAMEWORK);
        String descFramework = getIntent().getStringExtra(DESC_FRAMEWORK);
        int logoFramework = getIntent().getIntExtra(LOGO_FRAMEWORK, 0);

        this.tvJudulFramework.setText(namaFramework);
        this.tvDescriptionFramework.setText(descFramework);
        this.imgGambarFramework.setImageResource(logoFramework);


    }
}