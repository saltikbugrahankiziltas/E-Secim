package com.example.dnemsonuprojesi;

import java.util.ArrayList;

public class Parti {
    private String partiName;
    private int img;

    public Parti(){}

    public Parti(String partiName,int img) {
        this.partiName = partiName;
        this.img=img;
    }

    public String getPartiName() {
        return partiName;
    }

    public void setPartiName(String partiName) {
        this.partiName = partiName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public static ArrayList<Parti> getPartiList(){
        ArrayList<Parti> mPartis=new ArrayList<>();
        String[] uyeler={"Cumhuriyet Halk Partisi","Memleket Partisi","Zafer Partisi","Adalet ve Kalkınma Partisi"};
        int[] images1={R.drawable.chp,R.drawable.memleket,R.drawable.zafer,R.drawable.akp};
        Parti mParti;

        for(int i=0;i< uyeler.length;i++){
            mParti=new Parti(uyeler[i],images1[i]);
            mPartis.add(mParti);
        }
        return mPartis;
    }
}
