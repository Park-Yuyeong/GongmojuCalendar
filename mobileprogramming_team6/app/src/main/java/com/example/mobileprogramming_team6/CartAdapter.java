package com.example.mobileprogramming_team6;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.shapes.Shape;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<Cart> arrayList;
    private Context context;

    // 알림 기능 구현 시 필요한 변수들
    //private AlarmManager alarmManager;
    private AlarmManager am_list;
    private AlarmManager am_subs;
    private GregorianCalendar mCalendar;

    private NotificationManager notificationManager;
    NotificationCompat.Builder builder;

    String date = "2021-11-25"; // 임의의 날짜 설정
    String listDate; // 상장일 string
    String subsDate; // 청약일 string

    // 알림 상태 저장 prefences
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public CartAdapter(ArrayList<Cart> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        CartViewHolder holder = new CartViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvListingDate.setText(arrayList.get(position).getListingDate());
        holder.tvSubscriptDate.setText(arrayList.get(position).getSubscriptDate());

<<<<<<< HEAD
=======
        // 알림 상태 저장을 위한 코드
        pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        editor = pref.edit();

        boolean temp = pref.getBoolean(holder.tvName.getText().toString(), false);
        if (temp == true){
            holder.btnNoti.setSelected(true);
        }
        else {
            holder.btnNoti.setSelected(false);
        }

>>>>>>> upstream/main
        int randomNum = (int)(Math.random() * 10);
        if(randomNum < 5){
            holder.linearlayout.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.shape_yellow));

        }
        if(randomNum  >= 5){
            holder.linearlayout.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.shape_pink));
        }

        // 알림 버튼 on&off
        holder.btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listDate = makeDateString(2021, 10, Integer.parseInt(holder.tvListingDate.getText().toString()));
                subsDate = makeDateString(2021, 11, Integer.parseInt(holder.tvSubscriptDate.getText().toString()));

                if (holder.btnNoti.isSelected()){
                    if (am_list == null && am_subs == null){
                        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                        am_list = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                        am_subs = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

                        mCalendar = new GregorianCalendar();

                        Log.d("string?", holder.tvListingDate.getText().toString());

                        setAlarm_list();
                        setAlarm_subs();
                    }
                    else if (am_list == null){
                        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                        am_subs = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

                        mCalendar = new GregorianCalendar();

                        Log.d("string?", holder.tvListingDate.getText().toString());

                        setAlarm_subs();
                    }
                    holder.btnNoti.setSelected(false);

                    editor.putBoolean(holder.tvName.getText().toString(), false);
                    editor.commit();

                    if (am_list == null){
                        cancelAlarm_subs();
                    }
                    else{
                        cancelAlarm_list();
                        cancelAlarm_subs();
                    }
                }
                else{
                    holder.btnNoti.setSelected(true);

                    editor.putBoolean(holder.tvName.getText().toString(), true);
                    editor.commit();

                    notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                    am_list = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    am_subs = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

                    mCalendar = new GregorianCalendar();

                    Log.d("string?", holder.tvListingDate.getText().toString());
                    setAlarm_list();
                    setAlarm_subs();

                    try {
                        if(!nowCompare(subsDate)){
                            cancelAlarm_list();
                            cancelAlarm_subs();
                            return;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    try {
                        if (!nowCompare(listDate)){
                            cancelAlarm_list();
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //삼항연사자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvName; // 기업명
        TextView tvSubscriptDate; // 상장일
        TextView tvListingDate; // 청약일
        LinearLayout linearlayout;

        Button btnNoti; // 알림 버튼

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.tvSubscriptDate = itemView.findViewById(R.id.tvSubscriptDate);
            this.tvListingDate = itemView.findViewById(R.id.tvListingDate);
            this.linearlayout = itemView.findViewById(R.id.linearlayout);
<<<<<<< HEAD


=======
            this.btnNoti = itemView.findViewById(R.id.btnNoti);
>>>>>>> upstream/main
        }
    }

    private String makeDateString(int year, int month, int day){
        month += 1;
        date = year + "-" + month + "-"+ day;
        return date;
    }

    private boolean nowCompare(String date) throws ParseException {
        long now = System.currentTimeMillis();
        Date nowDate = new Date(now);
        Date comparedate = null;

        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");

        String nowFormat = dataFormat.format(nowDate);

        Log.d("currentTime", "현재 시각: " + nowFormat);

        try {
            comparedate = dataFormat.parse(date);
            nowDate = dataFormat.parse(nowFormat);
        } catch (ParseException e){
            e.printStackTrace();;
        }

        int compare = nowDate.compareTo(comparedate);

        if (compare >= 0){
            return false;
        }
        else{
            return true;
        }
    }

    // 청약일 알림 on
    private void setAlarm_list(){
        // AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent, 0);

        Log.d("setAlarm", "setAlarm() start!!");

        //String form = date + " 16:10:00"; // test
        String form = listDate + " 22:00:00"; // 실제 구현시 알람이 울리는 시각

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

        Log.d("setAlarm", form + "에 알람 울림!");

        am_list.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
    }

    // 상장일 알림 on
    private void setAlarm_subs(){
        // AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent, 0);

        Log.d("setAlarm", "setAlarm() start!!");

        //String form = date + " 16:10:00"; // test
        String form = subsDate + " 22:00:00"; // 실제 구현시 알람이 울리는 시각

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

        Log.d("setAlarm", form + "에 알람 울림!");

        am_subs.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
    }

    // 청약일 알람 off
    private void cancelAlarm_list(){
        Intent cancelIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, cancelIntent, 0);

        Log.d("cancelAlarm", "cancelAlarm() start!!");

        Log.d("setAlarm", "알림 해제!!");

        am_list.cancel(pendingIntent);
    }

    // 상장일 알람 off
    private void cancelAlarm_subs(){
        Intent cancelIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, cancelIntent, 0);

        Log.d("cancelAlarm", "cancelAlarm() start!!");

        Log.d("setAlarm", "알림 해제!!");

        am_subs.cancel(pendingIntent);
    }
}
