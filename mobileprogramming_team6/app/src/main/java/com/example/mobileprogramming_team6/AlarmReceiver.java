package com.example.mobileprogramming_team6;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver(){}

    NotificationManager manager;
    NotificationCompat.Builder builder;

    // 안드로이드 8.0 이상부터는 알림 설정을 위해서 채널 설정이 필요
    private static final String CHANNEL_ID = "alarm_channel";
    private static final String CHANNEL_NAME = "Alarm_Channel";

    // NotificationManagerCompat.notify()에 전달하는 알림 고유 ID
    // 알림 업데이트나 삭제 시 필요
    static final int notificaitonId = 0;

    @Override
    public void onReceive(Context context, Intent intent){
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        builder = null;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ // 8.0 이상일 경우 알림 채널 생성
            manager.createNotificationChannel(
                    new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            );
            builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        }
        else{ // 8.0 미만일 경우 채널 설정 불필요
            builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        }

        // 알림 탭 클릭시 activity 화면 호출
        Intent intent1 = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentText("공모주 일정 알림")
                .setContentText("새로운 공모주 일정이 있습니다") // 가능하면 청약일, 상장일 알림 문구를 다르게 하고 싶음
                .setAutoCancel(true) // 알림 클릭시 해당 페이지로 이동하며 알림 자동 삭제
                .setPriority(NotificationCompat.PRIORITY_DEFAULT) // 중요도 설정, 안드로이드 7.1 이하 버전에서만 사용
                .setContentIntent(pendingIntent)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC); // 잠금화면 공개 상태 설정, VISIBILITY_PUBLIC: 잠금 화면에 알림 전체 콘텐츠 표시

        Notification notification = builder.build();
        manager.notify(notificaitonId, notification);
    }
}
