package com.example.exe3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SachAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<Sach> arraySach;

    public SachAdapter(Context myContext, int myLayout, List<Sach> arraySach) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arraySach = arraySach;
    }

    @Override
    public int getCount() {
        return arraySach.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout, null);

        TextView txtTen = (TextView) convertView.findViewById(R.id.textViewTen);
        txtTen.setText(arraySach.get(position).tenTG);
        ImageView imgHinh = (ImageView) convertView.findViewById(R.id.imageViewHinh);
        imgHinh.setImageResource(arraySach.get(position).hinh);
        Animation animation = null;

        switch (MainActivity.animationItem){
            case R.id.muon:
                animation = AnimationUtils.loadAnimation(myContext, R.anim.fade_in);
                convertView.startAnimation(animation);
                break;

            case R.id.logout:
                animation = AnimationUtils.loadAnimation(myContext, R.anim.fade_in);
                convertView.startAnimation(animation);
                break;
        }
        return convertView;
    }
}
