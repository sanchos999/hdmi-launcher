package com.example.hdmilauncher;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import java.io.IOException;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> {
            try {
                Runtime.getRuntime().exec("input keyevent 243");
            } catch (IOException e) {
                e.printStackTrace();
            }
            finish();
        }, 5000);
    }
}