package com.example.android.trada;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    //ID màu nền cho danh sách từ vựng
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> pWords, int colorResourceId) {
        super(context,0, pWords);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if(row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word current_word = getItem(position);

        TextView enTextView = (TextView) row.findViewById(R.id.en_text_view);
        enTextView.setText(current_word.getEnTranslation());

        TextView viTextView = (TextView) row.findViewById(R.id.vi_text_view);
        viTextView.setText(current_word.getViTranslation());

        ImageView imageView = (ImageView) row.findViewById(R.id.image);

        if (current_word.hasImage()) {
            imageView.setImageResource(current_word.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = row.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return row;
    }

}
