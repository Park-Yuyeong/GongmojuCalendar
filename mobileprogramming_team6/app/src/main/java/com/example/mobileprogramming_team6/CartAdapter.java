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
    private AlarmManager alarmManager;
    private GregorianCalendar mCalendar;

    private NotificationManager notificationManager;
    NotificationCompat.Builder builder;

    String date = "2021-11-25"; // 임의의 날짜 설정

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
                if (holder.btnNoti.isSelected()){
                    holder.btnNoti.setSelected(false);

                    editor.putBoolean(holder.tvName.getText().toString(), false);
                    editor.commit();

                    cancelAlarm();
                }
                else{
                    holder.btnNoti.setSelected(true);

                    editor.putBoolean(holder.tvName.getText().toString(), true);
                    editor.commit();

                    notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                    alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

                    mCalendar = new GregorianCalendar();

                    setAlarm();
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
            this.btnNoti = itemView.findViewById(R.id.btnNoti);
        }
    }

    // 알림 on
    private void setAlarm(){
        // AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent, 0);

        Log.d("setAlarm", "setAlarm() start!!");

        String form = date + " 16:10:00"; // test
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

        Log.d("setAlarm", form + "에 알람 울림!");

        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
    }

    // 알람 off
    private void cancelAlarm(){
        Intent cancelIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, cancelIntent, 0);

        Log.d("cancelAlarm", "cancelAlarm() start!!");

        Log.d("setAlarm", "알림 해제!!");

        alarmManager.cancel(pendingIntent);
    }
}
