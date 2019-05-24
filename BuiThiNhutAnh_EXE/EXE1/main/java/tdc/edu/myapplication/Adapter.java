package tdc.edu.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    Context context;
    ArrayList<Student> data;
    int layoutResource;

    public Adapter(Context context, ArrayList<Student> data, int layoutResource) {
        this.context = context;
        this.data = data;
        this.layoutResource = layoutResource;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layoutResource, viewGroup, false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        myViewHolder.txtMa.setText(data.get(i).getTxtMa());
        myViewHolder.txtTen.setText(data.get(i).getTxtTen());
        myViewHolder.imageView.setImageResource(data.get(i).getIcon());
        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoveItem(i);
                Toast.makeText(context, "Đã xóa " + myViewHolder.txtTen.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txtMa, txtTen;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMa = itemView.findViewById(R.id.txtMa1);
            txtTen = itemView.findViewById(R.id.txtTen1);
            imageView = itemView.findViewById(R.id.imgIcon);
        }
    }

    public void RemoveItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

}
