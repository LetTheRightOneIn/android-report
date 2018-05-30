package com.example.a12481.wordbook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a12481.wordbook.db.Words;
import com.example.a12481.wordbook.db.WordsSQLiteOpenHelper;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.List;

public class VocabularyAdapter extends ArrayAdapter {
    private int resourceId;
    public VocabularyAdapter(Context context, int textViewResourceId, List<Words> objects){
        super(context,textViewResourceId,objects);
        resourceId =textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Words word = (Words) getItem(position);
        View view   = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView wordkey = (TextView)view.findViewById(R.id.word_key);
        TextView wordfy= (TextView)view.findViewById(R.id.word_fy);
        TextView wordposAcceptation= (TextView)view.findViewById(R.id.word_posAcceptation);
        wordkey.setText(word.getKey());
        wordfy.setText(String.valueOf(word.getFy()));
        wordposAcceptation.setText(String.valueOf(word.getPosAcceptation()));

        return view;
    }
}
