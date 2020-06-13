package com.example.dwiky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class register extends AppCompatActivity {
    private EditText usernama, nama, nomor, pass;
    private TextView backLogin;
    private Button button;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        firebaseAuth = FirebaseAuth.getInstance();
        usernama = findViewById(R.id.alamat_instansi);
        nama = findViewById(R.id.kegunaansurat);
        nomor = findViewById(R.id.nohp);
        pass = findViewById(R.id.password);
        progressBar = findViewById(R.id.progresbar);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user_name = usernama.getText().toString();
                final String name = nama.getText().toString();
                final String number = nomor.getText().toString();
                final String password = pass.getText().toString();

                if (TextUtils.isEmpty(user_name) || TextUtils.isEmpty(name) || TextUtils.isEmpty(number) || TextUtils.isEmpty(password)){
                    Toast.makeText(register.this, "Semua Kolom Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else{
                    Register(user_name,name,number,password);
                }

            }
        });


    }

    private void Register(final String user_name, final String name, final String number, final String password) {
        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser rUser = firebaseAuth.getCurrentUser();
                    String userId = rUser.getUid();
                    databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId);
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("userId",userId);
                    hashMap.put("USERNAME",user_name);
                    hashMap.put("EMAIL",name);
                    hashMap.put("NOMOR HANDPHONE", number);
                    hashMap.put("PASSWORD",password);
                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()){
                                Intent intent = new Intent(register.this,MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(register.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else{
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(register.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
