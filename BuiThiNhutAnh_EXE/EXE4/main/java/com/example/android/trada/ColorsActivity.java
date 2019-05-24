package com.example.android.trada;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    ListView listView;
    //Quản lý việc phát các file âm thanh
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        setControl();
        setEvent();
    }
    public void setEvent(){
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Đỏ", "Red",R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Vàng", "Yellow", R.drawable.color_yellow, R.raw.color_yellow));
        words.add(new Word("Xanh lá cây", "Green", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Nâu", "Brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Xám", "Gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("Đen", "Black", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("Trắng", "White", R.drawable.color_white, R.raw.color_white));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);
        listView.setAdapter(adapter);

        //Tạo click listener để phát âm thanh khi bấm vào item trong list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
    public void setControl(){
         listView = (ListView) findViewById(R.id.list);
    }
}
