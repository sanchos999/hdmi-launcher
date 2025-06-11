package com.hdmi.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("HDMITEST", "MainActivity: запускаю HdmiSwitcherService и финиширую");
        startService(new Intent(this, HdmiSwitcherService.class));
        finish(); // ОБЯЗАТЕЛЬНО!
    }
}
