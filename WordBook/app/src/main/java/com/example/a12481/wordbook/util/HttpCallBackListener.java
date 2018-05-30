package com.example.a12481.wordbook.util;


import java.io.BufferedReader;
import java.io.InputStream;

public interface HttpCallBackListener {
    void onFinish(InputStream inputStream);

    void onError();
}
