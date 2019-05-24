package com.example.quanlythucpham;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class ThucPhamListViewActivity extends AppCompatActivity {
    Button btnNhap;
    EditText thucPham, chuThich, gia;
    RadioButton rbtRau, rbtQua;

    ArrayList<ThucPham> data = new ArrayList<>();
    RecyclerView recyclerView;
    ThucPhamAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAdapter();
        setControl();
        setEvent();
    }


    private void setControl(){
        thucPham = (EditText) findViewById(R.id.editThucPham);
        chuThich = (EditText) findViewById(R.id.editCT);
        gia = (EditText) findViewById(R.id.editGia);
        btnNhap = (Button) findViewById(R.id.btnNhapTP);
        rbtRau = (RadioButton) findViewById(R.id.rbtRau);
        rbtQua = (RadioButton) findViewById(R.id.rbtQua);
    }

    private void setEvent(){
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThucPham tp = new ThucPham();

               tp.setThucPham(thucPham.getText().toString());
                tp.setChuThich(chuThich.getText().toString());

                tp.setGia(gia.getText().toString());

                if(tp.setIcon(rbtRau.isChecked())){
                    tp.setImgIcon(R.drawable.mixed);
                }
                else{
                    tp.setImgIcon(R.drawable.banana);
                }

                data.add(tp);
                adapter.notifyDataSetChanged();

            }
        });

    }
    void  setAdapter(){
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ThucPhamAdapter(this, data, R.layout.activity_thuc_pham_list_view);
        recyclerView.setAdapter(adapter);
    }

}
