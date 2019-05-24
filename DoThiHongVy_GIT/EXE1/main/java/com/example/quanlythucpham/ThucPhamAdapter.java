package com.example.quanlythucpham;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThucPhamAdapter extends RecyclerView.Adapter<ThucPhamAdapter.MyViewHolder>{

    Context context;
    ArrayList<ThucPham> data;
    int layoutID;

    public ThucPhamAdapter(Context context, ArrayList<ThucPham> data, int layoutID) {
        this.context = context;
        this.data = data;
        this.layoutID = layoutID;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layoutID, viewGroup, false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.thucPham.setText(data.get(i).getThucPham());
        myViewHolder.chuThich.setText(data.get(i).getChuThich());
        myViewHolder.gia.setText(data.get(i).getGia());
        myViewHolder.img.setImageResource(data.get(i).getImgIcon());
        myViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView thucPham, chuThich, gia;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thucPham = itemView.findViewById(R.id.txtThucPham);
            chuThich = itemView.findViewById(R.id.txtChuThich);
            gia = itemView.findViewById(R.id.txtGia);
            img = itemView.findViewById(R.id.imgIcon);
        }
    }

    public void removeItem(int position){
        data.remove(position);
        notifyDataSetChanged();

    }


}
