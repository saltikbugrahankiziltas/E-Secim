package com.example.dnemsonuprojesi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText editMail, editPass;
    Button btngiris, btnkayit;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private String txtMail,txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        img=findViewById(R.id.imgbaslik);
        txtbaslik=findViewById(R.id.txtbaslik);
        */
        editMail = findViewById(R.id.editMail);
        editPass = findViewById(R.id.editPass);
        btngiris = findViewById(R.id.giris);
        btnkayit = findViewById(R.id.kayıt);


        mAuth=FirebaseAuth.getInstance();


        btnkayit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intentt = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(intentt);
            }
        });

        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMail=editMail.getText().toString();
                txtPass=editPass.getText().toString();

                if(!TextUtils.isEmpty(txtMail)&& !TextUtils.isEmpty((txtPass))) {
                    mAuth.signInWithEmailAndPassword(txtMail,txtPass)
                            .addOnSuccessListener(MainActivity.this, new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    mUser=mAuth.getCurrentUser();
                                    System.out.println("Kullanıcı adı:"+mUser.getDisplayName());
                                    System.out.println("Kullanıcı email:"+mUser.getEmail());
                                }
                            }).addOnFailureListener(MainActivity.this, new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    Intent intentt2 = new Intent(MainActivity.this, OyActivity.class);
                    //intentt2.putExtra("fullname",mUser.getDisplayName());
                    startActivity(intentt2);
                }else{
                    Toast.makeText(MainActivity.this, "Mail veya şifre boş girilemez", Toast.LENGTH_SHORT).show();
                }
                /*
                Intent intentt2 = new Intent(KayitActivity.this, MainActivity.class);
                startActivity(intentt2);
                */

            }


        });
    }
}