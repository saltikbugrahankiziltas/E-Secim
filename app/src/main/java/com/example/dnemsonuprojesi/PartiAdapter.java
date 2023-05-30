package com.example.dnemsonuprojesi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PartiAdapter extends RecyclerView.Adapter<PartiAdapter.PartiHolder>  {
    private Context myContext;
    private ArrayList<Parti> myPartiList;
    private View v1;
    private Parti mParti;

    private PartiHolder myParti;

    public PartiAdapter(Context myContext,ArrayList<Parti> myPartiList) {
        this.myContext = myContext;
        this.myPartiList=myPartiList;
    }

    @NonNull
    @Override
    public PartiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v1= LayoutInflater.from(myContext).inflate(R.layout.user_item,parent,false);
        return new PartiHolder(v1);
    }

    @Override
    public void onBindViewHolder(@NonNull PartiHolder holder, int position) {
        mParti=myPartiList.get(position);
        holder.txtPartiName.setText(mParti.getPartiName());
        holder.image.setImageResource(mParti.getImg());
    }

    @Override
    public int getItemCount() {
        return myPartiList.size();
    }

    class PartiHolder extends RecyclerView.ViewHolder{
        TextView txtPartiName;
        ImageView image;
        public PartiHolder(@NonNull View itemView) {
            super(itemView);
            txtPartiName=itemView.findViewById(R.id.user_item_txtUserName);
            image=itemView.findViewById(R.id.user_item_img);
        }
    }
}
