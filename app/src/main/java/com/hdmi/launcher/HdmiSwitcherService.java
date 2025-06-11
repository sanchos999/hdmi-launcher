package com.hdmi.launcher;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class HdmiSwitcherService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("HDMITEST", "Service стартовал, жду 10 сек...");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("HDMITEST", "Прошло 10 сек, пытаюсь переключить HDMI");
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("content://android.media.tv/passthrough/com.oneway.tv/.hdmi.HDMIInputService/HW5"));
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);

                    Log.d("HDMITEST", "Интент HDMI отправлен из сервиса");
                } catch (Exception e) {
                    Log.e("HDMITEST", "Ошибка: " + e.toString());
                }
                stopSelf();
            }
        }, 10000);
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) { return null; }
}
