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

        // Показываем пустой layout (важно для HOME activity)
        setContentView(new LinearLayout(this));

        // Стартуем сервис через небольшую задержку (или сразу)
        new Handler().postDelayed(() -> {
            Log.d("HDMITEST", "MainActivity: запускаю HdmiSwitcherService");
            startService(new Intent(this, HdmiSwitcherService.class));
            // НЕ вызываем finish()!
        }, 500);
    }
}
