package com.example.dnemsonuprojesi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.installations.Utils;

import java.util.HashMap;

public class KayitActivity extends AppCompatActivity {

    ImageView img1;
    TextView txtkayitbaslik;
    EditText kayitMail,kayitName,kayitPass;
    Button btnkayitol;

    private String txtMail,txtSifre,txtIsım;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private HashMap<String,Object> mData;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        kayitMail=findViewById(R.id.kayitMail);
        kayitName=findViewById(R.id.kayitFullName);
        kayitPass=findViewById(R.id.kayitPassword);
        btnkayitol=findViewById(R.id.donus);

        mAuth = FirebaseAuth.getInstance();
        mReference= FirebaseDatabase.getInstance().getReference();
    }
    public void kayitOl(View view){
        txtMail= kayitMail.getText().toString();
        txtSifre=kayitPass.getText().toString();
        txtIsım=kayitName.getText().toString();
        if(!TextUtils.isEmpty(txtIsım)&&!TextUtils.isEmpty(txtMail)&&!TextUtils.isEmpty(txtSifre)){
            mAuth.createUserWithEmailAndPassword(txtMail,txtSifre)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                mUser=mAuth.getCurrentUser();

                                mData=new HashMap<>();
                                mData.put("kullaniciAdi",txtIsım);
                                mData.put("kullaniciMail",txtMail);
                                mData.put("kullaniciSifre",txtSifre);
                                mData.put("kullaniciID",mUser.getUid());
                                mReference.child("Kullanıcılar").child(mUser.getUid())
                                        .setValue(mData)
                                        .addOnCompleteListener(KayitActivity.this, new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(KayitActivity.this, "Kayıt işlemi başarılı", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(KayitActivity.this, MainActivity.class);
                                                    startActivity(intent);
                                                }else{
                                                    Toast.makeText(KayitActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });

                            }else{
                                Toast.makeText(KayitActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else{
            Toast.makeText(this, "Kullanıcı mail , isim soyisim veya şifre boş olamaz", Toast.LENGTH_SHORT).show();
        }
    }
}
