package com.tuktukhop.audio.aadcpreparation.samples

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.tuktukhop.audio.aadcpreparation.R

fun showNotification(context: Context, notification: Notification){
    val notificationId = 111
    with(NotificationManagerCompat.from(context)) {
        // notificationId is a unique int for each notification that you must define
        notify(notificationId, notification)
    }
}

fun createNotification(
    context: Context, targetActivity: Class<Activity>,
    channelId: String,
    title: String,
    contentText: String,
    smallIcon : Int = R.drawable.ic_launcher_foreground,
    priority : Int = NotificationCompat.PRIORITY_DEFAULT,
    autoCancel: Boolean = true,
    channelName: String = "DEFAULT CHANNEL NAME",
    channelDescription : String = "DEFAULT CHANNEL DESC"
): Notification {
// The priority determines how intrusive the notification should be on
// Android 7.1 and lower. (For Android 8.0 and higher,
// you must instead set the channel importance—shown in the next section.)
    val intent = createIntent(context, targetActivity)
    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
    val builder = createNotificationBuilder(context, channelId, title,
        contentText, pendingIntent, smallIcon, priority, autoCancel)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, channelName, importance)
            .apply { description = channelDescription }
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    return builder.build()
}

private fun createNotificationBuilder(context: Context, channelId: String, title: String, contentText: String,
                                      pendingIntent : PendingIntent, smallIcon : Int = R.drawable.ic_launcher_foreground,
                                      priority : Int = NotificationCompat.PRIORITY_DEFAULT,
                                      autoCancel: Boolean = true
                                      ): NotificationCompat.Builder {

//    val snoozeIntent = Intent(this, MyBroadcastReceiver::class.java).apply {
//        action = ACTION_SNOOZE
//        putExtra(EXTRA_NOTIFICATION_ID, 0)
//    }
//    val snoozePendingIntent: PendingIntent =
//        PendingIntent.getBroadcast(this, 0, snoozeIntent, 0)

    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(smallIcon)
        .setContentTitle(title)
        .setContentText(contentText)
//            .setStyle(NotificationCompat.BigTextStyle()
//                .bigText("Much longer text that cannot fit one line")
        .setContentIntent(pendingIntent)
        .setPriority(priority)
        .setAutoCancel(autoCancel)
//        .addAction(R.drawable.ic_snooze, getString(R.string.snooze),
//            snoozePendingIntent)
}

private fun createIntent(context: Context, targetActivity: Class<Activity>): Intent? {
    return Intent(context, targetActivity).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
}

// Direct reply
// https://developer.android.com/training/notify-user/build-notification#reply-action

// Progress bar
// https://developer.android.com/training/notify-user/build-notification#progressbar

// Urgent message
// https://developer.android.com/training/notify-user/build-notification#urgent-message

// Other info
// https://developer.android.com/training/notify-user/build-notification