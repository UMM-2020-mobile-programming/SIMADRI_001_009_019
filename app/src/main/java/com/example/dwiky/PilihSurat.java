package com.example.dwiky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PilihSurat extends AppCompatActivity {

    Button btnusaha, btndomisili, btnsktm, btnskck;
    TextView backLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_surat);

        btnusaha = findViewById(R.id.btnusaha);
        btndomisili = findViewById(R.id.btndomisili);
        btnsktm = findViewById(R.id.btnsktm);
        btnskck = findViewById(R.id.btnskck);

        backLogin = findViewById(R.id.backLogin);

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnusaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihSurat.this, keteranganusaha.class);
                startActivity(intent);
            }
        });

        btndomisili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihSurat.this, keterangandomisili.class);
                startActivity(intent);
            }
        });

        btnsktm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihSurat.this, keterangansktm.class);
                startActivity(intent);
            }
        });

        btnskck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihSurat.this, keteranganskck.class);
                startActivity(intent);
            }
        });
    }
}
