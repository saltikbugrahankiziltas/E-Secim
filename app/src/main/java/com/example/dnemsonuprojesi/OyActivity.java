package com.example.dnemsonuprojesi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OyActivity extends AppCompatActivity implements RecyclerViewInterface{
    private Button btnCumhur,btnParti,btnOyVer;
    private BottomSheetFragment bottomSheet;
    private BottomSheetFragment2 bottomSheet2;
    // ArrayList<CumhurAdayları> cumhurAdaylarıs=new ArrayList<>();

    int[] cumhurImages={R.drawable.erdogan,R.drawable.muharrem,R.drawable.kemal,R.drawable.sinan};

    @SuppressLint("MissingInflatedId")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bottomSheet=new BottomSheetFragment(this);
        bottomSheet2=new BottomSheetFragment2(this);
        btnCumhur=findViewById(R.id.btnCumhur);

        bottomSheet.setCancelable(true);
        bottomSheet2.setCancelable(true);

       /* Intent intentt2 = getIntent();
        String userName = intentt2.getStringExtra("username");

        textView.setText("Merhaba, " + userName);*/
/*
        setUpCumhurAdaylarıs();*/

        btnCumhur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheet.show(getSupportFragmentManager(),"Bottom Sheet");
                bottomSheet.setOnItemClickListener(new BottomSheetFragment.OnClickListener() {
                    @Override
                    public void onClick() {
                        //kapatma yapar
                        bottomSheet.dismiss();
                    }
                });
            }
        });
        btnParti=findViewById(R.id.btnParti);
        btnParti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheet2.show(getSupportFragmentManager(),"Bottom Sheet");
                bottomSheet2.setOnItemClickListener(new BottomSheetFragment2.onClickListener() {
                    @Override
                    public void onClick() {
                        bottomSheet2.dismiss();
                    }
                });
            }
        });
        btnOyVer=findViewById(R.id.oyVer);
        btnOyVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OyActivity.this,OyNavi.class);
                startActivity(intent);
            }
        });

    }
/*
    public void setUpCumhurAdaylarıs(){
        String[] cumhurAdayis= getResources().getStringArray(R.array.cumhur_adaylari_full_name);
        for(int i=0;i<cumhurAdayis.length;i++){
            cumhurAdaylarıs.add(new CumhurAdayları(cumhurAdayis[i],
                    cumhurImages[i]));
        }
    }*/

    @Override
    public void onItemClick(int position) {

    }
}
