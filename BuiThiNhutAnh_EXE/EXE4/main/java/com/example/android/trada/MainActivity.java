package com.example.android.trada;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView phrases, colors, family, numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

    }
    public void setControl(){
         phrases = (TextView)findViewById(R.id.phrases);
         colors = (TextView)findViewById(R.id.colors);
         family = (TextView)findViewById(R.id.family);
         numbers = (TextView)findViewById(R.id.numbers);
    }

    public void setEvent(){
        numbers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });


        family.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);

                startActivity(familyIntent);
            }
        });

        colors.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);

                startActivity(colorsIntent);
            }
        });


        phrases.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });
    }

}