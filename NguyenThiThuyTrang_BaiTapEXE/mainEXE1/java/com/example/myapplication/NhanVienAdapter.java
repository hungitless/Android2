package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.MyViewHolder>{

    Context context;
    ArrayList<NhanVien> data;
    int layoutID;
    public static final int TYPE1 = 0;
    public static final int TYPE2 = 1;

    public NhanVienAdapter(Context context, ArrayList<NhanVien> data, int layoutID) {
        this.context = context;
        this.data = data;
        this.layoutID = layoutID;
    }


    public int getItemViewType(int position) {
        if (position % 3 == 0)
            return TYPE2;
        else
            return TYPE1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RadioButton rbtNam = null;
        RadioButton rbtNu = null;
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layoutID, viewGroup, false);
                if(rbtNam.isChecked() == true){
                    row =inflater.inflate(R.layout.activity_nhan_vien,viewGroup, false);

                }
                else{
                    row = inflater.inflate(R.layout.activity_nhan_vien2, viewGroup, false);

                }
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.tenNV.setText(data.get(i).getTenNV());
        myViewHolder.maNV.setText(data.get(i).getMaNV());
        myViewHolder.img.setImageResource(data.get(i).getImg());
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
        TextView tenNV, maNV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tenNV = itemView.findViewById(R.id.tennv);
            maNV = itemView.findViewById(R.id.manv);
            img = itemView.findViewById(R.id.img);
        }
    }

    public void removeItem(int position){
        data.remove(position);
        notifyDataSetChanged();

    }

}
