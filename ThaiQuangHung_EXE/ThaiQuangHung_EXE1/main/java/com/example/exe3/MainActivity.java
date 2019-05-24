package com.example.exe3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonAn;
    ArrayList<MonAn> mangMonAn;

    static int animationItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonAn = (ListView) findViewById(R.id.listViewMonAn);
        mangMonAn = new ArrayList<MonAn>();

        mangMonAn.add(new MonAn("Phở", 20000, R.drawable.pho));
        mangMonAn.add(new MonAn("Bắp", 10000, R.drawable.bap));
        mangMonAn.add(new MonAn("Cá", 30000, R.drawable.ca));
        mangMonAn.add(new MonAn("Canh", 15000, R.drawable.canh));
        mangMonAn.add(new MonAn("Chè", 20000, R.drawable.che));
        mangMonAn.add(new MonAn("Ốc", 30000, R.drawable.oc));
        mangMonAn.add(new MonAn("thit", 40000, R.drawable.thit));
        mangMonAn.add(new MonAn("Phở", 20000, R.drawable.pho));
        mangMonAn.add(new MonAn("Bắp", 10000, R.drawable.bap));
        mangMonAn.add(new MonAn("Cá", 30000, R.drawable.ca));
        mangMonAn.add(new MonAn("Canh", 15000, R.drawable.canh));
        mangMonAn.add(new MonAn("Chè", 20000, R.drawable.che));
        mangMonAn.add(new MonAn("Ốc", 30000, R.drawable.oc));
        mangMonAn.add(new MonAn("thit", 40000, R.drawable.thit));

        MonAnAdapter anAdapter = new MonAnAdapter(
                MainActivity.this, R.layout.dong_mon_an, mangMonAn
        );

        lvMonAn.setAdapter(anAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        animationItem = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
