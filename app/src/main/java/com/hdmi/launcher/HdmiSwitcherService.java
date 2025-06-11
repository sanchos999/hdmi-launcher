package com.hdmi.launcher;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class HdmiSwitcherService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("HDMITEST", "HdmiSwitcherService: эмулируем KEYCODE_TV_INPUT (243)");
        new Thread(() -> {
            try {
                // Эмуляция нажатия "KEYCODE_TV_INPUT"
                Process proc = Runtime.getRuntime().exec(new String[]{"input", "keyevent", "243"});
                int result = proc.waitFor();
                Log.d("HDMITEST", "Keyevent отправлен, код выхода: " + result);
            } catch (Exception e) {
                Log.e("HDMITEST", "Ошибка при эмуляции keyevent: " + Log.getStackTraceString(e));
            }
            stopSelf();
        }).start();

        // Не пересоздавать сервис
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
