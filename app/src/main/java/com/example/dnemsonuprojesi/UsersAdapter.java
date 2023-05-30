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

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersHolder> {
    private Context mContext;
    private ArrayList<User> mUsersList;

    private View v;
    private User mUser;

    private UsersAdapter mAdapter;

    public UsersAdapter(Context mContext,ArrayList<User> mUsersList) {
        this.mContext = mContext;
        this.mUsersList= mUsersList;

    }

    @NonNull
    @Override
    public UsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v= LayoutInflater.from(mContext).inflate(R.layout.user_item,parent,false);
        return new UsersHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersHolder holder, int position) {
        mUser=mUsersList.get(position);
        holder.txtUserName.setText(mUser.getUserName());
        holder.image.setImageResource(mUser.getImg());
    }

    @Override
    //Eleman sayısını sorar.
    public int getItemCount() {
        return mUsersList.size();

    }

    class UsersHolder extends RecyclerView.ViewHolder{
        TextView txtUserName;
        ImageView image;
        public UsersHolder(View itemView){
            super(itemView);
            txtUserName=itemView.findViewById(R.id.user_item_txtUserName);
            image=itemView.findViewById(R.id.user_item_img);
        }
    }
}
