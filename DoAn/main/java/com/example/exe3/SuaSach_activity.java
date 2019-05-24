package com.example.exe3;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
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

public class SuaSach_activity extends AppCompatActivity {
    EditText txtMa, txtTenSach, txtTenTG, txtNXB;
    Button btnEdit, btnBack;
    SachAdapter adapter = null;
    ArrayList<Sach> data = new ArrayList<>();
    ActionBarDrawerToggle mToggle;

    private void setControl(){
        txtTenSach = (EditText) findViewById(R.id.inputTen);
        txtTenTG = (EditText) findViewById(R.id.inputTacGia);
        txtNXB = (EditText) findViewById(R.id.inputNXB);
        btnEdit = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button) findViewById(R.id.btnCancel);
    }

    private void setValueBook()
    {
        txtTenSach.setText(getIntent().getStringExtra("sach_name"));
        txtTenTG.setText(getIntent().getStringExtra("sach_tentacgia"));
        txtNXB.setText(getIntent().getStringExtra("sach_nxb"));
    }

    private void setEvent()
    {
        setValueBook();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSach();
                Toast.makeText(SuaSach_activity.this, "Sửa thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(SuaSach_activity.this, MainActivity.class);
                startActivity(intent5);
            }
        });
    }



    static int animationItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_sach);
        setControl();
        setEvent();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.them:
                Intent intent = new Intent(SuaSach_activity.this, ThemSach_activity.class);
                startActivity(intent);
                break;
            case R.id.muon:
                Intent intent2 = new Intent(SuaSach_activity.this, Muon.class);
                startActivity(intent2);
                break;

            case R.id.logout:
                Intent intent4 = new Intent(SuaSach_activity.this, Login_activity.class);
                startActivity(intent4);
                break;
            case R.id.dss:
                Intent intent5 = new Intent(SuaSach_activity.this, MainActivity.class);
                startActivity(intent5);
                break;
        }

        animationItem = item.getItemId();

        return true;
    }
    public void updateSach(){
        SachDatabase db = new SachDatabase(this);
        Sach s = new Sach();
        s.setId(Integer.parseInt(getIntent().getStringExtra("sach_id")));
        s.setTenSach(txtTenSach.getText().toString());
        s.setTenTG(txtTenTG.getText().toString());
        s.setNSX(txtNXB.getText().toString());
        db.updateSach(s);
    }
}
