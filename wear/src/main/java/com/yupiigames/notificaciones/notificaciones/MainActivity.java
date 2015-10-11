package com.yupiigames.notificaciones.notificaciones;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                //mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
    }

    /**
     * Handles the button to launch a notification.
     */
    public void showNotification(View view) {
        buildWearableOnlyNotification(getResources().getString(R.string.title_notification), getResources()
                .getString(R.string.content_notification));
        finish();
    }

    /**
     * Builds a simple notification on the wearable.
     */
    private void buildWearableOnlyNotification(String title, String content) {
        Notification.Builder builder = new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title).setContentText(content);

        ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(1, builder.build());
    }
}
