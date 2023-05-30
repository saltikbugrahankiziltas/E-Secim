package com.example.dnemsonuprojesi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragment2 extends BottomSheetDialogFragment {
    private ImageView imgclose;
    private onClickListener listener;
    private RecyclerView mRecycleView;
    private PartiAdapter myAdapter;
    private Context myContext;

    public BottomSheetFragment2(Context myContext) {
        this.myContext = myContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v1=inflater.inflate(R.layout.bottom_sheet_fragment,container,false);
        return v1;
    }
    @Override
    // Üst tarafta hoş görünüm kazandırdık..
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL,R.style.CustomBottomSheetDialogTheme);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgclose=view.findViewById(R.id.imgClose);
        mRecycleView=view.findViewById(R.id.recyclerView);

        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(myContext,LinearLayoutManager.VERTICAL,false));

        myAdapter=new PartiAdapter(myContext,Parti.getPartiList());
        mRecycleView.setAdapter(myAdapter);


        imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick();
            }
        });
    }
    public interface onClickListener{
        void onClick();
    }
    public void setOnItemClickListener(onClickListener listener){
        this.listener=listener;
    }
}


