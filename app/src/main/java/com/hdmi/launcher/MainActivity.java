package com.hdmi.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Пустой чёрный layout (UI должен быть!):
        LinearLayout ll = new LinearLayout(this);
        ll.setBackgroundColor(0xFF000000);
        setContentView(ll);

        // Запуск сервиса через 1 секунду
        new Handler().postDelayed(() -> {
            Log.d("HDMITEST", "MainActivity: запускаю HdmiSwitcherService");
            startService(new Intent(this, HdmiSwitcherService.class));
        }, 1000);
    }
}
