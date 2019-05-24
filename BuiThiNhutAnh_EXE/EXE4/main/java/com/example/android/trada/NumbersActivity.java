package com.example.android.trada;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    ListView listView;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        setControl();
        setEvent();
    }

    public void setEvent() {
        //Tạo mảng chứa các từ
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Một", "One", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Hai", "Two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Ba", "Three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Bốn", "Four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Năm", "Five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Sáu", "Six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Bảy", "Seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Tám", "Eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Chín", "Nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Mười", "Ten", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Nhận biết từ nào đang được bấm vào bằng cách xác định vị trí bấm
                Word word = words.get(position);

                //Tạo và cài đặt file âm thanh gắn với từ đang được chọn
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                //Phát file âm thanh
                mMediaPlayer.start();
            }
        });
    }

    public void setControl() {
        listView = (ListView) findViewById(R.id.list);
    }
}
