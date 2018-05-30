package com.example.a12481.wordbook;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.example.a12481.wordbook.R;
import com.example.a12481.wordbook.db.Vocabulary;
import com.example.a12481.wordbook.db.Words;
import com.example.a12481.wordbook.db.WordsSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class VocabularyActivity extends AppCompatActivity{
    private ListView listView;
    private List<Words>WordList =new ArrayList<>();
    private VocabularyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        WordsSQLiteOpenHelper helper = new WordsSQLiteOpenHelper(this, "Words", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor c = db.query("Words", null, null,null, null, null, null);

        adapter = new VocabularyAdapter(VocabularyActivity.this,R.layout.vocabulary_item,WordList);
        listView = (ListView)findViewById(R.id.vocabulary_listView);
        if(c.moveToFirst()) {
           do {
                Words words = new Words();
                words.setKey(c.getString(c.getColumnIndex("key")));
                Log.d("测试", "数据库" + words.getKey());
                words.setFy(c.getString(c.getColumnIndex("fy")));
                words.setPosAcceptation(c.getString(c.getColumnIndex("posAcceptation")));
                WordList.add(words);
            }while(c.moveToNext());
        }
        c.close();
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final EditText text1= (EditText)findViewById(R.id.edit_text);
        text1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str =String.valueOf(editable);
                WordsSQLiteOpenHelper helper = new WordsSQLiteOpenHelper(VocabularyActivity.this, "Words", null, 1);
                SQLiteDatabase db = helper.getWritableDatabase();
                Cursor c = db.query("Words", null, "key like ?",new String[]{"%"+str+"%"}, null, null, null);
                WordList.clear();
                if(c.moveToFirst()){
                    do{
                        Words words = new Words();
                        words.setKey(c.getString(c.getColumnIndex("key")));
                        Log.d("测试", "数据库" + words.getKey());
                        words.setFy(c.getString(c.getColumnIndex("fy")));
                        words.setPosAcceptation(c.getString(c.getColumnIndex("posAcceptation")));
                        WordList.add(words);
                    }while (c.moveToNext());
                }
                c.close();
                adapter.notifyDataSetChanged();
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WordList.remove(l);
                WordsSQLiteOpenHelper helper = new WordsSQLiteOpenHelper(VocabularyActivity.this, "Words", null, 1);
                SQLiteDatabase db = helper.getWritableDatabase();
                Words words=WordList.get(i);
                String str=words.getKey();
                db.delete("Words","key=?",new String[]{str});
                text1.setText(text1.getText());
            }
        });
    }

}
