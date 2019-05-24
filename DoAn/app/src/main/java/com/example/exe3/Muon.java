package com.example.exe3;

import android.content.Intent;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Muon extends AppCompatActivity {
    ActionBarDrawerToggle mToggle;

    static int animationItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muon_sach);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.them:
                Intent intent = new Intent(Muon.this, ThemSach_activity.class);
                startActivity(intent);
                break;
            case R.id.muon:
                Intent intent2 = new Intent(Muon.this, Muon.class);
                startActivity(intent2);
                break;

            case R.id.logout:
                Intent intent4 = new Intent(Muon.this, Login_activity.class);
                startActivity(intent4);
                break;
            case R.id.dss:
                Intent intent5 = new Intent(Muon.this, MainActivity.class);
                startActivity(intent5);
                break;
        }

        animationItem = item.getItemId();

        return true;
    }

}
