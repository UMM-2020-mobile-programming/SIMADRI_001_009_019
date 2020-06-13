package com.example.dwiky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class postLogin extends AppCompatActivity {
    private Button cancel;
    private Button benar;
    private TextView backLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);
        cancel = findViewById(R.id.cancel);
        benar = findViewById(R.id.benar);
        backLogin = findViewById(R.id.backLogin);

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i = new Intent(postLogin.this, tidakBenar.class);
                startActivity(i);
            }
        });

        benar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i = new Intent(postLogin.this, dashboard.class);
                startActivity(i);
            }
        });
    }
}
