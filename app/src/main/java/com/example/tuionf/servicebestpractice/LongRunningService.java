package com.example.tuionf.servicebestpractice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Date;

public class LongRunningService extends Service {
    private static final String TAG = "LongRunningService";
    public LongRunningService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: "+new Date().toString());
            }
        }).start();

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long time = SystemClock.elapsedRealtime()+1000*10;
        Intent intent2 = new Intent(this,AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent2,0);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,time,pendingIntent);

        return super.onStartCommand(intent, flags, startId);
    }
}

