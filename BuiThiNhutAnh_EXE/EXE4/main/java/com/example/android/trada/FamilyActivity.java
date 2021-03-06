package com.example.android.trada;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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
        words.add(new Word("Bố", "Father", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Mẹ", "Mother", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Con trai", "Son", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("Con gái", "Daughter", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("Anh trai", "Older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("Em trai", "Younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("Chị gái", "Older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("Em gái", "Younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("Bà", "Grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("Ông", "Grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

                mMediaPlayer.start();
            }
        });
    }
    public void setControl(){
         listView = (ListView) findViewById(R.id.list);
    }
}
