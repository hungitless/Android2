package com.example.quayso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void QuaySo(View view) {
        Toast.makeText(this, "Chuc May Man ", Toast.LENGTH_SHORT).show();
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.vongquay);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.quayso);
        imageView.startAnimation(animation1);
    }
}
