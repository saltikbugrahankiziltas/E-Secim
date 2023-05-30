package com.example.dnemsonuprojesi;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private String userName;
    private int img;

    public User(){}

    public User(String userName,int img) {
        this.userName = userName;
        this.img=img;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public static ArrayList<User> getUsersList(){
        ArrayList<User> mUsers=new ArrayList<>();
        String[] users={"Recep Tayyip Erdoğan","Muharrem İnce","Kemal Kılıçdaroğlu","Sinan Oğan"};
        int[] images={R.drawable.erdogan,R.drawable.muharrem,R.drawable.kemal,R.drawable.sinan};
        User mUser;

        for(int i=0;i< users.length;i++){
            mUser=new User(users[i],images[i]);
            mUsers.add(mUser);
        }

        return mUsers;
    }
}
