package com.hdmi.launcher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Делаем Activity полностью прозрачной — без вызова setContentView()

        // Таймер на 20 секунд
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Отправляем интент на переключение HDMI1 (HW5)
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://android.media.tv/passthrough/com.oneway.tv/.hdmi.HDMIInputService/HW5"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                // Выходим
                finish();
            }
        }, 20000);
    }
}
