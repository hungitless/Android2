package com.example.android.trada;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    ListView listView;
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
        words.add(new Word("Xin chào!", "Hello!", R.raw.phrase_hello));
        words.add(new Word("Bạn tên là gì?", "What is your name?", R.raw.phrase_what_is_your_name));
        words.add(new Word("Tôi tên là...", "My name is...", R.raw.phrase_my_name_is));
        words.add(new Word("Bạn cảm thấy thế nào?", "How are you feeling?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("Rất tốt.", "Very good.", R.raw.phrase_very_good));
        words.add(new Word("Anh ta là...", "He is...", R.raw.phrase_he_is));
        words.add(new Word("Cô ấy là...", "Her name is...", R.raw.phrase_her_name_is));
        words.add(new Word("Tôi thích nghe nhạc.", "I like listening to music.", R.raw.phrase_i_like_listening_to_music));
        words.add(new Word("Bạn có rảnh không?", "Are you free?", R.raw.phrase_are_you_free));
        words.add(new Word("Chào mừng bạn đến Việt Nam!", "Welcome to Viet Nam!", R.raw.phrase_welcome_to_vietnam));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
    public void setControl(){
         listView = (ListView) findViewById(R.id.list);
    }
}
