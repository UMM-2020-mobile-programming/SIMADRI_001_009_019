package com.example.dwiky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {

    Button buatsurat,cek,riwayat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        buatsurat = findViewById(R.id.buatSurat);
        cek = findViewById(R.id.cek);
        riwayat = findViewById(R.id.riwayat);

        buatsurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, PilihSurat.class);
                startActivity(intent);
            }
        });

        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(dashboard.this, "Cek Pengajuan Surat", Toast.LENGTH_SHORT).show();
            }
        });

        riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(dashboard.this, "Riwayat Pengajuan Surat", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
