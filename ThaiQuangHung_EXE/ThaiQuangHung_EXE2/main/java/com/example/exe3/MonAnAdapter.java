package com.example.exe3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonAnAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<MonAn> arrayMonAn;

    public MonAnAdapter(Context myContext, int myLayout, List<MonAn> arrayMonAn) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrayMonAn = arrayMonAn;
    }

    @Override
    public int getCount() {
        return arrayMonAn.size();
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
        txtTen.setText(arrayMonAn.get(position).Ten);
        TextView txtGia = (TextView) convertView.findViewById(R.id.textViewGia);
        txtGia.setText(arrayMonAn.get(position).Gia + "");
        ImageView imgHinh = (ImageView) convertView.findViewById(R.id.imageViewHinh);
        imgHinh.setImageResource(arrayMonAn.get(position).Hinh);

        //animation
//        Animation animation = AnimationUtils.loadAnimation(myContext, R.anim.fade_in);
//        convertView.startAnimation(animation);
        Animation animation = null;

        switch (MainActivity.animationItem){
            case R.id.fade:
                animation = AnimationUtils.loadAnimation(myContext, R.anim.fade_in);
                convertView.startAnimation(animation);
                break;
            case R.id.slideleft:
                animation = AnimationUtils.loadAnimation(myContext, R.anim.slide_left);
                convertView.startAnimation(animation);
                break;
            case R.id.slideup:
                animation = AnimationUtils.loadAnimation(myContext, R.anim.slide_up);
                convertView.startAnimation(animation);
                break;
            case R.id.shake:
                animation = AnimationUtils.loadAnimation(myContext, R.anim.shake);
                convertView.startAnimation(animation);
                break;
            case R.id.scale:
                animation = AnimationUtils.loadAnimation(myContext, R.anim.scale);
                convertView.startAnimation(animation);
                break;
            default:
                animation = AnimationUtils.loadAnimation(myContext, R.anim.scale);
                convertView.startAnimation(animation);
                break;
        }
        return convertView;
    }
}
