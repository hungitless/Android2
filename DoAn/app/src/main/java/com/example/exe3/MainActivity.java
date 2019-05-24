package com.example.exe3;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    ListView lvSach;
    SachAdapter adapter = null;
    ArrayList<Sach> data = new ArrayList<>();
    static int animationItem;
    EditText txtMa,txtTenSach,txtTenTG,txtNXB;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();


    }

    private void setControl(){
        txtMa = (EditText) findViewById(R.id.inputMa);
        txtTenSach = (EditText) findViewById(R.id.inputTen);
        txtTenTG = (EditText) findViewById(R.id.inputTacGia);
        txtNXB = (EditText) findViewById(R.id.inputNXB);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lvSach=(ListView) findViewById(R.id.listViewSach);
    }

    public void setEvent() {
        adapter = new SachAdapter(this, R.layout.sach, data);

        lvSach.setAdapter(adapter);
        LoadData();
//        khoiTao();
//        adapter.notifyDataSetChanged();
        lvSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sach sach = data.get(position);
                //Toast.makeText(MainActivity.this, sach., Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SuaSach_activity.class);
                intent.putExtra("sach_id", sach.getId());
                intent.putExtra("sach_name", sach.getTenSach());
                intent.putExtra("sach_nxb", sach.getNSX());
                intent.putExtra("sach_tentacgia", sach.getTenTG());
                startActivity(intent);
            }
        } );
    }

    public void khoiTao() {
        data.add(new Sach(1, "Toan 1", "ABC", "1000", "09", R.drawable.toan1));
        data.add(new Sach(2, "Toan 2", "AAA", "1000", "09", R.drawable.toan2));
        data.add(new Sach(3, "Toan 3", "bb", "1000", "09", R.drawable.toan3));
        data.add(new Sach(4, "Toan 4", "dd", "1000", "09", R.drawable.toan4));
    }


    public void LoadData() {
        SachDatabase db = new SachDatabase(this);
        data.clear();
        db.getAllData(data);
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.them:
                Intent intent = new Intent(MainActivity.this, ThemSach_activity.class);
                startActivity(intent);
                break;
            case R.id.muon:
                Intent intent2 = new Intent(MainActivity.this, Muon.class);
                startActivity(intent2);
                break;

            case R.id.logout:
                Intent intent4 = new Intent(MainActivity.this, Login_activity.class);
                startActivity(intent4);
                break;
            case R.id.dss:
                Intent intent5 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent5);
                break;


        }

        animationItem = item.getItemId();

        return true;
    }



}
