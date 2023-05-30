package com.example.dnemsonuprojesi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    private ImageView imgClose;
    private OnClickListener listener;
    private RecyclerView myRecyclerView;
    private UsersAdapter mAdapter;
    private Context mContext;


    public BottomSheetFragment(Context mContext) {
        this.mContext = mContext;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.bottom_sheet_fragment,container , false);
        return v;
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
        imgClose=view.findViewById(R.id.imgClose);
        myRecyclerView=view.findViewById(R.id.recyclerView);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));

        mAdapter= new UsersAdapter(mContext, User.getUsersList());
        myRecyclerView.setAdapter(mAdapter);

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick();
            }
        });
    }

    public interface OnClickListener{
        void onClick();
    }

    // Burayı diğer classta kullanabilmek için yazdık
    public void setOnItemClickListener(OnClickListener listener){
        this.listener=listener;
    }
}
