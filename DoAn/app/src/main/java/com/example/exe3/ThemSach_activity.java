package com.example.exe3;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ThemSach_activity extends AppCompatActivity {
    Button btnLuu;
    EditText txtMa,txtTenSach,txtTenTG,txtNXB;
    Button btnAdd, btnBack;
    SachAdapter adapter = null;
    ArrayList<Sach> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
        btnLuu = findViewById(R.id.btnAdd);
        btnLuu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemSach_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        setControl();
        setEvent();
    }

    private void setControl(){
        txtMa = (EditText) findViewById(R.id.inputMa);
        txtTenSach = (EditText) findViewById(R.id.inputTen);
        txtTenTG = (EditText) findViewById(R.id.inputTacGia);
        txtNXB = (EditText) findViewById(R.id.inputNXB);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button) findViewById(R.id.btnCancel);
    }

    private void setEvent()
    {
        adapter = new SachAdapter(this, R.layout.sach, data);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDB();
                Toast.makeText(ThemSach_activity.this, "Them Sach Thanh Cong", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(ThemSach_activity.this, MainActivity.class);
                startActivity(intent5);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.them:
                Intent intent = new Intent(ThemSach_activity.this, ThemSach_activity.class);
                startActivity(intent);
                break;
            case R.id.muon:
                Intent intent2 = new Intent(ThemSach_activity.this, Muon.class);
                startActivity(intent2);
                break;

            case R.id.logout:
                Intent intent4 = new Intent(ThemSach_activity.this, Login_activity.class);
                startActivity(intent4);
                break;
            case R.id.dss:
                Intent intent5 = new Intent(ThemSach_activity.this, MainActivity.class);
                startActivity(intent5);
                break;
        }
        return true;
    }

    public void saveDB(){
        SachDatabase db = new SachDatabase(this);
        Sach s = new Sach();
        s.setId(Integer.parseInt(txtMa.getText().toString()));
        s.setTenSach(txtTenSach.getText().toString());
        s.setTenTG(txtTenTG.getText().toString());
        s.setNSX(txtNXB.getText().toString());
        db.saveSach(s);
    }


}
