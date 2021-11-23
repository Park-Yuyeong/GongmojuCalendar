package com.example.mobileprogramming_team6;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AlarmActivity extends AppCompatActivity {
    private AlarmManager alarmManager;
    private GregorianCalendar mCalendar;

    private NotificationManager notificationManager;
    NotificationCompat.Builder builder;

    String date = "2021-11-24"; // 임의의 날짜 설정정

   @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        mCalendar = new GregorianCalendar();

        Log.v("HelloAlarmActivity", mCalendar.getTime().toString());

        setContentView(R.layout.activity_main);

        // 알람 버튼, 임시(프엔 작성 후 맞게 수정)
        //Button button = (Button) findViewById(R.id.btnNoti);
        //button.setOnClickListener(new View.OnClickListener(){
            //@Override
            //public void onClick(View v){
                //setAlarm();
            //}
       //});

       setAlarm(); // 왜 안되는가..?
    }

    private void setAlarm(){
        // AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0, receiverIntent, 0);

        String form = date + " 00:19:00"; // test
        // String form = date + " 22:00:00"; // 실제 구현시 알람이 울리는 시각

        // 날짜 포맷을 바꿔주는 소스코드
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = null;
        try{
            datetime = dateFormat.parse(form);
        } catch (ParseException e){
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);

        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
   }
}
