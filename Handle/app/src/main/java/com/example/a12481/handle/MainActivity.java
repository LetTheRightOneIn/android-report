package com.example.a12481.handle;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import android.view.textclassifier.TextClassification;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            textView.setText("(꒪Д꒪)ノ");//第二种更新ui的方法
        }
    };

    //第一种用handler更新UI的方法
    private void handler1(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(" щ(ﾟДﾟщ) ");
            }
        });
    }

    //第二种用handler更新UI的方法
    private  void handler2(){
        handler.sendEmptyMessage(1);//此处发送消息给handler,然后handler接收消息并处理消息进而更新ui
    }


    //第三种用handler更新UI的方法
    private void  handler3(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("っﾟДﾟ)っ");
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    handler1();
                    Thread.sleep(1000);
                    handler2();
                    Thread.sleep(1000);
                    handler3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

}



