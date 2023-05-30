package com.example.dnemsonuprojesi;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MuhurActivity extends AppCompatActivity {
    EditText editCumhurOy,editPartiOy;
    String txtCumhurOy,txtPartiOy;
    Button btnOyVer;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private HashMap<String,Object> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmuhur);
        editCumhurOy=findViewById(R.id.editCumhurOy);
        editPartiOy=findViewById(R.id.editPartiOy);
        btnOyVer=findViewById(R.id.oyVer);

        mAuth = FirebaseAuth.getInstance();
        mReference= FirebaseDatabase.getInstance().getReference();

        btnOyVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCumhurOy=editCumhurOy.getText().toString();
                txtPartiOy=editPartiOy.getText().toString();
                if(!TextUtils.isEmpty(txtCumhurOy)&&!TextUtils.isEmpty(txtPartiOy)){
                    mAuth.createUserWithEmailAndPassword(txtCumhurOy,txtPartiOy)
                            .addOnCompleteListener(MuhurActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        mUser=mAuth.getCurrentUser();

                                        mData=new HashMap<>();
                                        mData.put("kullaniciCumhurOyu",txtCumhurOy);
                                        mData.put("kullaniciPartiOyu",txtPartiOy);
                                        mData.put("kullaniciID",mUser.getUid());
                                        mReference.child("Oy").child(mUser.getUid())
                                                .setValue(mData)
                                                .addOnCompleteListener(MuhurActivity.this, new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()){
                                                            Toast.makeText(MuhurActivity.this, "Oy verme işleminiz tamamlandı", Toast.LENGTH_SHORT).show();
                                                        }else{
                                                            Toast.makeText(MuhurActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    }else{
                                        Toast.makeText(MuhurActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }else{
                    Toast.makeText(MuhurActivity.this, "Lütfen oyunuzu kullanınız ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
