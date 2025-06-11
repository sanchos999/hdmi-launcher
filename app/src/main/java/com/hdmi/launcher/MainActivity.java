package com.hdmi.launcher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log; // Добавлен импорт для логгирования

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("HDMITEST", "MainActivity стартовала!"); // Отметим запуск

        // Таймер на 20 секунд
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("HDMITEST", "Прошло 20 секунд, пытаюсь отправить интент HDMI");

                try {
                    // Отправляем интент на переключение HDMI1 (HW5)
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("content://android.media.tv/passthrough/com.oneway.tv/.hdmi.HDMIInputService/HW5"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                    Log.d("HDMITEST", "Интент HDMI отправлен успешно");
                } catch (Exception e) {
                    Log.e("HDMITEST", "Ошибка при отправке интента: " + e.toString());
                }

                // Выходим
                finish();
            }
        }, 10000);
    }
}
