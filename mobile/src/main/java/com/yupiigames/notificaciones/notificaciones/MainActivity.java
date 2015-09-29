package com.yupiigames.notificaciones.notificaciones;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Add onClickListener to button one
        findViewById(R.id.button_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked(v);
            }
        });
        //Add onClickListener to button one
        findViewById(R.id.button_notification_with_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClickedWithAction(v);
            }
        });
    }

    public void onButtonClicked(View v) {
        createNotification(false);
    }

    public void onButtonClickedWithAction(View v) {
        createNotification(true);
    }

    private void createNotification(boolean with_action) {
        // Build intent for notification content
        Intent viewIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yupiigames.com/"));
        PendingIntent viewPendingIntent = PendingIntent.getActivity(this, 0, viewIntent, 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_notification).setContentTitle("Title notification").setContentText("Text of the notification")
                .setContentIntent(viewPendingIntent).setTicker("Notification launched");
        if (with_action) {
            // Build an intent for an action to view a map
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.co/maps"));
            PendingIntent mapPendingIntent = PendingIntent.getActivity(this, 0, mapIntent, 0);
            notificationBuilder.addAction(R.mipmap.ic_notification, getString(R.string.map), mapPendingIntent);
        }
        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // Build the notification and issues it with notification manager.
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
