package com.example.dwiky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText username, pass;
    private TextView reg;
    private TextView submit;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.alamat_instansi);
        pass = findViewById(R.id.editText2);
        firebaseAuth = FirebaseAuth.getInstance();
        reg = findViewById(R.id.register);
        submit = findViewById(R.id.submit);
        firebaseAuth = FirebaseAuth.getInstance();


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, register.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tex_email = username.getText().toString();
                String tex_password = pass.getText().toString();
                if (TextUtils.isEmpty(tex_email) || TextUtils.isEmpty(tex_password)) {
                    Toast.makeText(MainActivity.this, "ANDA BELUM MENGISI APAPUN", Toast.LENGTH_SHORT).show();
                } else {
                    login(tex_email, tex_password);
                }
            }


        });


    }

    private void login(String tex_email, String tex_password) {
        firebaseAuth.signInWithEmailAndPassword(tex_email, tex_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, postLogin.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
}


//        if (FirebaseAuth.getInstance().getCurrentUser() == null ) {
//            Intent in = new Intent(this, postLogin.class);
//            startActivity(in);
//        }