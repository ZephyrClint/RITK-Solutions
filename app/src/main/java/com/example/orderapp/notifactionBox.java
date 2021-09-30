package com.example.orderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class notifactionBox extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "OrderPlaced")
                .setSmallIcon(R.drawable.hotpot)
                .setContentTitle("Your Yummiest food basket being prepared.")
                .setContentText("Try out our delicious food menus right now! ")
                .setPriority(NotificationCompat.PRIORITY_HIGH);


        NotificationManagerCompat noteManager = NotificationManagerCompat.from(context);

        noteManager.notify( 200, builder.build());

        //playsound
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(context.getApplicationContext(), notification);
        r.play();




    }
}
